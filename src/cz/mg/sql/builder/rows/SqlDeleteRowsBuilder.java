package cz.mg.sql.builder.rows;

import cz.mg.sql.builder.blocks.rows.delete.SqlDeleteBlockBuilder;
import cz.mg.sql.builder.blocks.rows.read.SqlWhereBlockBuilder;
import cz.mg.sql.builder.Formatting;
import cz.mg.sql.Sql;
import cz.mg.sql.SqlBind;
import cz.mg.sql.builder.utilities.SqlBaseBuilder;


public class SqlDeleteRowsBuilder extends SqlBaseBuilder {
    private SqlDeleteBlockBuilder deleteBlock;
    private SqlWhereBlockBuilder whereBlock;

    public SqlDeleteRowsBuilder deleteRows(String table) {
        getBlocks().addLast(deleteBlock = new SqlDeleteBlockBuilder(table));
        return this;
    }

    public SqlDeleteRowsBuilder where(String condition, SqlBind... binds){
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
