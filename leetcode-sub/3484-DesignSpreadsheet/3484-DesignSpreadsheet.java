// Last updated: 9/18/2025, 8:41:26 PM
class Spreadsheet {
    int[][] map;
    public Spreadsheet(int rows) {
        map = new int[rows + 1][26];
    }
    
    public void setCell(String cell, int value) {
        int j = cell.charAt(0) - 'A';
        int i = parseInt(cell, 1);
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
            int i = parseInt(a, 1);
            x = map[i][j];
        }
        else {
            x = parseInt(a, 0);
        }
        if (Character.isLetter(b.charAt(0))) {
            int n = b.charAt(0) - 'A';
            int m = parseInt(b, 1);
            y = map[m][n];
        }
        else {
            y = parseInt(b, 0);
        }
        return x + y;
    }
    private int parseInt(String s, int start) {
        int num = 0;
        for (int i = start; i < s.length(); i++) {
            num = (num * 10) + s.charAt(i) - '0';
        }
        return num;
    }
}