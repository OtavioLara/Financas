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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Otavio
 */
class TelaDespesaIndividual extends TelaLogado {

    JLabel lblNomeDespesa;
    JLabel lblData;
    JLabel lblGrupos;

    JTextField txtNomeDespesa;
    JTextField dtData;
    JTextArea txtDescricao;

    JComboBox<Grupo> cbGrupos;
    JList<String> lstParticipantes;

    JButton btnCadastrarDespesa;
    JButton btnAdicionarItem;
    JButton btnVoltar;

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
        lblNomeDespesa = new JLabel("Nome da despesa");
        txtNomeDespesa = new JTextField(15);

        lblData = new JLabel("Data");
        dtData = new JTextField("dd/mm/aa");

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
        btnAdicionarItem = new JButton("Adicionar item");
        JPanel painelItens = new JPanel(getLogadoLayout());
        btnAdicionarItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaAdicionarItemIndividual tl = null;
                if(tl == null)
                    tl = new TelaAdicionarItemIndividual();
                    tl.setVisible(true);
                    tl.getNome();
                    tl.getValor();
                    
            }
        });
        btnCadastrarDespesa = new JButton("Cadastrar despesa");
        btnCadastrarDespesa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        adicionarComponente(painelInfoDespesas, lblGrupos, 3, 0, 1, GridBagConstraints.BOTH);
        adicionarComponente(painelInfoDespesas, cbGrupos, 3, 1, 2, GridBagConstraints.BOTH);

        JPanel painelBotoes = new JPanel(getLogadoLayout());
        adicionarComponente(painelBotoes, btnCadastrarDespesa, 0, 0, 1, GridBagConstraints.BOTH);
        adicionarComponente(painelBotoes, btnVoltar, 0, 1, 1, GridBagConstraints.BOTH);

        adicionarComponente(painelInfoDespesas, 0, 0, 1, GridBagConstraints.BOTH, GridBagConstraints.LINE_START);
        adicionarComponente(painelBotoes, 1, 0, 1, GridBagConstraints.BOTH, GridBagConstraints.LINE_START);
    }
    
    public JPanel criarPainelItem(String nome, String valor){
        JPanel painelItem = new JPanel(getLogadoLayout());
        JLabel lblNome = new JLabel("Nome");
        JTextField txtNome = new JTextField(15);
        txtNome.setText(nome);
        JLabel lblValor = new JLabel("Valor");
        JTextField txtValor = new JTextField(5);
        txtValor.setText(valor);
        adicionarComponente(painelItem, lblNome, 0 , 0, 1, GridBagConstraints.BOTH);
        adicionarComponente(painelItem, txtNome, 0 , 1, 2, GridBagConstraints.BOTH);
        adicionarComponente(painelItem, lblValor, 1 , 0, 1, GridBagConstraints.BOTH);
        adicionarComponente(painelItem, txtValor, 1 , 1, 1, GridBagConstraints.BOTH);
        return painelItem;
    }
}
