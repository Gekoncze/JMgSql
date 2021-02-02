package cz.mg.sql;

import cz.mg.collections.list.List;

import java.util.Objects;


public abstract class SqlBaseBuilder {
    private static final String NONE = "";
    private static final String SPACE = " ";
    private static final String NEWLINE = "\n";
    private static final String PADDING = "    ";

    private final Formatting formatting;
    private final State state;
    protected final List<Object> binds = new List<>();

    public SqlBaseBuilder(Formatting formatting, Enum initialState) {
        Objects.requireNonNull(formatting);
        this.formatting = formatting;
        this.state = new State(initialState);
    }

    protected void add(Enum state, List<String> list, String text, Object... binds){
        this.state.setState(state);
        list.addLast(text);
        addBinds(text, binds);
    }

    private void addBinds(String text, Object... binds){
        int parameterCount = countParameters(text);
        int argumentCount = binds.length;
        int count = Math.max(parameterCount, argumentCount);

        if(argumentCount > parameterCount){
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < count; i++){
            Object bind = i < binds.length ? binds[i] : null;
            this.binds.addLast(bind);
        }
    }

    protected void addBlock(StringBuilder text, String group, List<String> parts, String delimiter){
        if(parts.count() > 0){
            if(formatting == Formatting.SINGLE_LINE){
                text.append(group);
                text.append(parts.toText(SPACE, delimiter + SPACE, SPACE).toString());
            }

            if(formatting == Formatting.MULTI_LINE){
                text.append(group);
                text.append(parts.toText(NEWLINE + PADDING, delimiter + NEWLINE + PADDING, NEWLINE).toString());
            }
        }
    }

    private int countParameters(String text){
        int count = 0;
        for (int i = 0; i < text.length(); i++){
            char ch = text.charAt(i);
            if (ch == '?') count++;
        }
        return count;
    }
}
