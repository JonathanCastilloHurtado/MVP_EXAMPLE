package jonathanc.developer.myapplication;

import android.os.Build;
import android.support.annotation.RequiresApi;

import jonathanc.developer.myapplication.Model.SearchModel;

public class SearchPresenter implements interfaceSearch.Presenter {

    interfaceSearch.View view;

    public SearchPresenter(interfaceSearch.View view) {
        this.view = view;
    }

    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    @Override
    public void prepareServiceCall() {
        view.startProgress();
        final String urlEndpoint="apis/get_book.php";
        //url = http://johncastle.com.mx/
        new SearchModel(this).execute(BuildConfig.url+urlEndpoint);
    }

    @Override
    public void setResponse(String result) {
        view.stopProgress();
        view.showResults(result);
    }

    @Override
    public void prepareError(Exception e) {
        view.stopProgress();
        view.showError(e.toString());
    }

}


