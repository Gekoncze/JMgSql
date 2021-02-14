package cz.mg.sql.block.insert;

import cz.mg.sql.utilities.SqlBlockBuilder;
import cz.mg.sql.utilities.SqlColumnBuilder;


public class SqlValuesBlockBuilder extends SqlBlockBuilder {
    public SqlValuesBlockBuilder() {
        super("VALUES", null, new SqlColumnBuilder("(", ")", ","));
    }
}
