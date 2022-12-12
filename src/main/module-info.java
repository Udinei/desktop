module conta.desktop {
    // usar conta sistema core
    requires conta.sistema; // linkando com outro modulo java core

    // usar spring
    requires javax.inject;
    requires spring.tx;
    requires spring.core;
    requires spring.beans;
    requires spring.context;
    requires java.sql;

    // usar javafx
    requires javafx.controls;
    // uso conta servicos

    // abre telas e builds
    opens conta.tela;
    opens conta.dsv;
    opens conta.hml;
    opens conta.prd;

    requires conta.servicos;
    requires spring.jdbc;
    requires org.hsqldb;


}
