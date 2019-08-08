package jonathanc.developer.myapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements interfaceSearch.View, View.OnClickListener {

    SearchPresenter presenter;
    private TextView textView;
    private Button button;
    private ProgressDialog progressDialog;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.mTexto);
        button = (Button) findViewById(R.id.consume);

        button.setOnClickListener(this);
        progressDialog = new ProgressDialog(this);
        activity = this;
        presenter = new SearchPresenter(this);
    }

    @Override
    public void showResults(final String Result) {
        runOnUiThread(new Runnable() {
            public void run() {
                textView.setText(Result);
            }
        });
    }

    @Override
    public void startProgress() {
        runOnUiThread(new Runnable() {
            public void run() {
                //progress_label = Loading...
                progressDialog.setTitle(getResources().getString(R.string.progress_label));
                progressDialog.setProgress(0);
                progressDialog.setCancelable(false);
                progressDialog.show();
            }
        });

    }

    @Override
    public void stopProgress() {
        runOnUiThread(new Runnable() {
            public void run() {
                progressDialog.cancel();
                progressDialog.dismiss();
            }
        });

    }

    @Override
    public void showError(final String error) {
        runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(activity, error, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        presenter.prepareServiceCall();
    }
}
