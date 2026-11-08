module ca.pragmaticcoding {
    requires javafx.controls;
    requires com.google.gson;
    requires kotlin.stdlib;
    requires java.net.http;
    requires org.slf4j;

    opens ca.pragmaticcoding.multimvci to javafx.controls;
    exports ca.pragmaticcoding.multimvci;
}