public class MatrixCalculator {
    public double determinant(int[][] matrix) {
        if (matrix.length != matrix[matrix.length - 1].length) {
            System.out.println("Matrix is not square!");
            return 0;
        }
        double determinant = 0;
        for (int i = 0; i < matrix.length; i++) {
            determinant += matrix[0][i] * Math.pow(-1, 1 + i + 1) * minor(matrix, 0, i);
        }
        return determinant;
    }

    private double minor(int[][] matrix, int row, int column) {
        int[][] minor = createMinor(matrix, row, column);
        double determinant = 0;
        if (minor.length == 1) return 1;
        for (int i = 0; i < minor.length; i++) {
            determinant += minor[0][i] * Math.pow(-1, 1 + i + 1) * minor(minor, 0, i);
        }
        return determinant;
    }

    private int[][] createMinor(int[][] matrix, int row, int column) {
        int[][] minor = new int[matrix.length - 1][matrix.length - 1];
        int currentRow = 0;
        for (int i = 0; i < matrix.length; i++) {
            int currentColumn = 0;
            for (int j = 0; j < matrix.length; j++) {

                if ((i != row) && (j != column)) {
                    minor[currentRow][currentColumn] = matrix[i][j];
                    currentColumn++;
                }

            }
            if (currentColumn == minor.length) {
                currentRow++;
            }
        }
        return minor;
    }

    //public static void main(String[] args){}
}
