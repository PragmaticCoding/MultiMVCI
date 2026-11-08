module ca.pragmaticcoding {
    requires javafx.controls;
    requires com.google.gson;
    requires kotlin.stdlib;
    requires org.apache.httpcomponents.client5.httpclient5;
    requires org.apache.httpcomponents.core5.httpcore5;

    opens ca.pragmaticcoding.multimvci to javafx.controls;
    exports ca.pragmaticcoding.multimvci;
}