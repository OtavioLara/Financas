/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financasgenerica.GUI;

import financasgenerica.Grupo;
import financasgenerica.repositorio.RepositorioGrupo;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Otavio
 */
public class TelaDespesaGrupo extends TelaLogado {

    private JLabel lblNomeDespesa;
    private JLabel lblData;
    private JLabel lblDataAlerta;
    private JLabel lblGrupos;
    private JLabel lblValorTotal;
    
    private double valorTotal;
    
    private JTextField txtNomeDespesa;
    private JTextField txtData;
    private JTextField txtDataAlerta;
    private JTextArea txtDescricao;

    private JComboBox<Grupo> cbGrupos;

    private JTable tabelaItens;
    private DefaultTableModel modeloTableItens;

    private JButton btnVoltar;
    private JButton btnCadastrar;
    
    private JPanel painelPrincipal;
    public TelaDespesaGrupo() {
        super("Despesa grupo");
        construirTela();
        pack();
        setLocationRelativeTo(null);
    }
    private Grupo[] getArrayGrupos() {
        Grupo[] grupos =  new Grupo[RepositorioGrupo.gruposDoUsuarioLogado().size()];
        int i = 0;
        for (Grupo grupo : RepositorioGrupo.gruposDoUsuarioLogado()) {
            grupos[i] = grupo;
            i++;
        }
        return grupos;
    }
    private void construirTela() {
        lblNomeDespesa = new JLabel("Nome");
        lblData = new JLabel("Data criação");
        lblDataAlerta = new JLabel("Data alerta");
        
        txtNomeDespesa = new JTextField(15);
        txtData = new JTextField(15);
        txtDataAlerta = new JTextField(15);
        
        txtDescricao = new JTextArea(4,20);
        txtDescricao.setBorder(javax.swing.BorderFactory.createTitledBorder("Descrição"));
        txtDescricao.setLineWrap(true);
        txtDescricao.setMaximumSize(new Dimension(4, 20));

        String colunas[] = {"Nome", "Valor"};
        modeloTableItens = new DefaultTableModel(colunas, 0);
        tabelaItens = new JTable(modeloTableItens);

        lblValorTotal = new JLabel("Valor total: 0");

        lblNomeDespesa = new JLabel("Nome da despesa");
        txtNomeDespesa = new JTextField(15);
       
        lblGrupos = new JLabel("Grupos");
        cbGrupos = new JComboBox<>(getArrayGrupos());
        JScrollPane listScroller = new JScrollPane(tabelaItens);
        listScroller.setPreferredSize(new Dimension(100, 80));
        
        btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaPrincipal tp = new TelaPrincipal();
                tp.setVisible(true);
                dispose();
            }
        });
        btnCadastrar = new JButton("Cadastrar");
        
        JPanel painelBotoes = new JPanel(getLogadoLayout());
        
        adicionarComponente(painelBotoes, btnCadastrar, 0, 0, 1, GridBagConstraints.BOTH);
        adicionarComponente(painelBotoes, btnVoltar, 0, 1, 1, GridBagConstraints.BOTH);
        
        JPanel painelItens = new JPanel(getLogadoLayout());
        
        
        
        painelPrincipal = new JPanel(getLogadoLayout());
        adicionarComponente(painelPrincipal, lblNomeDespesa, 0, 0, 1, GridBagConstraints.BOTH);
        adicionarComponente(painelPrincipal, txtNomeDespesa, 0, 1, 2, GridBagConstraints.BOTH);
        
        adicionarComponente(painelPrincipal, lblData, 1, 0, 1, GridBagConstraints.BOTH);
        adicionarComponente(painelPrincipal, txtData, 1, 1, 2, GridBagConstraints.BOTH);
        
        adicionarComponente(painelPrincipal, lblDataAlerta, 2, 0, 1, GridBagConstraints.BOTH);
        adicionarComponente(painelPrincipal, txtDataAlerta, 2, 1, 2, GridBagConstraints.BOTH);
        
        adicionarComponente(painelPrincipal, txtDescricao, 3, 0, 3, GridBagConstraints.BOTH);
        
        adicionarComponente(painelPrincipal, lblGrupos, 4, 0, 1, GridBagConstraints.BOTH);
        adicionarComponente(painelPrincipal, cbGrupos, 4, 1, 2, GridBagConstraints.BOTH);
        
        adicionarComponente(painelPrincipal, painelBotoes, 5, 0, 3, GridBagConstraints.BOTH);
        add(painelPrincipal);
    
    }

}
