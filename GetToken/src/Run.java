
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ArmandoPC
 */
public class Run {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Token to = new Token("12Hola hola83+s00+-/*");
        while (to.getHaveToken()) {
            String r = to.getToken();
            if (r.length() > 0) {
                System.out.println(r);
            }
        }
    }

}