/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author ArmandoPC
 */
public class TablaTrans {

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

    public int getEstadoSiguiente(int estado, int valor_token) {
        return matriz[estado][valor_token];
    }

}
