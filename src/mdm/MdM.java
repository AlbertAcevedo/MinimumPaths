/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdm;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Alberto pc
 */
public class MdM {
    
    public static BigInteger[][] matrixPow(BigInteger[][] M, int n, int k){
        BigInteger[][] MatrizActual = M;
        for (int i = 0; i < k-1; i++) {
            MatrizActual = matrixProduct(MatrizActual, M, n);
        }
        return MatrizActual;
    }
    
    public static BigInteger[][] matrixProduct(BigInteger[][] M1, BigInteger M2[][], int n){
        BigInteger[][] M = new BigInteger[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                M[i][j] = BigInteger.ZERO;
                for (int k = 0; k < n; k++) {
                    M[i][j] = M[i][j].add(M1[i][k].multiply(M2[k][j]));
                }
            }
        }
        return M;
    }
    public static void printMatrix(BigInteger[][] M, int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(M[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese funcion(1-> Multiplicación, *->Potencia");
        int t = sc.nextInt();
        System.out.println("Ingrese tamaño de la matriz");
        int n = sc.nextInt();
        BigInteger[][] M = new BigInteger[n][n];
        BigInteger[][] R = new BigInteger[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                M[i][j] = sc.nextBigInteger();
            }
        }
        if (t==1) {
            System.out.println("Ingrese segunda matriz");
            BigInteger[][] Z = new BigInteger[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    Z[i][j] = sc.nextBigInteger();
                }
            }
            R = matrixProduct(M, Z, n);
            System.out.println("La matriz resultante es la siguiente:");
            printMatrix(R, n);
        }
        else{
            System.out.println("Ingrese la potencia");
            int k = sc.nextInt();
            R = matrixPow(M, n, k);
            System.out.println("La matriz resultante es la siguiente:");
            printMatrix(R, n);
        }
        
    }
    
}