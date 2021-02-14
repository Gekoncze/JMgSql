package cz.mg.sql.builder.blocks.rows.read;

import cz.mg.sql.builder.utilities.SqlBlockBuilder;
import cz.mg.sql.builder.utilities.SqlColumnBuilder;


public class SqlOrderByBlockBuilder extends SqlBlockBuilder {
    public SqlOrderByBlockBuilder() {
        super("ORDER BY", null, new SqlColumnBuilder(null, null, ","));
    }
}
