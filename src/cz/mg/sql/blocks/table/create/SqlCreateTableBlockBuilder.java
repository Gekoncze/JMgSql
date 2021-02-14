package cz.mg.sql.blocks.table.create;

import cz.mg.sql.utilities.SqlBlockBuilder;
import cz.mg.sql.utilities.SqlColumnBuilder;


public class SqlCreateTableBlockBuilder extends SqlBlockBuilder {
    public SqlCreateTableBlockBuilder(String table) {
        super("CREATE TABLE", table, new SqlColumnBuilder("(", ")", ","));
    }
}
