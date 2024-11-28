import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Banco {
    private JPanel panel1;
    private JButton btnLimpar;
    private JButton btnDeposito;
    private JButton btnSaque;
    private JTextField txtMensagem;
    private JTextField btnValorSaque;
    private JTextField btnValorDeposito;
    private JTextField txtMostrarSaldo;

    private double saldo = 500.00;

    public Banco() {

        txtMostrarSaldo.setText(String.valueOf(saldo));


        btnSaque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarSaque();
            }
        });


        btnDeposito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarDeposito();
            }
        });


        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtMensagem.setText("");
            }
        });
    }

    private void realizarSaque() {
        String textoSaque = btnValorSaque.getText();
        if (!isValidInput(textoSaque)) {
            txtMensagem.setText("Entrada inválida");
            return;
        }
        double valorSaque = Double.parseDouble(textoSaque);

        if (valorSaque <= 0) {
            txtMensagem.setText("O valor do saque deve ser positivo");
            return;
        }

        if (valorSaque > saldo) {
            txtMensagem.setText("Saldo insuficiente");
            return;
        }

        saldo -= valorSaque;
        txtMostrarSaldo.setText(String.valueOf(saldo));
        txtMensagem.setText("Saque bem sucedido");
    }

    private void realizarDeposito() {
        String textoDeposito = btnValorDeposito.getText();
        if (!isValidInput(textoDeposito)) {
            txtMensagem.setText("Entrada inválida");
            return;
        }
        double valorDeposito = Double.parseDouble(textoDeposito);

        if (valorDeposito <= 0) {
            txtMensagem.setText("O valor do depósito deve ser positivo");
            return;
        }

        if (valorDeposito > 1000) {
            txtMensagem.setText("Depósito não permitido");
            return;
        }

        saldo += valorDeposito;
        txtMostrarSaldo.setText(String.valueOf(saldo));
        txtMensagem.setText("Depósito bem sucedido");
    }

    private boolean isValidInput(String input) {
        try {
            Double.parseDouble(input);
            return input != null && !input.trim().isEmpty();
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Banco");
        frame.setContentPane(new Banco().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}