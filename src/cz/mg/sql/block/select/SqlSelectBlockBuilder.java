package cz.mg.sql.block.select;

import cz.mg.sql.utilities.SqlBlockBuilder;
import cz.mg.sql.utilities.SqlColumnBuilder;


public class SqlSelectBlockBuilder extends SqlBlockBuilder {
    public SqlSelectBlockBuilder() {
        super("SELECT", null, new SqlColumnBuilder(null, null, ","));
    }
}
