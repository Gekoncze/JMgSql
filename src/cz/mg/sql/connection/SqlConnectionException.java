package cz.mg.sql.connection;

public class SqlConnectionException extends RuntimeException {
    public SqlConnectionException(String message) {
        super(message);
    }

    public SqlConnectionException(Throwable cause) {
        super(cause);
    }
}
