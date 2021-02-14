package cz.mg.sql.block.select;

import cz.mg.sql.utilities.SqlBlockBuilder;


public class SqlFromBlockBuilder extends SqlBlockBuilder {
    public SqlFromBlockBuilder(String table) {
        super("FROM", table);
    }
}
