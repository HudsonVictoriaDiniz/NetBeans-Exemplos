/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exemplo03.novosalariofunc;

import java.util.Scanner;

/**
 * Programa que calcula o novo salário de um funcionário com base
 * no percentual de aumento informado.
 * 
 * Autor: hudson-univesp
 */
public class Exemplo03NovoSalarioFunc {

    public static void main(String[] args) {

        // Declaração de variáveis
        double salarioAtual, percentualAumento;
        double valorAumento, novoSalario;

        // Criando scanner para entrada de dados
        Scanner scanner = new Scanner(System.in);

        // Entrada de dados
        System.out.print("Salário atual do funcionário: R$ ");
        salarioAtual = scanner.nextDouble();

        System.out.print("Percentual de aumento (%): ");
        percentualAumento = scanner.nextDouble();

        // Cálculos
        valorAumento = salarioAtual * percentualAumento / 100;
        novoSalario = salarioAtual + valorAumento;

        // Saída de resultados
        System.out.printf("Valor do aumento = R$ %.2f\n", valorAumento);
        System.out.printf("Novo salário = R$ %.2f\n", novoSalario);

        // Fechando o scanner (boa prática)
        scanner.close();
    }
}
