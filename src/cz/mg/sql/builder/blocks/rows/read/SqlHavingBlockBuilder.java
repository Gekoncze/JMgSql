package cz.mg.sql.builder.blocks.rows.read;

import cz.mg.sql.builder.utilities.SqlBlockBuilder;
import cz.mg.sql.builder.utilities.SqlColumnBuilder;


public class SqlHavingBlockBuilder extends SqlBlockBuilder {
    public SqlHavingBlockBuilder() {
        super("HAVING", null, new SqlColumnBuilder(null, null, " AND"));
    }
}
