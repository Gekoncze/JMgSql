package cz.mg.sql.builder.blocks.rows.delete;

import cz.mg.sql.builder.utilities.SqlBlockBuilder;


public class SqlDeleteBlockBuilder extends SqlBlockBuilder {
    public SqlDeleteBlockBuilder(String table) {
        super("DELETE", table);
    }
}
