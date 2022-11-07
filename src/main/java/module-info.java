module ca.pragmaticcoding.multimvci {
    requires javafx.controls;
    requires com.google.gson;
    requires kotlin.stdlib;
    requires org.apache.httpcomponents.httpcore;


    opens ca.pragmaticcoding.multimvci to javafx.controls;
    exports ca.pragmaticcoding.multimvci;
}