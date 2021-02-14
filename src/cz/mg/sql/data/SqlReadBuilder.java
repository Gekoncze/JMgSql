package cz.mg.sql.data;

import cz.mg.sql.Formatting;
import cz.mg.sql.Sql;
import cz.mg.sql.SqlBind;
import cz.mg.sql.block.select.*;
import cz.mg.sql.utilities.SqlBaseBuilder;
import cz.mg.sql.utilities.SqlBlockBuilder;

import static cz.mg.sql.utilities.WhiteSpace.SPACE;


public class SqlReadBuilder extends SqlBaseBuilder {
    private SqlBlockBuilder selectBlock;
    private SqlBlockBuilder fromBlock;
    private SqlWhereBlockBuilder whereBlock;
    private SqlGroupByBlockBuilder groupByBlock;
    private SqlHavingBlockBuilder havingBlock;
    private SqlOrderByBlockBuilder orderByBlock;

    public SqlReadBuilder() {
    }

    public SqlReadBuilder read(String table) {
        getBlocks().addLast(selectBlock = new SqlSelectBlockBuilder());
        getBlocks().addLast(fromBlock = new SqlFromBlockBuilder(table));
        return this;
    }

    public SqlReadBuilder read(String table, String alias) {
        getBlocks().addLast(selectBlock = new SqlSelectBlockBuilder());
        getBlocks().addLast(fromBlock = new SqlFromBlockBuilder(table + SPACE + alias));
        return this;
    }

    public SqlReadBuilder column(String column, SqlBind... binds){
        selectBlock.addColumn(column, binds);
        return this;
    }

    public SqlReadBuilder column(String column, String alias, SqlBind... binds){
        selectBlock.addColumn(column + SPACE + alias, binds);
        return this;
    }

    public SqlReadBuilder join(String table, String condition, SqlBind... binds){
        getBlocks().addLast(new SqlJoinBlockBuilder(table, condition, binds));
        return this;
    }

    public SqlReadBuilder join(String table, String alias, String condition, SqlBind... binds){
        getBlocks().addLast(new SqlJoinBlockBuilder(table, alias, condition, binds));
        return this;
    }

    public SqlReadBuilder where(String condition, SqlBind... binds){
        if(whereBlock == null){
            getBlocks().addLast(whereBlock = new SqlWhereBlockBuilder());
        }
        whereBlock.addColumn(condition, binds);
        return this;
    }

    public SqlReadBuilder groupBy(String column){
        if(groupByBlock == null){
            getBlocks().addLast(groupByBlock = new SqlGroupByBlockBuilder());
        }
        groupByBlock.addColumn(column);
        return this;
    }

    public SqlReadBuilder having(String condition, SqlBind... binds){
        if(havingBlock == null){
            getBlocks().addLast(havingBlock = new SqlHavingBlockBuilder());
        }
        havingBlock.addColumn(condition, binds);
        return this;
    }

    public SqlReadBuilder orderBy(String column, Order order){
        if(orderByBlock == null){
            getBlocks().addLast(orderByBlock = new SqlOrderByBlockBuilder());
        }
        orderByBlock.addColumn(column + SPACE + order.toString());
        return this;
    }

    @Override
    public Sql build(Formatting formatting) {
        assertOnce(SqlSelectBlockBuilder.class);
        assertOnce(SqlFromBlockBuilder.class);
        assertOnceOptional(SqlWhereBlockBuilder.class);
        assertOnceOptional(SqlGroupByBlockBuilder.class);
        assertOnceOptional(SqlHavingBlockBuilder.class);
        assertOnceOptional(SqlOrderByBlockBuilder.class);
        assertOrder(
            SqlSelectBlockBuilder.class,
            SqlFromBlockBuilder.class,
            SqlJoinBlockBuilder.class,
            SqlWhereBlockBuilder.class,
            SqlGroupByBlockBuilder.class,
            SqlHavingBlockBuilder.class,
            SqlOrderByBlockBuilder.class
        );
        return super.build(formatting);
    }
}
