class Generation {
    static String[][] c;

    String[][] generation(String[][] a, int n) {

        String[][] b = new String[n + 2][n + 2];
        int m = n + 2;
        c = new String[n][n];
        for (int i = 0; i <= m - 1; i++) {
            for (int j = 0; j <= m - 1; j++) {
                if (i == 0 && j == 0) {
                    b[i][j] = a[n - 1][n - 1];
                } else if (i == 0 && j == m - 1) {
                    b[i][j] = a[n - 1][0];
                } else if (i == m - 1 && j == 0) {
                    b[i][j] = a[0][n - 1];
                } else if (i == m - 1 && i == j) {
                    b[i][j] = a[0][0];
                } else if (i == 0 && j > 0 && j < m - 1) {
                    b[i][j] = a[n - 1][j - 1];
                } else if (i == m - 1 && j > 0 && j < m - 1) {
                    b[i][j] = a[0][j - 1];
                } else if (j == 0 && i > 0 && i < m - 1) {
                    b[i][j] = a[i - 1][n - 1];
                } else if (j == m - 1 && i > 0 && i < m - 1) {
                    b[i][j] = a[i - 1][0];
                } else {
                    b[i][j] = a[i - 1][j - 1];
                }
            }
        }
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                int k = 0;

                if (b[i - 1][j - 1].equals("O")) {
                    k++;
                }
                if (b[i - 1][j].equals("O")) {
                    k++;
                }
                if (b[i - 1][j + 1].equals("O")) {
                    k++;
                }
                if (b[i + 1][j - 1].equals("O")) {
                    k++;
                }
                if (b[i + 1][j].equals("O")) {
                    k++;
                }
                if (b[i + 1][j + 1].equals("O")) {
                    k++;
                }
                if (b[i][j - 1].equals("O")) {
                    k++;
                }
                if (b[i][j + 1].equals("O")) {
                    k++;
                } else {
                }

                c[i - 1][j - 1] = value(b[i][j], k);
            }
        }
        return c;
    }

    static int Alive(String[][] a, int n) {
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (a[i][j].equals("O")) {
                    k++;
                }
            }
        }
        return k;
    }

    static String value(String n, int k) {
        String nn = " ";
        if (n.equals("O")) {
            if (k < 2 || k > 3) {
            } else {
                nn = "O";
            }
        } else {
            if (k == 3) {
                nn = "O";
            }
        }
        return nn;
    }
}
