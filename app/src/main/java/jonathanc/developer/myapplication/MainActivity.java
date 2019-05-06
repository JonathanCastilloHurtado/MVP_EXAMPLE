package jonathanc.developer.myapplication;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

//implementamos los metodos de la interface View la cual se encuentra dentro de la interface Search
public class MainActivity extends AppCompatActivity implements Search.View {
    //creamos el objeto de tipo SearchPresenter
    SearchPresenter mSearchPresenter;
    //intanciamos elementos view/UI los cuales seran disparados desde el presenter
    TextView textView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //inicializamos
        textView = (TextView) findViewById(R.id.mTexto);
        progressDialog = new ProgressDialog(this);
        //al momento de inicializar el objeto SearchPresneter le pasamos la instancia de la interfaz de esta clase
        mSearchPresenter = new SearchPresenter(this);

        //el objeto de tipo SearchPresenter dispara su metodo
        mSearchPresenter.makeQuery(new Book(10, false, "Señor de los anillos"));
    }

    //estos metodos seran disparados/llamados desde el presenter a travez de la instancia de la interfaz de esta clase
    @Override
    public void showResults(String Result) {
        textView.setText(Result);
    }

    @Override
    public void startProgress() {
        progressDialog.setTitle("CARGANDO...");
        progressDialog.setProgress(0);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    public void stopProgress() {
        progressDialog.cancel();
        progressDialog.dismiss();
    }
}
