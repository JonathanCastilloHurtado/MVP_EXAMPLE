package jonathanc.developer.myapplication;

public class SearchPresenter implements Search.Presenter {

    Search.View view;

    public SearchPresenter(Search.View view) {
        this.view = view;
    }

    @Override
    public void makeQuery(Book book) {
        String Query = "SELECT * FROM Books WHERE bookName = ";
        Query += book.bookName;
        view.startProgress();
        String resp = new SearchModel().getBook(Query);
        view.stopProgress();
        //la respuesta sera pintada antes de que el tiempo termine por lo que nunca alcanzaremos a ver los progress
        view.showResults(resp);
    }


}
