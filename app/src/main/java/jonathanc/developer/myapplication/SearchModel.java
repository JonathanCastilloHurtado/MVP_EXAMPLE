package jonathanc.developer.myapplication;

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

public class SearchModel extends AsyncTask<Object, String, String> implements interfaceSearch.Model {
    interfaceSearch.Presenter presenter;
    private String reqURL;

    SearchModel(interfaceSearch.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    protected String doInBackground(Object... objects) {
        reqURL = objects[0].toString();
        makeServiceCall();
        return null;
    }

    @Override
    public void makeServiceCall() {
        String response;
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
                presenter.prepareError(e);
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    presenter.prepareError(e);
                }
            }
            response = stringBuilder.toString();
            presenter.setResponse(response);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            presenter.prepareError(e);
        } catch (ProtocolException e) {
            e.printStackTrace();
            presenter.prepareError(e);
        } catch (IOException e) {
            e.printStackTrace();
            presenter.prepareError(e);
        }
    }
}

