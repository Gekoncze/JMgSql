package cz.mg.sql.connection;

import cz.mg.sql.Sql;


public interface SqlConnection extends AutoCloseable {
    boolean isConnected();
    void begin();
    void commit();
    void rollback();
    void executeDdl(Sql sql);
    void executeDml(Sql sql);
    SqlResults executeQuery(Sql sql);
}
