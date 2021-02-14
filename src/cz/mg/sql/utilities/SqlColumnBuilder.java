package cz.mg.sql.utilities;

import cz.mg.collections.list.List;
import cz.mg.sql.Formatting;
import cz.mg.sql.Sql;
import cz.mg.sql.SqlBind;

import static cz.mg.sql.utilities.WhiteSpace.*;


public class SqlColumnBuilder {
    private final String begin;
    private final String end;
    private final String delimiter;
    private final List<String> columns = new List<>();
    private final List<SqlBind> binds = new List<>();

    public SqlColumnBuilder(String begin, String end, String delimiter) {
        this.begin = begin;
        this.end = end;
        this.delimiter = delimiter;
    }

    public String getBegin() {
        return begin;
    }

    public String getEnd() {
        return end;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public List<String> getColumns() {
        return columns;
    }

    public List<SqlBind> getBinds() {
        return binds;
    }

    public Sql build(Formatting formatting){
        StringBuilder text = new StringBuilder();

        if(begin != null){
            text.append(begin);
        }

        String delim = delimiter == null ? NONE : delimiter;
        String padding = PADDING;

        String columnsBegin = formatting == Formatting.SINGLE_LINE ? SPACE : NEWLINE + padding;
        String columnDelimiter = formatting == Formatting.SINGLE_LINE ? delim + SPACE : delim + NEWLINE + padding;
        String columnsEnd = formatting == Formatting.SINGLE_LINE ? SPACE : NEWLINE;

        if(begin == null && formatting == Formatting.SINGLE_LINE){
            columnsBegin = NONE;
        }

        if(end == null){
            columnsEnd = NONE;
        }

        text.append(columns.toText(columnsBegin, columnDelimiter, columnsEnd).toString());

        if(end != null){
            text.append(end);
        }

        return new Sql(text.toString(), binds);
    }
}
