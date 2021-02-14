package cz.mg.sql.entities;

import cz.mg.collections.list.List;
import cz.mg.collections.list.ReadableList;
import cz.mg.sql.Sql;
import cz.mg.sql.SqlBind;
import cz.mg.sql.builder.Formatting;
import cz.mg.sql.builder.SqlBuilder;

import static cz.mg.sql.builder.utilities.SqlValidator.validateName;


public class SqlTable {
    private static final Formatting FORMATTING = Formatting.MULTI_LINE;

    private final String name;
    private final ReadableList<SqlColumn> columns;
    private final Sql createSql;
    private final Sql deleteSql;
    private final Sql createRowSql;
    private final Sql readRowSql;
    private final Sql updateRowSql;
    private final Sql deleteRowSql;

    public SqlTable(String name, SqlColumn... columns) {
        validateName(name);
        this.name = name;
        this.columns = new List<>(columns);

        String[] columnNames = new String[columns.length];
        String[] columnTypes = new String[columns.length];

        for(int i = 0; i < columns.length; i++){
            columnNames[i] = columns[i].getName();
            columnTypes[i] = columns[i].getType();
        }

        this.createSql = new SqlBuilder()
            .createTable(name)
            .columns(columnNames, columnTypes)
            .build(FORMATTING);

        this.deleteSql = new SqlBuilder()
            .deleteTable(name)
            .build(FORMATTING);

        this.createRowSql = new SqlBuilder()
            .createRows(name)
            .columns(columnNames)
            .build(FORMATTING);

        this.readRowSql = new SqlBuilder()
            .readRows(name)
            .columns(columnNames)
            .where(columnNames[0] + " = ?", new SqlBind(columnNames[0]))
            .build(FORMATTING);

        this.updateRowSql = new SqlBuilder()
            .updateRows(name)
            .columns(columnNames)
            .where(columnNames[0] + " = ?", new SqlBind(columnNames[0]))
            .build(FORMATTING);

        this.deleteRowSql = new SqlBuilder()
            .deleteRows(name)
            .where(columnNames[0] + " = ?", new SqlBind(columnNames[0]))
            .build(FORMATTING);
    }

    public String getName() {
        return name;
    }

    public ReadableList<SqlColumn> getColumns() {
        return columns;
    }

    public Sql getCreateSql() {
        return createSql;
    }

    public Sql getDeleteSql() {
        return deleteSql;
    }

    public Sql getCreateRowSql() {
        return createRowSql;
    }

    public Sql getReadRowSql() {
        return readRowSql;
    }

    public Sql getUpdateRowSql() {
        return updateRowSql;
    }

    public Sql getDeleteRowSql() {
        return deleteRowSql;
    }
}
