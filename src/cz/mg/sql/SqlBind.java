package cz.mg.sql;

public class SqlBind {
    private final String id;
    private Object bind;

    public SqlBind(String id, Object bind) {
        this.id = id;
        this.bind = bind;
    }

    public SqlBind(String id) {
        this.id = id;
        this.bind = null;
    }

    public String getId() {
        return id;
    }

    public Object getBind() {
        return bind;
    }
}
