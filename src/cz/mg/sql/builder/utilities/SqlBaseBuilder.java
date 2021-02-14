package cz.mg.sql.builder.utilities;

import cz.mg.collections.array.Array;
import cz.mg.collections.list.List;
import cz.mg.sql.builder.Formatting;
import cz.mg.sql.Sql;
import cz.mg.sql.SqlBind;

import java.util.Iterator;

import static cz.mg.sql.builder.utilities.WhiteSpace.NEWLINE;
import static cz.mg.sql.builder.utilities.WhiteSpace.SPACE;


public abstract class SqlBaseBuilder {
    private final List<SqlBlockBuilder> blocks = new List<>();

    public SqlBaseBuilder() {
    }

    public List<SqlBlockBuilder> getBlocks() {
        return blocks;
    }

    public Sql build(Formatting formatting){
        StringBuilder text = new StringBuilder();
        List<SqlBind> binds = new List<>();

        String delimiter = formatting == Formatting.SINGLE_LINE ? SPACE : NEWLINE;

        for(SqlBlockBuilder block : blocks){
            Sql blockSql = block.build(formatting);
            text.append(blockSql.getText());
            binds.addCollectionLast(blockSql.getBinds());

            if(block != blocks.getLast()){
                text.append(delimiter);
            }
        }

        return new Sql(text.toString(), binds);
    }

    protected void assertOnce(Class<? extends SqlBlockBuilder> clazz){
        int count = 0;
        for(SqlBlockBuilder block : blocks){
            if(block.getClass() == clazz){
                count++;
            }
        }
        if(count != 1){
            throw new IllegalStateException("There must be exactly one " + clazz.getSimpleName() + " block.");
        }
    }

    protected void assertOnceOptional(Class<? extends SqlBlockBuilder> clazz){
        int count = 0;
        for(SqlBlockBuilder block : blocks){
            if(block.getClass() == clazz){
                count++;
            }
        }
        if(count > 1){
            throw new IllegalStateException("There can be at most one " + clazz.getSimpleName() + " block.");
        }
    }

    @SafeVarargs
    protected final void assertOrder(Class<? extends SqlBlockBuilder>... classes){
        Array<Class<? extends SqlBlockBuilder>> classArray = new Array<>(classes);
        Iterator<Class<? extends SqlBlockBuilder>> classIterator = classArray.iterator();
        Class<? extends SqlBlockBuilder> expectedClass = classIterator.next();
        for(SqlBlockBuilder block : blocks){
            while(block.getClass() != expectedClass){
                if(classIterator.hasNext()){
                    expectedClass = classIterator.next();
                } else {
                    throw new IllegalStateException("Illegal block order.");
                }
            }
        }
    }
}
