import javax.swing.*;
import java.awt.*;

public class DashboardContaCorrente extends JFrame {

    private ContaCorrente conta;
    private JLabel lblNome, lblConta, lblSaldo;

    public DashboardContaCorrente() {
        // Criando conta
        String nome = JOptionPane.showInputDialog(this, "Digite o nome do titular:");
        int numero = Integer.parseInt(JOptionPane.showInputDialog(this, "Digite o número da conta:"));
        conta = new ContaCorrente(nome, numero);

        setTitle("Dashboard - Conta Corrente");
        setSize(450, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Painel de informações
        JPanel painelInfo = new JPanel(new GridLayout(3, 1));
        painelInfo.setBorder(BorderFactory.createTitledBorder("Informações da Conta"));
        lblNome = new JLabel("Titular: " + conta.getTitular());
        lblConta = new JLabel("Conta nº: " + conta.getNumeroConta());
        lblSaldo = new JLabel("Saldo: R$ " + String.format("%.2f", conta.getSaldo()));

        lblNome.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblConta.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblSaldo.setFont(new Font("Segoe UI", Font.BOLD, 18));

        painelInfo.add(lblNome);
        painelInfo.add(lblConta);
        painelInfo.add(lblSaldo);

        // Painel de botões
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton btnDepositar = new JButton("Depositar");
        JButton btnSacar = new JButton("Sacar");
        JButton btnAtualizar = new JButton("Atualizar Saldo");
        JButton btnSair = new JButton("Sair");

        painelBotoes.add(btnDepositar);
        painelBotoes.add(btnSacar);
        painelBotoes.add(btnAtualizar);
        painelBotoes.add(btnSair);

        // Ações dos botões
        btnDepositar.addActionListener(e -> {
            String val = JOptionPane.showInputDialog(this, "Valor do depósito:");
            if (val != null) {
                try {
                    double valor = Double.parseDouble(val);
                    conta.depositar(valor);
                    atualizarSaldo();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Digite um valor válido.");
                }
            }
        });

        btnSacar.addActionListener(e -> {
            String val = JOptionPane.showInputDialog(this, "Valor do saque:");
            if (val != null) {
                try {
                    double valor = Double.parseDouble(val);
                    if (!conta.sacar(valor)) {
                        JOptionPane.showMessageDialog(this, "Saldo insuficiente.");
                    }
                    atualizarSaldo();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Digite um valor válido.");
                }
            }
        });

        btnAtualizar.addActionListener(e -> atualizarSaldo());

        btnSair.addActionListener(e -> System.exit(0));

        // Adiciona os painéis ao JFrame
        add(painelInfo, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void atualizarSaldo() {
        lblSaldo.setText("Saldo: R$ " + String.format("%.2f", conta.getSaldo()));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DashboardContaCorrente());
    }
}
