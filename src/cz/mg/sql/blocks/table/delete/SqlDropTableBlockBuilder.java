package cz.mg.sql.blocks.table.delete;

import cz.mg.sql.utilities.SqlBlockBuilder;


public class SqlDropTableBlockBuilder extends SqlBlockBuilder {
    public SqlDropTableBlockBuilder(String table) {
        super("DROP TABLE", table);
    }
}
