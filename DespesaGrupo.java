/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financasgenerica;

import financasgenerica.exceptions.SomaNaoCorrespondeAValorException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Otavio
 */
public class DespesaGrupo extends Despesa{

    private Date dataAlerta;
    private ArrayList<ItemDespesaGrupo> itens;
    private HashMap<Pessoa, DividaDespesa> integrantes;
    private Grupo grupo;
    
    public DespesaGrupo(String nome, double valor, String descricao, Date data,
            Date dataAlerta,Grupo grupo, HashMap<Pessoa, DividaDespesa> integrantes,
            ArrayList<ItemDespesaGrupo> itens) {
        super(nome, valor, data, descricao);
        this.grupo = grupo;
        this.integrantes = integrantes;
        this.dataAlerta = dataAlerta;
        setItens(itens, valor);
    }


    public void removerIntegrante(Usuario u) {
        if (integrantes.containsKey(u)) {
            integrantes.remove(u);
        }
        if (integrantes.isEmpty()) {

        }
    }

    public void inserirIntegrante(Usuario u) {
        if (!integrantes.containsKey(u)) {
            integrantes.put(u, new DividaDespesa(0, 0));
        }

    }

    public void setItens(ArrayList<ItemDespesaGrupo> itens, double valor) {
        if (verificaSomaItens(itens, valor)) {
            this.itens = itens;
        } else {
            throw new SomaNaoCorrespondeAValorException(somaItens(itens), valor);
        }
    }

    private boolean verificaSomaItens(ArrayList<ItemDespesaGrupo> itens, double valor) {
        return (somaItens(itens) == valor);
    }

    private double somaItens(ArrayList<ItemDespesaGrupo> itens) {
        double soma = 0;
        for (Item item : itens) {
            soma += item.getValor();
        }
        return soma;
    }
    
    @Override
    public boolean isParticipante(Pessoa pessoa) {
        return integrantes.containsKey(pessoa);
    }
}
