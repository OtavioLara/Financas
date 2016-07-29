/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financasgenerica.GUI;

import financasgenerica.Despesa;
import financasgenerica.DespesaGrupo;
import financasgenerica.DespesaIndividual;
import financasgenerica.controler.ControlerDespesa;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Otavio
 */
public class TelaHistorico extends TelaLogado {

    private JPanel painelPrincipal;
    private JTable tabelaItens;
    private DefaultTableModel modeloTableItens;

    private JButton btnVoltar;
    public TelaHistorico() {
        super("Histórico");
        construirTela();
        pack();
        setLocationRelativeTo(null);
    }

    private void contruirTabela() {
        HashMap<Long, Despesa> despesas = ControlerDespesa.getTotalDespesasDoUsuarioLogado();

        for (Map.Entry<Long, Despesa> entry : despesas.entrySet()) {
            Long key = entry.getKey();
            Despesa value = entry.getValue();
            Object[] obj = new Object[4];
            String data = value.getData().getDate() + "/" + (value.getData().getMonth()+1) + "/"+ (value.getData().getYear()+1900);
            if (value instanceof DespesaGrupo) {
                obj[0] = value.getNome();
                obj[1] = value.getValor();
                obj[2] = data;
                obj[3] = ((DespesaGrupo) value).getIdGrupo();
            } else if (value instanceof DespesaIndividual) {
                obj[0] = value.getNome();
                obj[1] = value.getValor();
                obj[2] = data;
                obj[3] = "Individual";
            }
            modeloTableItens.addRow(obj);
        }

    }

    private void construirTela() {
        painelPrincipal = new JPanel(getLogadoLayout());
        String colunas[] = {"Nome", "Valor pago","Data", "Grupo"};

        btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaPrincipal tp = new TelaPrincipal();
                tp.setVisible(true);
                dispose();
            }
        });
        modeloTableItens = new DefaultTableModel(colunas, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabelaItens = new JTable(modeloTableItens);

        JScrollPane listScroller = new JScrollPane(tabelaItens);
        listScroller.setPreferredSize(new Dimension(300, 150));

        contruirTabela();

        adicionarComponente(painelPrincipal, listScroller, 0, 0, 1, GridBagConstraints.BOTH);
        adicionarComponente(painelPrincipal, btnVoltar, 1, 0, 1, GridBagConstraints.BOTH);
        add(painelPrincipal);
    }

}
