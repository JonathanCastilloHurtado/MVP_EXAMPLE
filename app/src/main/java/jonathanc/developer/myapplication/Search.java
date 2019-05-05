package jonathanc.developer.myapplication;

import android.widget.TextView;

public interface Search {

    interface View {
        void showResults(String Result);
    }

    interface Presenter {
       String makeQuery(Book book);
    }

    interface Model{
        String getBook(String query);
    }
}
