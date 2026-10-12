module apo.java.practice {
    exports apo.java.practice.daily;
    exports apo.java.practice.tdd;
    requires junit;
    requires java.desktop;
    requires commons.vfs2;
    //requires apo.model;
    requires com.google.gson;
    requires kafka.clients;
    requires mysql.connector.j;
    requires java.sql;
    requires java.naming;
    requires spring.graphql;
    requires spring.web;
    requires spring.webflux;
}
