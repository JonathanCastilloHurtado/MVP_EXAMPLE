package jonathanc.developer.myapplication;

import android.os.Handler;
import android.util.Log;

public class SearchModel implements Search.Model {

    //la respuesta sera devuelta antes de que el tiempo de espera se cumpla
    String res;
    @Override
    public String getBook(String query) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
               res="El Libro Existe";
            }
        }, 5000);
        return res;
    }
}
