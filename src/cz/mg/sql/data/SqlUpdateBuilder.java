package cz.mg.sql.data;

import cz.mg.sql.Formatting;
import cz.mg.sql.Sql;
import cz.mg.sql.SqlBind;
import cz.mg.sql.block.select.SqlWhereBlockBuilder;
import cz.mg.sql.block.update.SqlUpdateBlockBuilder;
import cz.mg.sql.utilities.SqlBaseBuilder;


public class SqlUpdateBuilder extends SqlBaseBuilder {
    private SqlUpdateBlockBuilder updateBlock;
    private SqlWhereBlockBuilder whereBlock;

    public SqlUpdateBuilder() {
    }

    public SqlUpdateBuilder update(String table) {
        getBlocks().addLast(updateBlock = new SqlUpdateBlockBuilder(table));
        return this;
    }

    public SqlUpdateBuilder column(String column) {
        updateBlock.addColumn(column + " = ?", new SqlBind(column));
        return this;
    }

    public SqlUpdateBuilder where(String condition, SqlBind... binds){
        if(whereBlock == null){
            getBlocks().addLast(whereBlock = new SqlWhereBlockBuilder());
        }
        whereBlock.addColumn(condition, binds);
        return this;
    }

    @Override
    public Sql build(Formatting formatting) {
        assertOnce(SqlUpdateBlockBuilder.class);
        assertOnceOptional(SqlWhereBlockBuilder.class);
        assertOrder(
            SqlUpdateBlockBuilder.class,
            SqlWhereBlockBuilder.class
        );
        return super.build(formatting);
    }
}
