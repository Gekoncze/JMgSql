package cz.mg.sql.table;

import cz.mg.sql.Formatting;
import cz.mg.sql.Sql;
import cz.mg.sql.blocks.table.delete.SqlDropTableBlockBuilder;
import cz.mg.sql.utilities.SqlBaseBuilder;


public class SqlDeleteTableBuilder extends SqlBaseBuilder {
    public SqlDeleteTableBuilder() {
    }

    public SqlDeleteTableBuilder deleteTable(String table) {
        getBlocks().addLast(new SqlDropTableBlockBuilder(table));
        return this;
    }

    @Override
    public Sql build(Formatting formatting) {
        assertOnce(SqlDropTableBlockBuilder.class);
        return super.build(formatting);
    }
}
