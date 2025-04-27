import javax.swing.JOptionPane;

public class SalarioLiquidoProf {

    public static void main(String[] args) {

        // Entrada de dados usando JOptionPane
        String valorHoraStr = JOptionPane.showInputDialog("Valor da hora-aula (R$):");
        String horasTrabStr = JOptionPane.showInputDialog("Número de horas trabalhadas:");
        String percInssStr = JOptionPane.showInputDialog("Percentual de desconto INSS (%):");

        // Conversão das entradas para tipos numéricos
        double valorHora = Double.parseDouble(valorHoraStr);
        int horasTrab = Integer.parseInt(horasTrabStr);
        double percInss = Double.parseDouble(percInssStr);

        // Cálculos
        double salBruto = valorHora * horasTrab;
        double descInss = percInss / 100 * salBruto;
        double salLiq = salBruto - descInss;

        // Exibição do resultado
        String mensagem = String.format(
            "Salário bruto: R$ %.2f\nDesconto INSS: R$ %.2f\nSalário líquido: R$ %.2f",
            salBruto, descInss, salLiq
        );

        JOptionPane.showMessageDialog(null, mensagem, "Resultado", JOptionPane.INFORMATION_MESSAGE);
    }
}
