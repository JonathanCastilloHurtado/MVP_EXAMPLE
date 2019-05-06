package jonathanc.developer.myapplication;

import android.os.Handler;
import android.util.Log;

public class SearchModel implements Search.Model {

    //la respuesta sera devuelta antes de que el tiempo de espera se cumpla
    @Override
    public String getBook(String query) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Log.d("JOHN", "Buscando en base de datos");
            }
        }, 5000);
        return "El Libro Existe";
    }
}
