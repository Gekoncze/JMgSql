package cz.mg.sql;

import cz.mg.sql.table.SqlCreateTableBuilder;
import cz.mg.sql.table.SqlDeleteTableBuilder;
import cz.mg.sql.rows.SqlCreateRowsBuilder;
import cz.mg.sql.rows.SqlDeleteRowsBuilder;
import cz.mg.sql.rows.SqlReadRowsBuilder;
import cz.mg.sql.rows.SqlUpdateRowsBuilder;
import cz.mg.sql.utilities.SqlRowsBuilder;
import cz.mg.sql.utilities.SqlTableBuilder;


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
