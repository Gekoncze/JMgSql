package cz.mg.sql.blocks.rows.create;

import cz.mg.sql.utilities.SqlBlockBuilder;
import cz.mg.sql.utilities.SqlColumnBuilder;


public class SqlInsertIntoBlockBuilder extends SqlBlockBuilder {
    public SqlInsertIntoBlockBuilder(String table) {
        super("INSERT INTO", table, new SqlColumnBuilder("(", ")", ","));
    }
}
