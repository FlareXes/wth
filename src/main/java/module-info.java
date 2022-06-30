module com.fireflaredb.bds {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires twilio;
    requires org.xerial.sqlitejdbc;

    opens com.fireflaredb.bds to javafx.fxml;
    exports com.fireflaredb.bds;
}