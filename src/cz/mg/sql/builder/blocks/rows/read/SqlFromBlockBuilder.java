package cz.mg.sql.builder.blocks.rows.read;

import cz.mg.sql.builder.utilities.SqlBlockBuilder;


public class SqlFromBlockBuilder extends SqlBlockBuilder {
    public SqlFromBlockBuilder(String table) {
        super("FROM", table);
    }
}
