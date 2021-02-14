package cz.mg.sql.utilities;

import cz.mg.sql.rows.SqlCreateRowsBuilder;
import cz.mg.sql.rows.SqlDeleteRowsBuilder;
import cz.mg.sql.rows.SqlReadRowsBuilder;
import cz.mg.sql.rows.SqlUpdateRowsBuilder;


public class SqlRowsBuilder {
    public SqlCreateRowsBuilder createRows(String table){
        return new SqlCreateRowsBuilder().createRows(table);
    }

    public SqlReadRowsBuilder readRows(String table){
        return new SqlReadRowsBuilder().readRows(table);
    }

    public SqlUpdateRowsBuilder updateRows(String table){
        return new SqlUpdateRowsBuilder().updateRows(table);
    }

    public SqlDeleteRowsBuilder deleteRows(String table){
        return new SqlDeleteRowsBuilder().deleteRows(table);
    }
}
