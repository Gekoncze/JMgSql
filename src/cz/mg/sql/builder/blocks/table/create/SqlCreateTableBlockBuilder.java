package cz.mg.sql.builder.blocks.table.create;

import cz.mg.sql.builder.utilities.SqlBlockBuilder;
import cz.mg.sql.builder.utilities.SqlColumnBuilder;


public class SqlCreateTableBlockBuilder extends SqlBlockBuilder {
    public SqlCreateTableBlockBuilder(String table) {
        super("CREATE TABLE", table, new SqlColumnBuilder("(", ")", ","));
    }
}
