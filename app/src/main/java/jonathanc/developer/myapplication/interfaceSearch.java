package jonathanc.developer.myapplication;

import jonathanc.developer.myapplication.Model.NetworkResponse;

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
        NetworkResponse makeServiceCall(String reqURL);
    }
}
