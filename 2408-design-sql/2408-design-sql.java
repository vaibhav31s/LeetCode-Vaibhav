class SQL {
    HashMap<String, table> tables = new HashMap<>();
    public SQL(List<String> names, List<Integer> columns) {
        for(int i = 0; i <  names.size(); i++){
            String name = names.get(i);
            int cols = columns.get(i);
            tables.put(name,new table());
        }
    }
    
    public void insertRow(String name, List<String> row) {
        table t = tables.get(name);
        t.list.put(t.ind, row);
        t.ind++;
    }
    
    public void deleteRow(String name, int rowId) {
        table t = tables.get(name);
        t.list.remove(rowId);
    }
    
    public String selectCell(String name, int rowId, int columnId) {
        table t = tables.get(name);
        if(!t.list.containsKey(rowId)) return "";
        String s = t.list.get(rowId).get(columnId-1);
        return s;
    }
}
class table{
    HashMap<Integer,List<String>> list = new HashMap<>();
    int ind = 1;
}

/**
 * Your SQL object will be instantiated and called as such:
 * SQL obj = new SQL(names, columns);
 * obj.insertRow(name,row);
 * obj.deleteRow(name,rowId);
 * String param_3 = obj.selectCell(name,rowId,columnId);
 */