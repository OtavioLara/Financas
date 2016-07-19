/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financasgenerica.repositorio;

import financasgenerica.Despesa;
import financasgenerica.Pessoa;
import java.util.ArrayList;

/**
 *
 * @author Otavio
 */
public class RepositorioDespesa {

    private static ArrayList<Despesa> despesas = new ArrayList<>();

    public static void adicionarDespesa(Despesa despesa) {
        despesas.add(despesa);
    }

    public static void removerDespesa(Despesa despesa) {
        if (despesas.contains(despesa)) {
            despesas.remove(despesa);
        }
    }
    public static ArrayList<Despesa> getDespesas(Pessoa pessoa){
        ArrayList<Despesa> despesasDoUsuario = new ArrayList<>();
        for (Despesa despesa : despesas) {
            if(despesa.isParticipante(pessoa)){
                despesasDoUsuario.add(despesa);
            }
        }
        return despesasDoUsuario;
    }
}
