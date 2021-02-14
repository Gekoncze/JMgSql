package cz.mg.sql.entities;

import cz.mg.collections.list.List;
import cz.mg.collections.list.ReadableList;
import cz.mg.sql.Sql;
import cz.mg.sql.builder.Formatting;
import cz.mg.sql.builder.SqlBuilder;

import static cz.mg.sql.builder.utilities.SqlValidator.validateName;


public class SqlTable {
    private final String name;
    private final ReadableList<SqlColumn> columns;
    private final Sql createSql;
    private final Sql deleteSql;

    public SqlTable(String name, SqlColumn... columns) {
        validateName(name);
        this.name = name;
        this.columns = new List<>(columns);

        this.createSql = new SqlBuilder()
            .createTable(name)
            .build(Formatting.MULTI_LINE);

        this.deleteSql = new SqlBuilder()
            .deleteTable(name)
            .build(Formatting.MULTI_LINE);
    }

    public String getName() {
        return name;
    }

    public ReadableList<SqlColumn> getColumns() {
        return columns;
    }

    public Sql getCreateSql(){
        return createSql;
    }

    public Sql getDeleteSql() {
        return deleteSql;
    }
}
