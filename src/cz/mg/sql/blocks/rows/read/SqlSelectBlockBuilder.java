package cz.mg.sql.blocks.rows.read;

import cz.mg.sql.utilities.SqlBlockBuilder;
import cz.mg.sql.utilities.SqlColumnBuilder;


public class SqlSelectBlockBuilder extends SqlBlockBuilder {
    public SqlSelectBlockBuilder() {
        super("SELECT", null, new SqlColumnBuilder(null, null, ","));
    }
}
