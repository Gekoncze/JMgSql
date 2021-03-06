package cz.mg.sql;

import cz.mg.collections.list.List;

import static cz.mg.sql.builder.utilities.SqlValidator.validateBinds;


public class Sql {
    private final String text;
    private final List<SqlBind> binds;

    public Sql(String text){
        this(text, new List<>());
    }

    public Sql(String text, List<SqlBind> binds) {
        validateBinds(text, binds);
        this.text = text;
        this.binds = binds;
    }

    public String getText() {
        return text;
    }

    public List<SqlBind> getBinds() {
        return binds;
    }

    public void setBind(String id, Object object){
        for(SqlBind bind : binds){
            if(bind.getId() == id){
                bind.setObject(object);
            }
        }
    }
}
