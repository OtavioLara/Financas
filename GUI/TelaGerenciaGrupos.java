/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financasgenerica.GUI;

import financasgenerica.Grupo;
import financasgenerica.UsuarioLogado;
import financasgenerica.controler.ControlerUsuario;
import financasgenerica.repositorio.RepositorioGrupo;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Otavio
 */
class TelaGerenciaGrupos extends TelaLogado {

    GridBagLayout gbl;
    GridBagConstraints gbc;

    private JList<Grupo> lstIntegrantes;
    private DefaultListModel<Grupo> lstModelo;

    private JButton btnRecarregar;
    private JButton btnCriarGrupo;

    JScrollPane listScroller;

    public TelaGerenciaGrupos(GridBagLayout gbl, GridBagConstraints gbc, JList<Grupo> lstIntegrantes, DefaultListModel<Grupo> lstModelo, JButton btnRecarregar, JButton btnCriarGrupo, JScrollPane listScroller, String nome) {
        super(nome);
        this.gbl = gbl;
        this.gbc = gbc;
        this.lstIntegrantes = lstIntegrantes;
        this.lstModelo = lstModelo;
        this.btnRecarregar = btnRecarregar;
        this.btnCriarGrupo = btnCriarGrupo;
        this.listScroller = listScroller;
    }

    public TelaGerenciaGrupos() {
        super("Gerenciador de Grupos");

        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();

        setSize(300, 250);
        setLayout(gbl);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        construirTela();
        setLocationRelativeTo(null);
    }

    private void criarListaDeGrupos() {
        lstModelo.clear();
        for (Grupo grupo : RepositorioGrupo.gruposDoUsuarioLogado()) {
            lstModelo.addElement(grupo);
        }

    }

    private void construirTela() {

        lstModelo = new DefaultListModel<>();
        criarListaDeGrupos();

        if (lstIntegrantes == null) {
            lstIntegrantes = new JList<>(lstModelo);
            lstIntegrantes.setLayoutOrientation(JList.VERTICAL_WRAP);
            lstIntegrantes.setVisibleRowCount(-1);

            listScroller = new JScrollPane(lstIntegrantes);
            listScroller.setPreferredSize(new Dimension(100, 80));
        }

        btnRecarregar = new JButton("Recarregar");
        btnRecarregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                criarListaDeGrupos();

            }
        });

        btnCriarGrupo = new JButton("Criar grupo");
        btnCriarGrupo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCriarGrupo tl = new TelaCriarGrupo();
                tl.setVisible(true);
            }
        });

        JPanel painel = new JPanel(getLogadoLayout());

        adicionarComponente(painel, listScroller, 0, 0, 3, GridBagConstraints.LINE_START, new Insets(5, 5, 5, 5));

        adicionarComponente(painel, 0, 0, 3, GridBagConstraints.BOTH, GridBagConstraints.LINE_START);
        adicionarComponente(btnCriarGrupo, 2, 0, 1, GridBagConstraints.BOTH, GridBagConstraints.LINE_START);
        adicionarComponente(btnRecarregar, 2, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.LINE_START);

    }

}
