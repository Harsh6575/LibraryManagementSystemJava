module LibraryManagementSystemJava {
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.media;
    requires javafx.swing;
    requires javafx.web;
    requires javafx.controls;
//    exports Views;

    opens Controllers to javafx.fxml;
    exports application;
}