package cz.mg.sql;

import cz.mg.sql.architecture.SqlCreateTableBuilder;
import cz.mg.sql.architecture.SqlDeleteTableBuilder;
import cz.mg.sql.architecture.SqlReadTableBuilder;
import cz.mg.sql.architecture.SqlUpdateTableBuilder;
import cz.mg.sql.data.SqlCreateBuilder;
import cz.mg.sql.data.SqlDeleteBuilder;
import cz.mg.sql.data.SqlReadBuilder;
import cz.mg.sql.data.SqlUpdateBuilder;
import cz.mg.sql.utilities.SqlDataBuilder;


public class SqlBuilder {
    public SqlCreateBuilder create(String table){
        return new SqlDataBuilder().create(table);
    }

    public SqlReadBuilder read(String table){
        return new SqlReadBuilder().read(table);
    }

    public SqlUpdateBuilder update(String table){
        return new SqlUpdateBuilder().update(table);
    }

    public SqlDeleteBuilder delete(String table){
        return new SqlDeleteBuilder().delete(table);
    }

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
