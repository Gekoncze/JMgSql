package cz.mg.sql.builder;

import cz.mg.sql.builder.rows.SqlReadRowsBuilder;
import cz.mg.sql.builder.table.SqlCreateTableBuilder;
import cz.mg.sql.builder.table.SqlDeleteTableBuilder;
import cz.mg.sql.builder.rows.SqlCreateRowsBuilder;
import cz.mg.sql.builder.rows.SqlDeleteRowsBuilder;
import cz.mg.sql.builder.rows.SqlUpdateRowsBuilder;
import cz.mg.sql.builder.utilities.SqlRowsBuilder;
import cz.mg.sql.builder.utilities.SqlTableBuilder;


public class SqlBuilder {
    public SqlCreateRowsBuilder createRows(String table){
        return new SqlRowsBuilder().createRows(table);
    }

    public SqlReadRowsBuilder readRows(String table){
        return new SqlRowsBuilder().readRows(table);
    }

    public SqlUpdateRowsBuilder updateRows(String table){
        return new SqlRowsBuilder().updateRows(table);
    }

    public SqlDeleteRowsBuilder deleteRows(String table){
        return new SqlRowsBuilder().deleteRows(table);
    }

    public SqlCreateTableBuilder createTable(String table){
        return new SqlTableBuilder().createTable(table);
    }

    public SqlDeleteTableBuilder deleteTable(String table){
        return new SqlTableBuilder().deleteTable(table);
    }
}
