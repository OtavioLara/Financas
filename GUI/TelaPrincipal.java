/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financasgenerica.GUI;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Otavio
 */
public class TelaPrincipal extends TelaLogado {



    private JLabel lblDivida;
    private JLabel lblAReceber;
    private JLabel lblValorDivida;
    private JLabel lblValorAReceber;

    private JButton btnCadastrarDespesa;
    private JButton btnContasPendentes;
    private JButton btnHistorico;
    private JButton btnGrupos;
    private JButton btnReceberPagamento;

    public TelaPrincipal() {
        super("Finanças genéricas");
        construirTela();
        pack();
        setLocationRelativeTo(null);
    }

    private void construirTela() {

        lblDivida = new JLabel("Preciso pagar");
        lblAReceber = new JLabel("Preciso receber");
        lblValorDivida = new JLabel("R$ 0,00");

        lblValorAReceber = new JLabel("R$ 0,00");

        btnCadastrarDespesa = new JButton("Cadastrar despesa");
        btnContasPendentes = new JButton("Contas pendentes");
        btnHistorico = new JButton("Histórico de despesas");
        btnGrupos = new JButton("Administrar grupos");
        btnGrupos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaGerenciaGrupos tl = new TelaGerenciaGrupos();
                tl.setVisible(true);
                dispose();
            }
        });
        btnReceberPagamento = new JButton("Registrar pagamentos");

        JPanel painelResumo = new JPanel();
        painelResumo.setLayout(getLogadoLayout());
        adicionarComponente(painelResumo, lblDivida, 0, 0, 2, GridBagConstraints.BOTH, new Insets(3, 3, 3, 50));
        adicionarComponente(painelResumo, lblValorDivida, 1, 0, 2, GridBagConstraints.BOTH, new Insets(3, 3, 3, 50));
        adicionarComponente(painelResumo, lblAReceber, 0, 2, 2, GridBagConstraints.BOTH, new Insets(3, 50, 3, 3));
        adicionarComponente(painelResumo, lblValorAReceber, 1, 2, 2, GridBagConstraints.BOTH, new Insets(3, 50, 3, 3));
        painelResumo.setBorder(javax.swing.BorderFactory.createTitledBorder("Resumo geral"));

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout());
        painelBotoes.add(btnCadastrarDespesa);
        painelBotoes.add(btnContasPendentes);
        painelBotoes.add(btnHistorico);
        painelBotoes.add(btnGrupos);
        painelBotoes.add(btnGrupos);

        adicionarComponente(painelResumo, 0, 0, 4, GridBagConstraints.BOTH, GridBagConstraints.LINE_START);
        adicionarComponente(painelBotoes, 1, 0, 4, GridBagConstraints.BOTH, GridBagConstraints.LINE_END);
    }
}
