module ncnl.expensetracker {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.graphics;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires eu.hansolo.tilesfx;
    requires jakarta.persistence;
    requires static lombok;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.desktop;


    opens ncnl.expensetracker.model to org.hibernate.orm.core;
    opens fxml to javafx.fxml;
    exports ncnl.expensetracker.views;
    exports ncnl.expensetracker.controller;
    exports ncnl.expensetracker to javafx.graphics;
    opens ncnl.expensetracker.controller to javafx.fxml;



}