package cz.mg.sql.builder.blocks.rows.read;

import cz.mg.sql.builder.utilities.SqlBlockBuilder;
import cz.mg.sql.builder.utilities.SqlColumnBuilder;


public class SqlWhereBlockBuilder extends SqlBlockBuilder {
    public SqlWhereBlockBuilder() {
        super("WHERE", null, new SqlColumnBuilder(null, null, " AND"));
    }
}
