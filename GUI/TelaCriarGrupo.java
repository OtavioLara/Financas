/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financasgenerica.GUI;

import financasgenerica.Usuario;
import financasgenerica.UsuarioLogado;
import financasgenerica.controler.ControlerGrupo;
import financasgenerica.controler.ControlerUsuario;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Otavio
 */
public class TelaCriarGrupo extends TelaLogado {

    private JLabel lblNomeGrupo;

    private JList<String> lstIntegrantes;
    private DefaultListModel<String> lstModelo;

    private JTextField txtNomeGrupo;
    private JTextField txtIntegrantes;

    private JButton btnMaisItegrantes;
    private JButton btnCriarGrupo;

    private ArrayList<Usuario> listaUsuarios;

    public TelaCriarGrupo() {
        super("Criar grupo");
        construirTela();
        pack();
        setLocationRelativeTo(null);
    }

    private void construirTela() {
        lblNomeGrupo = new JLabel("Nome do grupo");

        lstModelo = new DefaultListModel<>();
        lstModelo.addElement(UsuarioLogado.getInstance().getUsuario());

        lstIntegrantes = new JList<>(lstModelo);
        lstIntegrantes.setLayoutOrientation(JList.VERTICAL_WRAP);
        lstIntegrantes.setVisibleRowCount(-1);

        JScrollPane listScroller = new JScrollPane(lstIntegrantes);
        listScroller.setPreferredSize(new Dimension(100, 80));
        
        listaUsuarios = new ArrayList<>();
        listaUsuarios.add(ControlerUsuario.getUsuario(UsuarioLogado.getInstance().getUsuario()));
        txtNomeGrupo = new JTextField(15);
        
        btnMaisItegrantes = new JButton("add integrante");
        btnMaisItegrantes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = JOptionPane.showInputDialog(null, "Entre com o username da pessoa\n"
                        + "que deseja cadastrar", "Adicionar integrante", JOptionPane.PLAIN_MESSAGE);
                if (ControlerUsuario.getUsuario(username) != null) {
                    lstModelo.addElement(username);
                    listaUsuarios.add(ControlerUsuario.getUsuario(username));
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário " + username + " não existe", "Usario não existe", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnCriarGrupo = new JButton("Criar grupo");
        btnCriarGrupo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtNomeGrupo.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "O grupo precisa de um nome", "Grupo sem nome", JOptionPane.ERROR_MESSAGE);
                } else if (listaUsuarios.size() == 1) {
                    JOptionPane.showMessageDialog(null, "Para ser um grupo deve haver mais de uma pessoa", "Tamanho insuficiente", JOptionPane.ERROR_MESSAGE);
                } else {
                    ControlerGrupo.adicionarGrupo(txtNomeGrupo.getText(), ControlerUsuario.getUsuario(UsuarioLogado.getInstance().getUsuario()), listaUsuarios);
                    JOptionPane.showMessageDialog(null, "Grupo cadastrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }
            }
        });
        JPanel painelNovoGrupo = new JPanel(getLogadoLayout());
        adicionarComponente(painelNovoGrupo, lblNomeGrupo, 0, 0, 1, GridBagConstraints.LINE_START);
        adicionarComponente(painelNovoGrupo, txtNomeGrupo, 0, 1, 2, GridBagConstraints.LINE_START);
        adicionarComponente(painelNovoGrupo, listScroller, 1, 0, 3, GridBagConstraints.LINE_START, new Insets(5, 5, 5, 5));
        adicionarComponente(painelNovoGrupo, btnMaisItegrantes, 2, 0, 2, GridBagConstraints.LINE_END);
        adicionarComponente(painelNovoGrupo, btnCriarGrupo, 3, 0, 3, GridBagConstraints.BOTH);

        adicionarComponente(painelNovoGrupo, 0, 0, 1, GridBagConstraints.BOTH, GridBagConstraints.LINE_START);
    }

}
