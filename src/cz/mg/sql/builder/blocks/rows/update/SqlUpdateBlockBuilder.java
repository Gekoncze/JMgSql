package cz.mg.sql.builder.blocks.rows.update;

import cz.mg.sql.builder.utilities.SqlBlockBuilder;
import cz.mg.sql.builder.utilities.SqlColumnBuilder;


public class SqlUpdateBlockBuilder extends SqlBlockBuilder {
    public SqlUpdateBlockBuilder(String table) {
        super("UPDATE", table, new SqlColumnBuilder("SET", null, ","));
    }
}
