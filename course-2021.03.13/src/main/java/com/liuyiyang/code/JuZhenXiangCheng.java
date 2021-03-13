package com.liuyiyang.code;

import java.util.Scanner;

/**
 * matrixC[i][j]  = matrixA的第i行分别乘以matrixB的第j列
 * 1 2 1          2 3
 * 3 4 1          1 3
 * 1 1
 * <p>
 * 5  10
 * 11 22
 */
public class JuZhenXiangCheng {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        if (m <= 0 || n <= 0) {
            System.out.println("输错了");
            return;
        }
        int[][] matrixA = new int[m][n];
        int[][] matrixB = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrixA[i][j] = sc.nextInt();
            }
        }
        printMatrix(matrixA);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrixB[i][j] = sc.nextInt();
            }
        }
        printMatrix(matrixB);

        int[][] matrixC = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                int entry = 0;
                for (int k = 0; k < n; k++) {
                    entry += matrixA[i][k] * matrixB[k][j];
                }
                matrixC[i][j] = entry;
            }
        }
        printMatrix(matrixC);
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int[] line = matrix[i];
            for (int j = 0; j < line.length; j++) {
                System.out.print(line[j] + " ");
            }
            System.out.println();
        }
    }
}
