package cz.mg.sql.builder.blocks.rows.read;

import cz.mg.sql.builder.utilities.SqlBlockBuilder;
import cz.mg.sql.builder.utilities.SqlColumnBuilder;


public class SqlSelectBlockBuilder extends SqlBlockBuilder {
    public SqlSelectBlockBuilder() {
        super("SELECT", null, new SqlColumnBuilder(null, null, ","));
    }
}
