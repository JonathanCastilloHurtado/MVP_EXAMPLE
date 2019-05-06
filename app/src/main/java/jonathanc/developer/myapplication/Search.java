package jonathanc.developer.myapplication;

//Esta interface es la encargada de construir la estructura de nuestro MVP
public interface Search {
    //creamos las interfaces correspondientes a M V P, las cuales a parte de marcar la pauta de que metodos/funciones usaremos
//nos ayudaran a marcar una instancia a la cual apuntar, para que los metodos puedan ser utilizados entre si
    interface View {
        void showResults(String Result);

        void startProgress();

        void stopProgress();
    }

    interface Presenter {
        void makeQuery(Book book);
    }

    interface Model {
        String getBook(String query);
    }
}
