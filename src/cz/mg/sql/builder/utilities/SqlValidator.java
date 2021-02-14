package cz.mg.sql.builder.utilities;

import cz.mg.collections.Collection;
import cz.mg.collections.array.Array;
import cz.mg.sql.SqlBind;


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

    public static void validateName(String name){
        for(int i = 0; i < name.length(); i++){
            char ch = name.charAt(i);
            if(!isAllowedNameCharacter(ch, i == 0)){
                throw new IllegalArgumentException("Illegal character '" + ch + "' in name '" + name + "'.");
            }
        }
    }

    private static boolean isAllowedNameCharacter(char ch, boolean begin){
        if(begin){
            return isAllowedAlphabetic(ch);
        } else {
            return isAllowedAlphanumeric(ch) || isAllowedSpecial(ch);
        }
    }

    private static boolean isAllowedAlphanumeric(char ch){
        return isAllowedAlphabetic(ch) || isAllowedNumber(ch);
    }

    private static boolean isAllowedAlphabetic(char ch){
        return isAllowedUpperCase(ch) || isAllowedLowerCase(ch);
    }

    private static boolean isAllowedNumber(char ch){
        return ch >= '0' && ch <= '9';
    }

    private static boolean isAllowedUpperCase(char ch){
        return ch >= 'A' && ch <= 'Z';
    }

    private static boolean isAllowedLowerCase(char ch){
        return ch >= 'a' && ch <= 'z';
    }

    private static boolean isAllowedSpecial(char ch){
        return ch == '_';
    }
}
