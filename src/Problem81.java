public class Problem81 {
    public static int minPathSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i = 1; i < cols; i ++){
            matrix[0][i] += matrix[0][i - 1];
        }
        for(int i = 1; i < rows; i ++){
            matrix[i][0] += matrix[i - 1][0];
        }
        for(int i = 1; i < rows; i ++){
            for(int j = 1; j < cols; j ++){
                matrix[i][j] += Math.min(matrix[i - 1][j], matrix[i][j - 1]);
            }
        }
        return matrix[rows - 1][cols - 1];
    }

}
