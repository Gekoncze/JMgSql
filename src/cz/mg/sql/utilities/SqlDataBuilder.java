package cz.mg.sql.utilities;

import cz.mg.sql.data.SqlCreateBuilder;
import cz.mg.sql.data.SqlDeleteBuilder;
import cz.mg.sql.data.SqlReadBuilder;
import cz.mg.sql.data.SqlUpdateBuilder;


public class SqlDataBuilder {
    public SqlCreateBuilder create(String table){
        return new SqlCreateBuilder().create(table);
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
}
