package cz.mg.sql.block.select;

import cz.mg.sql.utilities.SqlBlockBuilder;
import cz.mg.sql.utilities.SqlColumnBuilder;


public class SqlGroupByBlockBuilder extends SqlBlockBuilder {
    public SqlGroupByBlockBuilder() {
        super("GROUP BY", null, new SqlColumnBuilder(null, null, ","));
    }
}
