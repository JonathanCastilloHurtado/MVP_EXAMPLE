package jonathanc.developer.myapplication

import android.os.Build
import android.support.annotation.RequiresApi

class Presenter (val view: InterfaceMVP.View?) :  InterfaceMVP.Presenter {


    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    override fun prepareServiceCall() {
        view?.startProgress()
        val urlEndpoint = "apis/get_book.php"
        //url = http://johncastle.com.mx/
        Model(this).execute(BuildConfig.url + urlEndpoint)
    }

    override fun setResponse(result: String?) {
        view?.stopProgress()
        view?.showResults(result)
    }

    override fun prepareError(e: Exception?) {
        view?.stopProgress()
        view?.showError(e.toString())
    }


}
