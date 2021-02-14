package cz.mg.sql.utilities;

import cz.mg.sql.table.SqlCreateTableBuilder;
import cz.mg.sql.table.SqlDeleteTableBuilder;


public class SqlTableBuilder {
    public SqlCreateTableBuilder createTable(String table){
        return new SqlCreateTableBuilder().createTable(table);
    }

    public SqlDeleteTableBuilder deleteTable(String table){
        return new SqlDeleteTableBuilder().deleteTable(table);
    }
}
