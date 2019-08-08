package jonathanc.developer.myapplication;

public interface interfaceSearch {

    interface View {
        void showResults(String Result);
        void startProgress();
        void stopProgress();
        void showError(String error);
    }

    interface Presenter {
        void prepareServiceCall();
        void setResponse(String response);
        void prepareError(Exception e);
    }

    interface Model {
        void makeServiceCall();
    }
}