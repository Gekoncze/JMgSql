package cz.mg.sql.builder.blocks.rows.create;

import cz.mg.sql.builder.utilities.SqlBlockBuilder;
import cz.mg.sql.builder.utilities.SqlColumnBuilder;


public class SqlValuesBlockBuilder extends SqlBlockBuilder {
    public SqlValuesBlockBuilder() {
        super("VALUES", null, new SqlColumnBuilder("(", ")", ","));
    }
}
