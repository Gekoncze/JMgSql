package cz.mg.sql;

import cz.mg.collections.list.List;

import static cz.mg.sql.SqlSelectBuilder.States.*;


public class SqlSelectBuilder extends SqlBaseBuilder {
    private final List<String> select = new List<>();
    private final List<String> from = new List<>();
    private final List<String> join = new List<>();
    private final List<String> where = new List<>();
    private final List<String> groupBy = new List<>();
    private final List<String> having = new List<>();
    private final List<String> orderBy = new List<>();

    public SqlSelectBuilder(Formatting formatting) {
        super(formatting, SELECT);
    }

    public SqlSelectBuilder select(String column, String alias, Object... binds){
        add(SELECT, select, column + " " + alias, binds);
        return this;
    }

    public SqlSelectBuilder from(String table, String alias, Object... binds){
        add(FROM, from, table + " " + alias, binds);
        return this;
    }

    public SqlSelectBuilder join(String table, String alias, String condition, Object... binds){
        add(JOIN, join, table + " " + alias + " ON " + condition, binds);
        return this;
    }

    public SqlSelectBuilder where(String condition, Object... binds){
        add(WHERE, where, condition, binds);
        return this;
    }

    public SqlSelectBuilder groupBy(String group, Object... binds){
        add(GROUP_BY, groupBy, group, binds);
        return this;
    }

    public SqlSelectBuilder having(String condition, Object... binds){
        add(HAVING, having, condition, binds);
        return this;
    }

    public SqlSelectBuilder orderBy(String order, Object... binds){
        add(ORDER_BY, orderBy, order, binds);
        return this;
    }

    public Sql build(){
        StringBuilder text = new StringBuilder();

        if(from.count() != 1){
            throw new IllegalStateException("There must be exactly one 'from' call.");
        }

        addBlock(text, "SELECT", select, "");
        addBlock(text, "FROM", from, "");
        addBlock(text, "JOIN", join, "");
        addBlock(text, "WHERE", where, " AND");
        addBlock(text, "GROUP BY", groupBy, ",");
        addBlock(text, "HAVING", having, " AND");
        addBlock(text, "ORDER BY", orderBy, ",");

        return new Sql(text.toString(), binds);
    }

    protected enum States {
        SELECT,
        FROM,
        JOIN,
        WHERE,
        GROUP_BY,
        HAVING,
        ORDER_BY
    }
}
