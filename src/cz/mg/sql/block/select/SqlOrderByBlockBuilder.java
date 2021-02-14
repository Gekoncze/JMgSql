package cz.mg.sql.block.select;

import cz.mg.sql.utilities.SqlBlockBuilder;
import cz.mg.sql.utilities.SqlColumnBuilder;


public class SqlOrderByBlockBuilder extends SqlBlockBuilder {
    public SqlOrderByBlockBuilder() {
        super("ORDER BY", null, new SqlColumnBuilder(null, null, ","));
    }
}
