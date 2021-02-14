package cz.mg.sql.blocks.rows.update;

import cz.mg.sql.utilities.SqlBlockBuilder;
import cz.mg.sql.utilities.SqlColumnBuilder;


public class SqlUpdateBlockBuilder extends SqlBlockBuilder {
    public SqlUpdateBlockBuilder(String table) {
        super("UPDATE", table, new SqlColumnBuilder("SET", null, ","));
    }
}
