// Last updated: 9/18/2025, 8:38:38 PM
class Spreadsheet {
    int[][] map;
    public Spreadsheet(int rows) {
        map = new int[rows + 1][26];
    }
    
    public void setCell(String cell, int value) {
        int j = cell.charAt(0) - 'A';
        int i = Integer.parseInt(cell.substring(1));
        map[i][j] = value;
    }
    
    public void resetCell(String cell) {
        setCell(cell, 0);
    }
    
    public int getValue(String formula) {
        formula = formula.substring(1);
        String[] tokens = formula.split("\\+");
        String a = tokens[0], b = tokens[1];
        int x = 0, y = 0;
        if (Character.isLetter(a.charAt(0))) {
            int j = a.charAt(0) - 'A';
            int i = Integer.parseInt(a.substring(1));
            x = map[i][j];
        }
        else {
            x = Integer.parseInt(a);
        }
        if (Character.isLetter(b.charAt(0))) {
            int n = b.charAt(0) - 'A';
            int m = Integer.parseInt(b.substring(1));            
            y = map[m][n];
        }
        else {
            y = Integer.parseInt(b);
        }
        return x + y;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */