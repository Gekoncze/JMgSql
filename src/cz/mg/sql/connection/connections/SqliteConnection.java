package cz.mg.sql.connection.connections;

import cz.mg.sql.Sql;
import cz.mg.sql.SqlBind;
import cz.mg.sql.connection.SqlConnection;
import cz.mg.sql.connection.SqlConnectionException;
import cz.mg.sql.connection.SqlResults;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class SqliteConnection implements SqlConnection {
    private final String file;
    private Connection connection;
    private boolean transactionInProgress;

    public SqliteConnection(String file) {
        this.file = file;
    }

    @Override
    public void close() {
        if(isConnected()) disconnect();
    }

    @Override
    public boolean isConnected(){
        if(connection == null) return false;
        try {
            return !connection.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }

    private void connect(){
        String url = "jdbc:sqlite:" + file;
        try {
            this.connection = DriverManager.getConnection(url);
            this.connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new SqlConnectionException(e);
        } finally {
            this.transactionInProgress = false;
        }
    }

    private void disconnect(){
        try {
            this.connection.close();
        } catch (SQLException e) {
            // nothing to do
        } finally {
            this.connection = null;
            this.transactionInProgress = false;
        }
    }

    @Override
    public void begin(){
        if(!isConnected()) connect();
        if(transactionInProgress) throw new SqlConnectionException("Transaction is already in progress.");
        transactionInProgress = true;
    }

    @Override
    public void commit(){
        assertTransaction();
        try {
            this.connection.commit();
        } catch (SQLException e) {
            throw new SqlConnectionException(e);
        } finally {
            transactionInProgress = false;
        }
    }

    @Override
    public void rollback(){
        if(!isConnected()) return;
        try {
            this.connection.rollback();
        } catch (SQLException e) {
            // transaction should be rolled back automatically
        } finally {
            transactionInProgress = false;
        }
    }

    @Override
    public void executeDdl(Sql sql) {
        assertNotTransaction();
        try (PreparedStatement statement = createStatement(sql)) {
            statement.execute();
        } catch (SQLException e) {
            throw new SqlConnectionException(e);
        }
    }

    @Override
    public void executeDml(Sql sql){
        assertTransaction();
        try (PreparedStatement statement = createStatement(sql)) {
            statement.execute();
        } catch (SQLException e) {
            throw new SqlConnectionException(e);
        }
    }

    @Override
    public SqlResults executeQuery(Sql sql){
        assertConnected();
        try (PreparedStatement statement = createStatement(sql)) {
            return SqlResults.toResults(statement.executeQuery());
        } catch (SQLException e) {
            throw new SqlConnectionException(e);
        }
    }

    private PreparedStatement createStatement(Sql sql) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sql.getText());
        int i = 0;
        for(SqlBind bind : sql.getBinds()){
            statement.setObject(i, bind);
            i++;
        }
        return statement;
    }

    private void assertConnected(){
        if(!isConnected()) throw new SqlConnectionException("Disconnected.");
    }

    private void assertTransaction(){
        assertConnected();
        if(!transactionInProgress) throw new IllegalStateException("Expected transaction in progress.");
    }

    private void assertNotTransaction(){
        assertConnected();
        if(transactionInProgress) throw new IllegalStateException("Unexpected tranaction in progress.");
    }
}
