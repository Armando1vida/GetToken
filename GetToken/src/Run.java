//import static Token.chartmp;
import java.util.regex.Pattern;
import model.Compilador;
import model.Lectura;

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
//        Lectura to = new Lectura("for ( int abdc=3; abdc< h;abdc++){}");
//        String c = to.getToken();
//        while (c != null ) {
//            System.out.println(c);
//            c = to.getToken();
////        }
//        Compilador c= new Compilador("for ( int abdc=3; abdc< h;abdc++){}");
//        c.analzarLexico();
        String a="DECIMAL";
//        String b="tes";
//        System.out.println(a.equals(b));
        
        System.out.println( a.matches("(DECIMAL|NUMERIC])"));
    }

}
