/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financasgenerica.controler;

import financasgenerica.Despesa;
import financasgenerica.DespesaGrupo;
import financasgenerica.DespesaIndividual;
import financasgenerica.DividaDespesa;
import financasgenerica.Grupo;
import financasgenerica.ItemDespesaGrupo;
import financasgenerica.ItemDespesaIndividual;
import financasgenerica.Pessoa;
import financasgenerica.repositorio.RepositorioDespesa;
import financasgenerica.repositorio.RepositorioUsuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author Otavio
 */
public class ControlerDespesa {
    
    public static void cadastrarDespesaIndividual(String nome, double valor, String descricao, Date data, String userName, ArrayList<ItemDespesaIndividual> itens) {
        RepositorioDespesa.adicionarDespesa(new DespesaIndividual(nome, valor, descricao, data, userName, itens));
    }

    public static void cadastrarDespesaGrupo(String nome, double valor, String descricao, Date data, Date dataAlerta, long idGrupo, HashMap<String, DividaDespesa> integrantes, ArrayList<ItemDespesaGrupo> itens) {
        RepositorioDespesa.adicionarDespesa(new DespesaGrupo(nome, valor, descricao, data, dataAlerta, idGrupo, integrantes, itens));
    }
    public static void getTotalDespesas(Pessoa pessoa){
        ArrayList<Despesa> despesas= RepositorioDespesa.getDespesas(pessoa);
        for (Despesa despesa : despesas) {
            despesa.getValor();
        }
    }
    
}
