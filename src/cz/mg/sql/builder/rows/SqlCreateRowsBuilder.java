package cz.mg.sql.builder.rows;

import cz.mg.sql.builder.Formatting;
import cz.mg.sql.Sql;
import cz.mg.sql.SqlBind;
import cz.mg.sql.builder.blocks.rows.create.SqlInsertIntoBlockBuilder;
import cz.mg.sql.builder.blocks.rows.create.SqlValuesBlockBuilder;
import cz.mg.sql.builder.utilities.SqlBaseBuilder;


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

    public SqlCreateRowsBuilder columns(String... columns){
        for(String column : columns){
            column(column);
        }
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
