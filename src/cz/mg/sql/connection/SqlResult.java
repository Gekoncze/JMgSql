package cz.mg.sql.connection;

import cz.mg.collections.map.Map;


public class SqlResult {
    private final Map<String, Object> nameMap;
    private final Map<Integer, Object> indexMap;

    public SqlResult(Map<String, Object> nameMap, Map<Integer, Object> indexMap) {
        this.nameMap = nameMap;
        this.indexMap = indexMap;
    }

    public Object get(String name){
        return nameMap.get(name);
    }

    public Object get(int i){
        return indexMap.get(i);
    }
}
