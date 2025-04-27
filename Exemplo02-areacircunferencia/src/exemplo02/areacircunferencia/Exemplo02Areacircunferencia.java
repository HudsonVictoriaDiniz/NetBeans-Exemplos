/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exemplo02.areacircunferencia;

/**
 * @author hudson
 */
import java.util.Scanner;


public class Exemplo02Areacircunferencia {

	public static void main(String[] args) {
            
		double raio, area;
                
                Scanner scanner = new Scanner(System.in);
                
		System.out.print("Informe o raio da circunferencia: ");
                
                raio = scanner.nextDouble();
                                
		area = 3.14159 * raio * raio;
                
		System.out.printf("Area da circunferencia = %.2f\n " ,  area);
                
                scanner.close();
	}
}