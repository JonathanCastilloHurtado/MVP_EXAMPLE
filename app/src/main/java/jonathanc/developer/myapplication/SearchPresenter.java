package jonathanc.developer.myapplication;

public class SearchPresenter implements interfaceSearch.Presenter {

    interfaceSearch.View view;

    public SearchPresenter(interfaceSearch.View view) {
        this.view = view;
    }

    @Override
    public void prepareServiceCall() {
        view.startProgress();
        new SearchModel(this).execute(BuildConfig.url);
    }

    @Override
    public void setResponse(String result) {
        view.stopProgress();
        view.showResults(result);
    }

    @Override
    public void prepareError(Exception e) {
     view.showError(e+"");
    }

}


