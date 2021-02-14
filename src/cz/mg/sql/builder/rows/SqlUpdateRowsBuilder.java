package cz.mg.sql.builder.rows;

import cz.mg.sql.builder.blocks.rows.read.SqlWhereBlockBuilder;
import cz.mg.sql.builder.Formatting;
import cz.mg.sql.Sql;
import cz.mg.sql.SqlBind;
import cz.mg.sql.builder.blocks.rows.update.SqlUpdateBlockBuilder;
import cz.mg.sql.builder.utilities.SqlBaseBuilder;


public class SqlUpdateRowsBuilder extends SqlBaseBuilder {
    private SqlUpdateBlockBuilder updateBlock;
    private SqlWhereBlockBuilder whereBlock;

    public SqlUpdateRowsBuilder() {
    }

    public SqlUpdateRowsBuilder updateRows(String table) {
        getBlocks().addLast(updateBlock = new SqlUpdateBlockBuilder(table));
        return this;
    }

    public SqlUpdateRowsBuilder column(String column) {
        updateBlock.addColumn(column + " = ?", new SqlBind(column));
        return this;
    }

    public SqlUpdateRowsBuilder where(String condition, SqlBind... binds){
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
