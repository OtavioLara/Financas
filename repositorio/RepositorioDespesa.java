/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financasgenerica.repositorio;

import financasgenerica.Despesa;
import financasgenerica.DespesaGrupo;
import financasgenerica.DespesaIndividual;
import financasgenerica.ItemDespesaIndividual;
import financasgenerica.Pessoa;
import financasgenerica.beans.DespesaBeans;
import financasgenerica.beans.DespesaGrupoBeans;
import financasgenerica.beans.DespesaIndividualBeans;
import financasgenerica.beans.ItemDespesaIndividualBeans;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Otavio
 */
public class RepositorioDespesa {

    private static HashMap<Long, Despesa> despesas;
    private static long id;

    public static void adicionarDespesa(Despesa despesa) {
//        carregarDespesas();
        despesas.put(id, despesa);
        gravarDespesa(despesasToDespesasBeans());
    }

    private static void gravarDespesa(HashMap<Long, DespesaBeans> despesasToDespesasBeans) {
        try {
            FileOutputStream fo = new FileOutputStream("despesas.fgd");
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(despesasToDespesasBeans);
            oo.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(RepositorioGrupo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RepositorioGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static HashMap<Long, DespesaBeans> despesasToDespesasBeans() {
        HashMap<Long, DespesaBeans> despesasBeans = new HashMap<>();
        for (Map.Entry<Long, Despesa> entry : despesas.entrySet()) {
            Long key = entry.getKey();
            Despesa value = entry.getValue();
            if (value instanceof DespesaIndividual) {
                DespesaIndividualBeans despesaIdividualBeans = new DespesaIndividualBeans();
                DespesaIndividual despesaIndividual = (DespesaIndividual) value;
                despesaIdividualBeans.setData(despesaIndividual.getData());
                despesaIdividualBeans.setDescricao(despesaIndividual.getDescricao());
                despesaIdividualBeans.setItens(itensDespesaIdividualToBeans(despesaIndividual.getItens()));
                despesaIdividualBeans.setNome(despesaIndividual.getNome());
                despesaIdividualBeans.setUsuario(despesaIndividual.getUsuario());
                despesaIdividualBeans.setValor(despesaIndividual.getValor());
                despesasBeans.put(key, despesaIdividualBeans);
            }
            if (value instanceof DespesaGrupo) {
                //TODO
            }
        }
        return despesasBeans;
    }

    private static ArrayList<ItemDespesaIndividualBeans> itensDespesaIdividualToBeans(ArrayList<ItemDespesaIndividual> itens) {
        ArrayList<ItemDespesaIndividualBeans> itensBeans = new ArrayList<>();
        for (ItemDespesaIndividual item : itens) {
            ItemDespesaIndividualBeans itemBeans = new ItemDespesaIndividualBeans();
            itemBeans.setNome(item.getNome());
            itemBeans.setValor(item.getValor());
            itensBeans.add(itemBeans);
        }
        return itensBeans;
    }

    private static void carregarDespesasBeans() {
        try {
            FileInputStream fi = new FileInputStream("despesas.fgd");
            ObjectInputStream oi = new ObjectInputStream(fi);
            carregarDespesas((HashMap<Long, DespesaBeans>) oi.readObject());
            oi.close();
        } catch (FileNotFoundException ex) {
            despesas = new HashMap<>();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(RepositorioUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void carregarDespesas(HashMap<Long, DespesaBeans> hashMap) {
        despesas = new HashMap<>();
        for (Map.Entry<Long, DespesaBeans> entry : hashMap.entrySet()) {
            Long key = entry.getKey();
            DespesaBeans value = entry.getValue();
            if (value instanceof DespesaIndividualBeans) {
                despesas.put(key, new DespesaIndividual(value.getNome(), value.getValor(), value.getDescricao(),
                        value.getData(), ((DespesaIndividualBeans)value).getUsuario(),
                        beansToItemDespesaIndividual(((DespesaIndividualBeans)value).getItens())));
            } else if (value instanceof DespesaGrupoBeans) {

            }
        }
    }

    private static ArrayList<ItemDespesaIndividual> beansToItemDespesaIndividual(ArrayList<ItemDespesaIndividualBeans> itensBeans) {
        ArrayList<ItemDespesaIndividual> itens = new ArrayList<>();
        for (ItemDespesaIndividualBeans itemBeans : itensBeans) {
            ItemDespesaIndividual item = new ItemDespesaIndividual(itemBeans.getNome(), itemBeans.getValor());
            itens.add(item);
        }
        return itens;
    }

    public static void removerDespesa(Despesa despesa) {
        if (despesas.containsKey(despesa)) {
            despesas.remove(despesa);
        }
    }

    public static ArrayList<Despesa> getDespesas(Pessoa pessoa) {
        ArrayList<Despesa> despesasDoUsuario = new ArrayList<>();
//        for (Despesa despesa : despesas) {
//            if(despesa.isParticipante(pessoa)){
//                despesasDoUsuario.add(despesa);
//            }
//        }
        return despesasDoUsuario;
    }

}
