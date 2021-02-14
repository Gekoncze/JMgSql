package cz.mg.sql.builder.blocks.rows.read;

public enum Order {
    ASCENDING,
    DESCENDING;

    @Override
    public String toString() {
        switch (this) {
            case ASCENDING:
                return "ASC";
            case DESCENDING:
                return "DESC";
            default:
                throw new UnsupportedOperationException();
        }
    }
}
