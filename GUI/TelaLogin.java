/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financasgenerica.GUI;

import financasgenerica.controler.ControlerUsuario;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Otavio
 */
public class TelaLogin extends JFrame {

    private GridBagLayout gbl;
    private GridBagConstraints gbc;

    private JLabel lblUsername;
    private JLabel lblSenha;

    private JTextField txtUsername;
    private JPasswordField txtSenha;

    private JButton btnLogar;
    private JButton btnCadastrar;

    public TelaLogin() {
        super("Login");

        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();

        
        setLayout(gbl);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        construirTela();
        pack();
        setLocationRelativeTo(null);
        
    }

    private void construirTela() {
        lblUsername = new JLabel("Username");
        lblSenha = new JLabel("Senha");

        txtUsername = new JTextField(20);
        txtSenha = new JPasswordField(20);
        txtSenha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnLogar = new JButton("Logar");
        btnLogar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ControlerUsuario.logar(txtUsername.getText(), txtSenha.getText())) {
                    TelaPrincipal tl = new TelaPrincipal();
                    dispose();
                    tl.setVisible(true);
                }

            }
        });
        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastro tl = new TelaCadastro();
                tl.setVisible(true);
                dispose();
            }

        });

        JPanel painelLogin = new JPanel();
        painelLogin.setLayout(gbl);
        adicionarComponente(painelLogin, lblUsername, 0, 0, 1, GridBagConstraints.NONE);
        adicionarComponente(painelLogin, txtUsername, 1, 0, 1, GridBagConstraints.NONE);
        adicionarComponente(painelLogin, lblSenha, 2, 0, 1, GridBagConstraints.NONE);
        adicionarComponente(painelLogin, txtSenha, 3, 0, 1, GridBagConstraints.NONE);
        painelLogin.setBorder(javax.swing.BorderFactory.createTitledBorder("Login"));

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(btnLogar);
        painelBotoes.add(btnCadastrar);

        adicionarComponente(painelLogin, 0, 0, 2, GridBagConstraints.BOTH);
        adicionarComponente(painelBotoes, 1, 0, 2, GridBagConstraints.BOTH);

    }

    private void adicionarComponente(Component c,
            int linha, int coluna, int largura, int fill) {
        gbc.gridx = coluna;
        gbc.fill = fill;
        gbc.gridy = linha;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(3, 3, 3, 3);
        gbc.gridwidth = largura;
        gbl.setConstraints(c, gbc);
        add(c);
    }

    private void adicionarComponente(JPanel painel, Component c,
            int linha, int coluna, int largura, int fill) {
        gbc.gridx = coluna;
        gbc.fill = fill;
        gbc.gridy = linha;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(3, 3, 3, 3);
        gbc.gridwidth = largura;
        gbl.setConstraints(c, gbc);
        painel.add(c);
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        TelaLogin tp = new TelaLogin();
        tp.setVisible(true);
    }

}
