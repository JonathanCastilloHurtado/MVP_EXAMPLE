package jonathanc.developer.myapplication

import android.os.AsyncTask
import java.io.*
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.ProtocolException
import java.net.URL

class Model(val presenter: InterfaceMVP.Presenter) : InterfaceMVP.Model,AsyncTask<Any, String, NetworkResponse>() {


    override fun onPostExecute(response: NetworkResponse?) {
        super.onPostExecute(response)
        if (response != null && response.isSuccess) {
            presenter?.setResponse(response.message)
        } else {
            presenter?.prepareError(response!!.exception)
        }
    }

    override fun doInBackground(vararg objects: Any): NetworkResponse? {
        val reqURL = objects[0].toString()
        return makeServiceCall(reqURL)
    }

    override fun makeServiceCall(reqURL: String?): NetworkResponse? {
        val response = NetworkResponse()
        try {
            val url = URL(reqURL)
            val urlConnection = url.openConnection() as HttpURLConnection
            urlConnection.requestMethod = "GET"
            val `in`: InputStream = BufferedInputStream(urlConnection.inputStream)
            val reader = BufferedReader(InputStreamReader(`in`))
            val stringBuilder = StringBuilder()
            var line: String?
            try {
                while (reader.readLine().also { line = it } != null) {
                    stringBuilder.append(line).append('\n')
                }
            } catch (e: IOException) {
                e.printStackTrace()
                response.isSuccess = false
                response.exception = e
            } finally {
                try {
                    `in`.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                    response.isSuccess = false
                    response.exception = e
                }
            }
            response.isSuccess = true
            response.message = stringBuilder.toString()
        } catch (e: MalformedURLException) {
            e.printStackTrace()
            response.isSuccess = false
            response.exception = e
        } catch (e: ProtocolException) {
            e.printStackTrace()
            response.isSuccess = false
            response.exception = e
        } catch (e: IOException) {
            e.printStackTrace()
            response.isSuccess = false
            response.exception = e
        }
        return response
    }
}