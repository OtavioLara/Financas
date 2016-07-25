/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financasgenerica.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Otavio
 */
public class TelaAdicionarItemIndividual extends TelaLogado {

    JLabel lblNome;
    JLabel lblValor;

    JTextField txtNome;
    JTextField txtValor;

    JButton btnAdicionar;

    public TelaAdicionarItemIndividual() {
        super("Adicionar item");
        construirTela();
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
                
            }
        });
    }

    public String getNome() {
        return txtNome.getText();
    }

    void getValor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
