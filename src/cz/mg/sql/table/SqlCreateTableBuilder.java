package cz.mg.sql.table;

import cz.mg.sql.Formatting;
import cz.mg.sql.Sql;
import cz.mg.sql.blocks.table.create.SqlCreateTableBlockBuilder;
import cz.mg.sql.utilities.SqlBaseBuilder;


public class SqlCreateTableBuilder extends SqlBaseBuilder {
    private SqlCreateTableBlockBuilder createTableBlock;

    public SqlCreateTableBuilder() {
    }

    public SqlCreateTableBuilder createTable(String table) {
        getBlocks().addLast(createTableBlock = new SqlCreateTableBlockBuilder(table));
        return this;
    }

    public SqlCreateTableBuilder column(String name, String datatype){
        createTableBlock.addColumn(name + " " + datatype);
        return this;
    }

    @Override
    public Sql build(Formatting formatting) {
        assertOnce(SqlCreateTableBlockBuilder.class);
        return super.build(formatting);
    }
}
