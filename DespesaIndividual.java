/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financasgenerica;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Otavio
 */
public class DespesaIndividual extends Despesa {

    private final Usuario usuario;
    private ArrayList<ItemDespesaIndividual> itens;

    public DespesaIndividual(String nome, double valor, String descricao, Date data, Usuario usuario, ArrayList<ItemDespesaIndividual> itens) {
        super(nome, valor, data, descricao);
        this.usuario = usuario;
        this.itens = itens;
    }

    /**
     * @deprecated
     */
    public void addItem(String nome, double valor) {
        itens.add(new ItemDespesaIndividual(nome, valor));
    }

    @Override
    public boolean isParticipante(Pessoa pessoa) {
        return usuario.equals((Usuario)pessoa);
    }
}
