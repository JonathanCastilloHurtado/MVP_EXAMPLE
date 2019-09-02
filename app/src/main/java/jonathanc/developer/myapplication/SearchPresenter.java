package jonathanc.developer.myapplication;

//implementamos los metodos(el comportamiento) de la interfaz Search que contiene la interfaz presenter
public class SearchPresenter implements Search.Presenter {

    Search.View view;
    Search.Model model;

    //recibimos la instancia de la clase contenedora de la interfaz y la asignamos a la intancia de esta clase
    public SearchPresenter(Search.View view) {
        this.view = view;
        this.model = new SearchModel(this);
    }

    //metodos de la interfaz presenter

    //metodo encargado de construir el query para la busqueda de datos en el model
    @Override
    public void makeQuery(Book book) {
        // antes de realizar la llamada al model, inicializamos una accion en la UI la cual mandaremos llamar desde la intancia View que frecibimos,
        // gracias a esto, no tendremos que encarganos de decirle que elementos UI/view tiene que usar el metodo, ya que la clase contenedora de la intancia view
        // debe saber eso ya que esta en sus responsabilidades.
        view.startProgress();
        //en la creacion del objeto SearchModel, se le pasa como parametro la intancia de esta clase para que model pueda ocupar los metodos de esta clse
        //sin la necesidad de interactuar con variables o responsabilidades de esta clase.
        model.getBookByName(book.bookName);
    }

    //este metodo sera disparado desde el model atraves de la instancia de esta clase
    @Override
    public void setQuery(String result) {
        //utilizando la instancia view que contiene esta clase, iteractuaremos con los metodos de view, pero sin la necesidad de conocer o meternos
        //con sus responsabilidades o variables
        view.stopProgress();
        view.showResults(result);
    }

}
