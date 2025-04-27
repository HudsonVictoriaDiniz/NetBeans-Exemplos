import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleContaCorrente extends JFrame {

    private ContaCorrente conta;

    public ControleContaCorrente() {
        // Criar conta exemplo
        String nome = JOptionPane.showInputDialog(this, "Digite o nome do titular:");
        String numStr = JOptionPane.showInputDialog(this, "Digite o número da conta:");
        int numero = Integer.parseInt(numStr);

        conta = new ContaCorrente(nome, numero);

        setTitle("Controle de Conta Corrente");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criar menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Opções");

        JMenuItem itemDeposito = new JMenuItem("Depositar");
        JMenuItem itemSaque = new JMenuItem("Sacar");
        JMenuItem itemSaldo = new JMenuItem("Consultar Saldo");
        JMenuItem itemDados = new JMenuItem("Exibir Dados da Conta");
        JMenuItem itemSair = new JMenuItem("Sair");

        // Ações
        itemDeposito.addActionListener(e -> {
            String val = JOptionPane.showInputDialog(this, "Valor do depósito:");
            if (val != null) {
                double valor = Double.parseDouble(val);
                conta.depositar(valor);
                JOptionPane.showMessageDialog(this, "Depósito realizado!");
            }
        });

        itemSaque.addActionListener(e -> {
            String val = JOptionPane.showInputDialog(this, "Valor do saque:");
            if (val != null) {
                double valor = Double.parseDouble(val);
                if (conta.sacar(valor)) {
                    JOptionPane.showMessageDialog(this, "Saque realizado!");
                } else {
                    JOptionPane.showMessageDialog(this, "Saldo insuficiente!");
                }
            }
        });

        itemSaldo.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                    "Saldo atual: R$ " + String.format("%.2f", conta.getSaldo()));
        });

        itemDados.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, conta.getDadosConta(), "Dados da Conta",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        itemSair.addActionListener(e -> System.exit(0));

        // Adiciona itens ao menu
        menu.add(itemDeposito);
        menu.add(itemSaque);
        menu.add(itemSaldo);
        menu.add(itemDados);
        menu.addSeparator();
        menu.add(itemSair);

        // Adiciona ao menu bar
        menuBar.add(menu);
        setJMenuBar(menuBar);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ControleContaCorrente());
    }
}
