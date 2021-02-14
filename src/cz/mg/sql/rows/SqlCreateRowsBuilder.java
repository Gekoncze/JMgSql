package cz.mg.sql.rows;

import cz.mg.sql.Formatting;
import cz.mg.sql.Sql;
import cz.mg.sql.SqlBind;
import cz.mg.sql.blocks.rows.create.SqlInsertIntoBlockBuilder;
import cz.mg.sql.blocks.rows.create.SqlValuesBlockBuilder;
import cz.mg.sql.utilities.SqlBaseBuilder;


public class SqlCreateRowsBuilder extends SqlBaseBuilder {
    private SqlInsertIntoBlockBuilder insertBlock;
    private SqlValuesBlockBuilder valuesBlock;

    public SqlCreateRowsBuilder() {
    }

    public SqlCreateRowsBuilder createRows(String table) {
        getBlocks().addLast(insertBlock = new SqlInsertIntoBlockBuilder(table));
        getBlocks().addLast(valuesBlock = new SqlValuesBlockBuilder());
        return this;
    }

    public SqlCreateRowsBuilder column(String column){
        insertBlock.addColumn(column);
        valuesBlock.addColumn("?", new SqlBind(column));
        return this;
    }

    @Override
    public Sql build(Formatting formatting) {
        assertOnce(SqlInsertIntoBlockBuilder.class);
        assertOnce(SqlValuesBlockBuilder.class);
        assertOrder(
            SqlInsertIntoBlockBuilder.class,
            SqlValuesBlockBuilder.class
        );
        return super.build(formatting);
    }
}
