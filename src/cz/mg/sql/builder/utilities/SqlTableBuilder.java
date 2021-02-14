package cz.mg.sql.builder.utilities;

import cz.mg.sql.builder.table.SqlCreateTableBuilder;
import cz.mg.sql.builder.table.SqlDeleteTableBuilder;


public class SqlTableBuilder {
    public SqlCreateTableBuilder createTable(String table){
        return new SqlCreateTableBuilder().createTable(table);
    }

    public SqlDeleteTableBuilder deleteTable(String table){
        return new SqlDeleteTableBuilder().deleteTable(table);
    }
}
