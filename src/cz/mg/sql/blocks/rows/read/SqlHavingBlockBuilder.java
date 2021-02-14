package cz.mg.sql.blocks.rows.read;

import cz.mg.sql.utilities.SqlBlockBuilder;
import cz.mg.sql.utilities.SqlColumnBuilder;


public class SqlHavingBlockBuilder extends SqlBlockBuilder {
    public SqlHavingBlockBuilder() {
        super("HAVING", null, new SqlColumnBuilder(null, null, " AND"));
    }
}
