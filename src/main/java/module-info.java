module com.application.compbuilder {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires sqlite.jdbc;
    requires mysql.connector.java;

    opens com.application.compbuilder to javafx.fxml;
    exports com.application.compbuilder;
}