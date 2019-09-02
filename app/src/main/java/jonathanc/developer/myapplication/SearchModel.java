package jonathanc.developer.myapplication;

import android.os.Handler;
import android.util.Log;
//implementamos los metodos(el comportamiento) de la interfaz Search que contiene la interfaz Model
public class SearchModel implements Search.Model {
    Search.Presenter presenter;
    //recibimos la instancia de la clase contenedora de la interfaz y la asignamos a la intancia de esta clase
    SearchModel(Search.Presenter presenter) {
        this.presenter = presenter;
    }
    //metodos de la interfaz Model
    @Override
    public void getBookByName(String bookName) {
        /**
         * Gerus - Aquí va el quey
         * String Query = "SELECT * FROM Books WHERE bookName = ";
         * Cambia el handle por la petición como el MVC
         * - Los strings harcodeados, etc ...
         * - Cambiar por asyntask como te había comentado.
         */
        //este handler simulara el tiempo de respuesta de la busqueda en la base de datos
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                //una vez que realmente encontro el resultado, a travez de la intancia a presenter que recibimos como parametro en el constructor,
                //notificamos al presenter la respuesta de la busqueda, esto sin la necesidad de conocer o tocar las responsabilidades del presenter
                presenter.setQuery("El Libro Existe");
            }
        }, 5000);
    }
}
