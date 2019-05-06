package jonathanc.developer.myapplication;

public interface Search {

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
