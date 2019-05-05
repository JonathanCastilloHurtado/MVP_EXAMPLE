package jonathanc.developer.myapplication;

public class SearchPresenter implements Search.Presenter {
    Search.View view;

    public SearchPresenter(Search.View view) {
        this.view = view;
    }


    @Override
    public String makeQuery(Book book) {
        String Query="SELECT * FROM Books WHERE bookName = ";
        Query+= book.bookName;


        String result=new SearchModel().getBook(Query);

        view.loading();
                model.getBooks():
        view.showResults(result);


       return result;
    }

    getvokdd
    viewjodee


}
