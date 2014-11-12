/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ArmandoPC
 */
public class TablaTrans {

    private String nombre;

    private int[][] matriz = new int[4][];

    public TablaTrans() {
        matriz[0] = new int[]{1, 1000, 1000, 1000, 1000, 1002};
        matriz[1] = new int[]{1000, 2, 2, 2, 2, 1002};
        matriz[2] = new int[]{-3, 1000, 1000, 1000, 1000, 1002};
        matriz[3] = new int[]{1001, 2, 2, 2, 2, 1002};
    }

    public TablaTrans(int[][] m) {
        this.matriz = m;
    }

    public TablaTrans(String nombre, int[][] m) {
        this.nombre = nombre;
        this.matriz = m;
    }

    public int getEstadoSiguiente(int estado, int valor_token) {
        return getMatriz()[estado][valor_token];
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the matriz
     */
    public int[][] getMatriz() {
        return matriz;
    }

    /**
     * @param matriz the matriz to set
     */
    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

}
