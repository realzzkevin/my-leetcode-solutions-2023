class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        //easier if we not try find the least colum number.
        //char[][] matrix = new char[numRows][s.length()];
        int section = (int) Math.ceil(s.length() / (2*numRows -2.0));
        int numCols = section * (numRows - 1);
        char[][] matrix = new char[numRows][numCols];

        for(char[] row: matrix) {
            Arrays.fill(row, ' ');
        }
        int currRow = 0;
        int currCol = 0;
        int index = 0;

        while (index < s.length()){
            while(currRow < numRows && index < s.length()) {
                matrix[currRow][currCol] = s.charAt(index);
                currRow++;
                index++;
            }

            currRow -=2;
            currCol++;
            while(currRow > 0 && currCol < numCols && index < s.length()){
                matrix[currRow][currCol] = s.charAt(index);
                currRow--;
                currCol++;
                index++;
            }
        }

        StringBuilder answer = new StringBuilder();
        for(char[] row: matrix){
            for(char c : row) {
                if(c != ' ') {
                    answer.append(c);
                }
            }
        }

        return answer.toString();



    }
}