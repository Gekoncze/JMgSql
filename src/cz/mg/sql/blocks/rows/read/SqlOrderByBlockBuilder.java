package cz.mg.sql.blocks.rows.read;

import cz.mg.sql.utilities.SqlBlockBuilder;
import cz.mg.sql.utilities.SqlColumnBuilder;


public class SqlOrderByBlockBuilder extends SqlBlockBuilder {
    public SqlOrderByBlockBuilder() {
        super("ORDER BY", null, new SqlColumnBuilder(null, null, ","));
    }
}
