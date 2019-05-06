package jonathanc.developer.myapplication;

//Objeto de tipo book el cual sera enviado para ser buscasdo en la base de datos de books
public class Book {

    int currentPage;
    boolean hasMore;
    String bookName;

    public Book(int currentPage, boolean hasMore, String bookName) {
        this.currentPage = currentPage;
        this.hasMore = hasMore;
        this.bookName = bookName;
    }


}
