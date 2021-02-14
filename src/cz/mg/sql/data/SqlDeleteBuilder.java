package cz.mg.sql.data;

import cz.mg.sql.Formatting;
import cz.mg.sql.Sql;
import cz.mg.sql.SqlBind;
import cz.mg.sql.block.delete.SqlDeleteBlockBuilder;
import cz.mg.sql.block.select.SqlWhereBlockBuilder;
import cz.mg.sql.utilities.SqlBaseBuilder;


public class SqlDeleteBuilder extends SqlBaseBuilder {
    private SqlDeleteBlockBuilder deleteBlock;
    private SqlWhereBlockBuilder whereBlock;

    public SqlDeleteBuilder delete(String table) {
        getBlocks().addLast(deleteBlock = new SqlDeleteBlockBuilder(table));
        return this;
    }

    public SqlDeleteBuilder where(String condition, SqlBind... binds){
        if(whereBlock == null){
            getBlocks().addLast(whereBlock = new SqlWhereBlockBuilder());
        }
        whereBlock.addColumn(condition, binds);
        return this;
    }
    
    @Override
    public Sql build(Formatting formatting) {
        assertOnce(SqlDeleteBlockBuilder.class);
        assertOnceOptional(SqlWhereBlockBuilder.class);
        assertOrder(
            SqlDeleteBlockBuilder.class,
            SqlWhereBlockBuilder.class
        );
        return super.build(formatting);
    }
}
