package cz.mg.sql.data;

import cz.mg.sql.Formatting;
import cz.mg.sql.Sql;
import cz.mg.sql.SqlBind;
import cz.mg.sql.block.insert.SqlInsertIntoBlockBuilder;
import cz.mg.sql.block.insert.SqlValuesBlockBuilder;
import cz.mg.sql.utilities.SqlBaseBuilder;


public class SqlCreateBuilder extends SqlBaseBuilder {
    private SqlInsertIntoBlockBuilder insertBlock;
    private SqlValuesBlockBuilder valuesBlock;

    public SqlCreateBuilder() {
    }

    public SqlCreateBuilder create(String table) {
        getBlocks().addLast(insertBlock = new SqlInsertIntoBlockBuilder(table));
        getBlocks().addLast(valuesBlock = new SqlValuesBlockBuilder());
        return this;
    }

    public SqlCreateBuilder column(String column){
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
