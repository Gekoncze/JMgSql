package cz.mg.sql;

public class SqlBind {
    private final String id;
    private Object object;

    public SqlBind(String id, Object object) {
        this.id = id;
        this.object = object;
    }

    public SqlBind(String id) {
        this.id = id;
        this.object = null;
    }

    public String getId() {
        return id;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
