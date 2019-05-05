package jonathanc.developer.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Search.View{
    SearchPresenter mSearchPresenter;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView= (TextView) findViewById(R.id.mTexto);
        mSearchPresenter = new SearchPresenter(this);
    }


    @Override
    public void showResults(String Result) {
        textView.setText(Result);
    }
}
