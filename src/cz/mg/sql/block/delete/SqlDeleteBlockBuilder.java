package cz.mg.sql.block.delete;

import cz.mg.sql.utilities.SqlBlockBuilder;


public class SqlDeleteBlockBuilder extends SqlBlockBuilder {
    public SqlDeleteBlockBuilder(String table) {
        super("DELETE", table);
    }
}
