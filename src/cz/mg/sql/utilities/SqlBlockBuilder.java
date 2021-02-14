package cz.mg.sql.utilities;

import cz.mg.collections.list.List;
import cz.mg.sql.Formatting;
import cz.mg.sql.Sql;
import cz.mg.sql.SqlBind;

import static cz.mg.sql.utilities.WhiteSpace.SPACE;


public abstract class SqlBlockBuilder {
    private final String keywords;
    private final String name;
    private final SqlColumnBuilder column;
    private final List<SqlBind> binds = new List<>();

    public SqlBlockBuilder(String keywords, String name) {
        this.keywords = keywords;
        this.name = name;
        this.column = null;
    }

    public SqlBlockBuilder(String keywords, String name, SqlColumnBuilder column) {
        this.keywords = keywords;
        this.name = name;
        this.column = column;
    }

    public String getKeywords() {
        return keywords;
    }

    public String getName() {
        return name;
    }

    public SqlColumnBuilder getColumn() {
        return column;
    }

    public List<SqlBind> getBinds() {
        return binds;
    }

    public void addColumn(String text, SqlBind... binds){
        column.getColumns().addLast(text);
        column.getBinds().addCollectionLast(binds);
    }

    public Sql build(Formatting formatting){
        String header = union(keywords, name).toText(SPACE).toString();

        if(column == null){
            return new Sql(header, binds);
        } else {
            StringBuilder text = new StringBuilder(header);
            if(header.length() > 0) text.append(SPACE);
            Sql columnSql = column.build(formatting);
            text.append(columnSql.getText());
            return new Sql(text.toString(), union(binds, columnSql.getBinds()));
        }
    }

    private List<String> union(String... texts){
        List<String> textList = new List<>();
        for(String text : texts){
            if(text != null){
                textList.addLast(text);
            }
        }
        return textList;
    }

    private List<SqlBind> union(List<SqlBind>... binds){
        List<SqlBind> allBinds = new List<>();
        for(List<SqlBind> partialBinds : binds){
            allBinds.addCollectionLast(partialBinds);
        }
        return allBinds;
    }
}
