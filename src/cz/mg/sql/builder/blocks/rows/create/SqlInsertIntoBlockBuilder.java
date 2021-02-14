package cz.mg.sql.builder.blocks.rows.create;

import cz.mg.sql.builder.utilities.SqlBlockBuilder;
import cz.mg.sql.builder.utilities.SqlColumnBuilder;


public class SqlInsertIntoBlockBuilder extends SqlBlockBuilder {
    public SqlInsertIntoBlockBuilder(String table) {
        super("INSERT INTO", table, new SqlColumnBuilder("(", ")", ","));
    }
}
