import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalarioLiquidoSwing extends JFrame {

    // Componentes
    private JTextField txtValorHora, txtHorasTrab, txtPercInss;
    private JButton btnCalcular, btnLimpar;

    public SalarioLiquidoSwing() {
        setTitle("Cálculo do Salário Líquido");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centralizar na tela

        // Fonte personalizada
        Font fontePadrao = new Font("Segoe UI", Font.PLAIN, 14);

        // Painel com Grid
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(240, 248, 255)); // cor azul clara

        JLabel lblValorHora = new JLabel("Valor da hora-aula (R$):");
        lblValorHora.setFont(fontePadrao);
        txtValorHora = new JTextField();
        txtValorHora.setFont(fontePadrao);

        JLabel lblHorasTrab = new JLabel("Horas trabalhadas:");
        lblHorasTrab.setFont(fontePadrao);
        txtHorasTrab = new JTextField();
        txtHorasTrab.setFont(fontePadrao);

        JLabel lblPercInss = new JLabel("Percentual INSS (%):");
        lblPercInss.setFont(fontePadrao);
        txtPercInss = new JTextField();
        txtPercInss.setFont(fontePadrao);

        btnCalcular = new JButton("Calcular");
        btnCalcular.setFont(fontePadrao);
        btnCalcular.setBackground(new Color(60, 179, 113)); // verde

        btnLimpar = new JButton("Limpar");
        btnLimpar.setFont(fontePadrao);
        btnLimpar.setBackground(new Color(220, 20, 60)); // vermelho

        // Ações dos botões
        btnCalcular.addActionListener(e -> calcularSalario());
        btnLimpar.addActionListener(e -> limparCampos());

        // Adiciona componentes ao painel
        panel.add(lblValorHora);
        panel.add(txtValorHora);
        panel.add(lblHorasTrab);
        panel.add(txtHorasTrab);
        panel.add(lblPercInss);
        panel.add(txtPercInss);
        panel.add(btnCalcular);
        panel.add(btnLimpar);

        // Espaço vazio para alinhar melhor
        panel.add(new JLabel());

        // Adiciona o painel à janela
        add(panel);
        setVisible(true);
    }

    private void calcularSalario() {
        try {
            double valorHora = Double.parseDouble(txtValorHora.getText());
            int horasTrab = Integer.parseInt(txtHorasTrab.getText());
            double percInss = Double.parseDouble(txtPercInss.getText());

            double salBruto = valorHora * horasTrab;
            double descInss = percInss / 100 * salBruto;
            double salLiq = salBruto - descInss;

            String msg = String.format(
                "Salário Bruto: R$ %.2f\nDesconto INSS: R$ %.2f\nSalário Líquido: R$ %.2f",
                salBruto, descInss, salLiq
            );

            JOptionPane.showMessageDialog(this, msg, "Resultado", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores numéricos válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limparCampos() {
        txtValorHora.setText("");
        txtHorasTrab.setText("");
        txtPercInss.setText("");
        txtValorHora.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SalarioLiquidoSwing::new);
    }
}
