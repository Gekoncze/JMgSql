package cz.mg.sql;

import cz.mg.collections.list.List;


public class Sql {
    private final String text;
    private final List<Object> binds;

    public Sql(String text, List<Object> binds) {
        this.text = text;
        this.binds = binds;
    }

    public String getText() {
        return text;
    }

    public List<Object> getBinds() {
        return binds;
    }
}
