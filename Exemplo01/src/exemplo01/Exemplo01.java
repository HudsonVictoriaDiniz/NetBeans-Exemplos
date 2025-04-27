/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exemplo01;
/*
 * @author hudson
 */
import java.util.Scanner;
public class Exemplo01 {   
     public static void main(String[] args) {
          Scanner entrada = new Scanner(System.in);
        
          double N1, N2, N3, N4, RES;     
          System.out.print("Digite N1: ");
          N1 = entrada.nextDouble();
          System.out.print("Digite N2: ");
          N2 = entrada.nextDouble();
          System.out.print("Digite N3: ");
          N3 = entrada.nextDouble();
          System.out.print("Digite N4: ");
          N4 = entrada.nextDouble();

          RES = (N1 + N2 + N3 + N4) / 4;       

          System.out.println("A média é : " + RES);

     }

}