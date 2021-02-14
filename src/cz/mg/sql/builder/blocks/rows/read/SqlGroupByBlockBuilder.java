package cz.mg.sql.builder.blocks.rows.read;

import cz.mg.sql.builder.utilities.SqlBlockBuilder;
import cz.mg.sql.builder.utilities.SqlColumnBuilder;


public class SqlGroupByBlockBuilder extends SqlBlockBuilder {
    public SqlGroupByBlockBuilder() {
        super("GROUP BY", null, new SqlColumnBuilder(null, null, ","));
    }
}
