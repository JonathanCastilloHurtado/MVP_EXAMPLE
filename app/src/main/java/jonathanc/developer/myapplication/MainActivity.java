package jonathanc.developer.myapplication;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Search.View, View.OnClickListener {
    SearchPresenter mSearchPresenter;
    TextView textView;
    ProgressDialog progressDialog;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.mTexto);
        button = (Button) findViewById(R.id.button);
        progressDialog = new ProgressDialog(this);
        mSearchPresenter = new SearchPresenter(this);
        button.setOnClickListener(this);
    }

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

    @Override
    public void onClick(View v) {
        mSearchPresenter.makeQuery(new Book(10, false, "Señor de los anillos"));
    }
}
