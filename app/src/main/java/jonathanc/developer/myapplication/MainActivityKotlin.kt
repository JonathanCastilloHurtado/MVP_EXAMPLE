package jonathanc.developer.myapplication

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivityKotlin : AppCompatActivity(), InterfaceMVP.View,View.OnClickListener {

    lateinit var progressDialog:ProgressDialog
    lateinit var textView : TextView
    lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_kotlin)
        textView = findViewById(R.id.mTexto) as TextView
        button = findViewById(R.id.consume) as Button

        button.setOnClickListener(this)
        progressDialog = ProgressDialog(this)
    }


    override fun showResults(Result: String?) {
        textView.setText(Result)
    }

    override fun startProgress() { //progress_label = Loading...
        progressDialog.setTitle(resources.getString(R.string.progress_label))
        progressDialog.setProgress(0)
        progressDialog.setCancelable(false)
        progressDialog.show()
    }

    override fun stopProgress() {
        progressDialog.cancel()
        progressDialog.dismiss()
    }

    override fun showError(error: String?) {
        textView.setText(error)
    }

    override fun onClick(view: View?) {
        Presenter(this).prepareServiceCall()
    }
}
