package jonathanc.developer.myapplication


interface InterfaceMVP {

    interface View {
        fun showResults(Result: String?)
        fun startProgress()
        fun stopProgress()
        fun showError(error: String?)
    }

    interface Presenter {
        fun prepareServiceCall()
        fun setResponse(response: String?)
        fun prepareError(e: Exception?)
    }

    interface Model {
        fun makeServiceCall(reqURL: String?): NetworkResponse?
    }
}