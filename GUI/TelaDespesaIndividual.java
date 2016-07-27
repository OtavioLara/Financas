/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financasgenerica.GUI;

import financasgenerica.DespesaIndividual;
import financasgenerica.Grupo;
import financasgenerica.ItemDespesaIndividual;
import financasgenerica.UsuarioLogado;
import financasgenerica.controler.ControlerDespesa;
import financasgenerica.repositorio.RepositorioGrupo;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
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
class TelaDespesaIndividual extends TelaLogado {

    private JLabel lblNomeDespesa;
    private JLabel lblData;
    private JLabel lblGrupos;
    private JLabel lblValorTotal;
    private double valorTotal;

    private JTable tabelaItens;
    private DefaultTableModel modeloTableItens;

    private JTextField txtNomeDespesa;
    private JTextField dtData;
    private JTextArea txtDescricao;

    private JTextField txtNome;
    private JTextField txtValor;

    private JComboBox<Grupo> cbGrupos;
    private JList<String> lstParticipantes;

    private JButton btnCadastrarDespesa;
    private JButton btnAdicionarItem;
    private JButton btnVoltar;

    private JPanel painelItens;
    private ArrayList<ItemDespesaIndividual> itens;

    public TelaDespesaIndividual() {
        super("Cadastro despesa individual");
        construirTela();
        pack();
        setLocationRelativeTo(null);
    }

    private Grupo[] getGrupoUsuarioLogado() {
        Grupo[] vetorGrupo = new Grupo[RepositorioGrupo.gruposDoUsuarioLogado().size()];
        int i = 0;
        for (Grupo grupo : RepositorioGrupo.gruposDoUsuarioLogado()) {
            vetorGrupo[i] = grupo;
            i++;
        }
        return vetorGrupo;
    }

    private void construirTela() {
        String colunas[] = {"Nome", "Valor"};
        modeloTableItens = new DefaultTableModel(colunas, 0);
        tabelaItens = new JTable(modeloTableItens);

        lblValorTotal = new JLabel("Valor total: 0");
        itens = new ArrayList<>();
        lblNomeDespesa = new JLabel("Nome da despesa");
        txtNomeDespesa = new JTextField(15);

        lblData = new JLabel("Data");
        dtData = new JTextField("dd/mm/aa");

        JScrollPane listScroller = new JScrollPane(tabelaItens);
        listScroller.setPreferredSize(new Dimension(100, 80));

        lblGrupos = new JLabel("Grupo");
        cbGrupos = new JComboBox<>(getGrupoUsuarioLogado());
        cbGrupos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                Grupo grupo = (Grupo) cb.getSelectedItem();
                System.out.println(grupo.getNome());
            }
        });

        txtDescricao = new JTextArea(4, 20);
        txtDescricao.setBorder(javax.swing.BorderFactory.createTitledBorder("Descrição"));
        txtDescricao.setLineWrap(true);
        txtDescricao.setMaximumSize(new Dimension(4, 20));

        this.txtNome = new JTextField(15);
        this.txtValor = new JTextField(5);
        btnAdicionarItem = new JButton("Adicionar item");

        painelItens = new JPanel(getLogadoLayout());
        adicionarComponente(painelItens, lblValorTotal, 0, 0, 1, GridBagConstraints.BOTH);
        adicionarComponente(painelItens, listScroller, 1, 0, 1, GridBagConstraints.BOTH);
        adicionarComponente(painelItens, btnAdicionarItem, 2, 0, 1, GridBagConstraints.BOTH);

        painelItens.setBorder(javax.swing.BorderFactory.createTitledBorder("Itens"));

        btnAdicionarItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarItem();
            }
        });
        btnCadastrarDespesa = new JButton("Cadastrar despesa");
        btnCadastrarDespesa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] teste = dtData.getText().split("/");
                Date data = new Date(System.currentTimeMillis());
                if (ControlerDespesa.cadastrarDespesaIndividual(txtNome.getText(), valorTotal, txtDescricao.getText(), data, UsuarioLogado.getInstance().getUsuario(), itens)) {
                    TelaPrincipal tp = new TelaPrincipal();
                    tp.setVisible(true);
                    dispose();
                }

            }
        });

        btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaPrincipal tl = new TelaPrincipal();
                tl.setVisible(true);
                dispose();
            }
        });

        JPanel painelInfoDespesas = new JPanel(getLogadoLayout());
        adicionarComponente(painelInfoDespesas, lblNomeDespesa, 0, 0, 1, GridBagConstraints.BOTH);
        adicionarComponente(painelInfoDespesas, txtNomeDespesa, 0, 1, 2, GridBagConstraints.BOTH);
        adicionarComponente(painelInfoDespesas, lblData, 1, 0, 1, GridBagConstraints.BOTH);
        adicionarComponente(painelInfoDespesas, dtData, 1, 1, 2, GridBagConstraints.BOTH);
        adicionarComponente(painelInfoDespesas, txtDescricao, 2, 0, 3, GridBagConstraints.BOTH);

        JPanel painelBotoes = new JPanel(getLogadoLayout());
        adicionarComponente(painelBotoes, btnCadastrarDespesa, 0, 0, 1, GridBagConstraints.BOTH);
        adicionarComponente(painelBotoes, btnVoltar, 0, 1, 1, GridBagConstraints.BOTH);

        adicionarComponente(painelInfoDespesas, 0, 0, 1, GridBagConstraints.BOTH, GridBagConstraints.LINE_START);
        adicionarComponente(painelItens, 1, 0, 1, GridBagConstraints.BOTH, GridBagConstraints.LINE_START);
        adicionarComponente(painelBotoes, 2, 0, 1, GridBagConstraints.BOTH, GridBagConstraints.LINE_START);

    }

    public JPanel criarPainelItem(String nome, String valor) {
        JPanel painelItem = new JPanel(getLogadoLayout());
        JLabel lblNome = new JLabel("Nome");
        txtNome.setText(nome);
        JLabel lblValor = new JLabel("Valor");
        txtValor = new JTextField(5);
        txtValor.setText(valor);
        adicionarComponente(painelItem, lblNome, 0, 0, 1, GridBagConstraints.BOTH);
        adicionarComponente(painelItem, txtNome, 0, 1, 1, GridBagConstraints.BOTH);
        adicionarComponente(painelItem, lblValor, 0, 2, 1, GridBagConstraints.BOTH);
        adicionarComponente(painelItem, txtValor, 0, 3, 1, GridBagConstraints.BOTH);
        return painelItem;
    }

    public void adicionarItem() {
        TelaAdicionarItemIndividual tl = new TelaAdicionarItemIndividual(this);
        tl.setVisible(true);
        ItemDespesaIndividual item = tl.getRetorno();
        itens.add(item);
        Object[] obj = {item.getNome(), item.getValor()};
        modeloTableItens.addRow(obj);
        valorTotal += item.getValor();
        lblValorTotal.setText("Valor total: " + valorTotal);

    }
}
