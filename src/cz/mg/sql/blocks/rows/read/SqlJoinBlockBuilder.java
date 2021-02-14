package cz.mg.sql.blocks.rows.read;

import cz.mg.sql.SqlBind;
import cz.mg.sql.utilities.SqlBlockBuilder;

import static cz.mg.sql.utilities.WhiteSpace.SPACE;


public class SqlJoinBlockBuilder extends SqlBlockBuilder {
    public SqlJoinBlockBuilder(String table, String condition, SqlBind... binds) {
        super("JOIN", table + " ON " + condition);
        getBinds().addCollectionLast(binds);
    }

    public SqlJoinBlockBuilder(String table, String alias, String condition, SqlBind... binds) {
        super("JOIN", table + SPACE + alias + " ON " + condition);
        getBinds().addCollectionLast(binds);
    }
}
