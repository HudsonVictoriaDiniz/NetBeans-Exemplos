package Exemplo04.salarioliquidoprof;

import java.util.Scanner;

public class Exemplo04SalarioLiquidoProf {
    public static void main(String[] args) {

        // Declaração das variáveis
        double valorHora, percInss;
        double salBruto, descInss, salLiq;
        int horasTrab;

        // Scanner para entrada de dados
        Scanner scanner = new Scanner(System.in);

        // Entrada de dados
        System.out.print("Valor da hora-aula: R$ ");
        valorHora = scanner.nextDouble();

        System.out.print("Número de horas trabalhadas: ");
        horasTrab = scanner.nextInt();

        System.out.print("Percentual de desconto INSS (%): ");
        percInss = scanner.nextDouble();

        // Cálculos
        salBruto = valorHora * horasTrab;
        descInss = percInss / 100 * salBruto;
        salLiq = salBruto - descInss;

        // Saída
        System.out.printf("Salário líquido do professor = R$ %.2f\n", salLiq);

        scanner.close(); // Boa prática
    }
}
