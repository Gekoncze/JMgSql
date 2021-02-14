package cz.mg.sql.utilities;

import cz.mg.sql.architecture.SqlCreateTableBuilder;
import cz.mg.sql.architecture.SqlDeleteTableBuilder;
import cz.mg.sql.architecture.SqlReadTableBuilder;
import cz.mg.sql.architecture.SqlUpdateTableBuilder;


public class SqlArchitectureBuilder {
    public SqlCreateTableBuilder createTable(String table){
        return new SqlCreateTableBuilder().createTable(table);
    }

    public SqlReadTableBuilder readTable(String table){
        return new SqlReadTableBuilder().readTable(table);
    }

    public SqlUpdateTableBuilder updateTable(String table){
        return new SqlUpdateTableBuilder().updateTable(table);
    }

    public SqlDeleteTableBuilder deleteTable(String table){
        return new SqlDeleteTableBuilder().deleteTable(table);
    }
}
