package cz.mg.sql.builder.blocks.table.delete;

import cz.mg.sql.builder.utilities.SqlBlockBuilder;


public class SqlDropTableBlockBuilder extends SqlBlockBuilder {
    public SqlDropTableBlockBuilder(String table) {
        super("DROP TABLE", table);
    }
}
