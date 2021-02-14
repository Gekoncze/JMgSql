package cz.mg.sql.blocks.rows.read;

import cz.mg.sql.utilities.SqlBlockBuilder;
import cz.mg.sql.utilities.SqlColumnBuilder;


public class SqlWhereBlockBuilder extends SqlBlockBuilder {
    public SqlWhereBlockBuilder() {
        super("WHERE", null, new SqlColumnBuilder(null, null, " AND"));
    }
}
