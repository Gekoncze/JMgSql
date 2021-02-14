package cz.mg.sql;

import cz.mg.collections.Collection;
import cz.mg.collections.array.Array;


public class SqlValidator {
    public static void validateBinds(String text, SqlBind[] binds){
        validateBinds(text, new Array<>(binds));
    }

    public static void validateBinds(String text, Collection<SqlBind> binds){
        int parameterCount = countParameters(text);
        int argumentCount = binds.count();
        if(parameterCount != argumentCount){
            throw new IllegalStateException("Parameter vs argument count mismatch: " + parameterCount + " vs " + argumentCount + ".");
        }
    }

    private static int countParameters(String text){
        int count = 0;
        for (int i = 0; i < text.length(); i++){
            char ch = text.charAt(i);
            if (ch == '?') count++;
        }
        return count;
    }
}
