package jonathanc.developer.myapplication;

public class SearchModel  implements Search.Model{
    @Override
    public String getBook(String query) {
//se busca el libro en la base con su query
        presenter.getBooks(list );
        return "EL LIBRO EXISTE";
    }
}
