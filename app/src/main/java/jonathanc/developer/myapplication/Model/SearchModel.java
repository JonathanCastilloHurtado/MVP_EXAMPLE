package jonathanc.developer.myapplication.Model;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import jonathanc.developer.myapplication.interfaceSearch;

public class SearchModel extends AsyncTask<Object, String, NetworkResponse> implements interfaceSearch.Model {
    interfaceSearch.Presenter presenter;
    private String reqURL;

    public SearchModel(interfaceSearch.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    protected void onPostExecute(NetworkResponse response) {
        super.onPostExecute(response);
        if (response != null && response.isSuccess()) {
            presenter.setResponse(response.getMessage());
        } else {
            presenter.prepareError(response.getException());
        }
    }

    @Override
    protected NetworkResponse doInBackground(Object... objects) {
        reqURL = objects[0].toString();
        return makeServiceCall();
    }

    @Override
    public NetworkResponse makeServiceCall() {
        NetworkResponse response = new NetworkResponse();
        try {
            URL url = new URL(reqURL);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line).append('\n');
                }
            } catch (IOException e) {
                e.printStackTrace();
                response.setSuccess(false);
                response.setException(e);
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    response.setSuccess(false);
                    response.setException(e);
                }
            }
            response.setSuccess(true);
            response.setMessage(stringBuilder.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            response.setSuccess(false);
            response.setException(e);
        } catch (ProtocolException e) {
            e.printStackTrace();
            response.setSuccess(false);
            response.setException(e);
        } catch (IOException e) {
            e.printStackTrace();
            response.setSuccess(false);
            response.setException(e);
        }
        return response;
    }
}

