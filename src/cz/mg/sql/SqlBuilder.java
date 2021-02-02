package cz.mg.sql;


public class SqlBuilder {
    private final Formatting formatting;

    public SqlBuilder(Formatting formatting) {
        this.formatting = formatting;
    }

    public SqlSelectBuilder select(String column, String alias, Object... binds){
        return new SqlSelectBuilder(formatting).select(column, alias, binds);
    }
}
