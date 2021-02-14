package cz.mg.sql.entities;

import static cz.mg.sql.builder.utilities.SqlValidator.validateName;


public class SqlColumn {
    private final String name;
    private final String type;

    public SqlColumn(String name, String type) {
        validateName(name);
        validateName(type);
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
