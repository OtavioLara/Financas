/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financasgenerica.GUI;

import financasgenerica.Item;
import financasgenerica.ItemDespesaIndividual;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Otavio
 */
public class TelaAdicionarItemIndividual extends JDialog {

    private GridBagLayout gbl;
    private GridBagConstraints gbc;

    private JLabel lblNome;
    private JLabel lblValor;

    private JTextField txtNome;
    private JTextField txtValor;

    private JButton btnAdicionar;
    private JButton btnCancelar;

    public TelaAdicionarItemIndividual(TelaDespesaIndividual parent) {
        super(parent, "Adicionar item", true);
        gbc = new GridBagConstraints();
        gbl = new GridBagLayout();
        setLayout(gbl);
        construirTela();
        pack();
        setLocationRelativeTo(null);
    }

    private void construirTela() {
        lblNome = new JLabel("Nome");
        txtNome = new JTextField(15);

        lblValor = new JLabel("Valor");
        txtValor = new JTextField(5);

        btnAdicionar = new JButton("Adicionar");

        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        adicionarComponente(lblNome, 0, 0, 1, GridBagConstraints.CENTER, GridBagConstraints.LINE_END);
        adicionarComponente(txtNome, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.LINE_START);
        adicionarComponente(lblValor, 1, 0, 1, GridBagConstraints.CENTER, GridBagConstraints.LINE_END);
        adicionarComponente(txtValor, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.LINE_START);
        adicionarComponente(btnAdicionar, 2, 0, 1, GridBagConstraints.BOTH, GridBagConstraints.LINE_START);
        adicionarComponente(btnCancelar, 2, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.LINE_START);

    }

    protected void adicionarComponente(Component c,
            int linha, int coluna, int largura, int fill, int anchor) {
        gbc.gridx = coluna;
        gbc.fill = fill;
        gbc.gridy = linha;
        gbc.anchor = anchor;
        gbc.insets = new Insets(3, 3, 3, 3);
        gbc.gridwidth = largura;
        gbl.setConstraints(c, gbc);
        add(c);
    }
    
    public ItemDespesaIndividual getRetorno(){
        return new ItemDespesaIndividual(txtNome.getText(), Double.parseDouble(txtValor.getText()));
    }
    public String getNome(){
        return txtNome.getText();
    }
    public String getValor(){
        return txtValor.getText();
    }
}
