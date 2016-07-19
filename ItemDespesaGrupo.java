/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financasgenerica;

import financasgenerica.exceptions.UsuarioNotInItemException;
import java.util.HashMap;

/**
 *
 * @author Otavio
 */
public class ItemDespesaGrupo extends Item{
    private HashMap<Pessoa,DividaItem> dividaItem;
    public ItemDespesaGrupo(String nome, double valor) {
        super(nome, valor);
        dividaItem = new HashMap<>();
    }
    public ItemDespesaGrupo(String nome, double valor, HashMap<Pessoa,DividaItem> dividaItem) {
        super(nome, valor);
        this.dividaItem = dividaItem;
    }
    public boolean isPessoaInItens(Pessoa p){
        return dividaItem.containsKey(p);
    }
    public void removerPessoa(Pessoa p){
        if(isPessoaInItens(p)){
            this.dividaItem.remove(p);
        }else{
            throw new UsuarioNotInItemException(p.getNome(), getNome());
        }
    }
    public void adicionarPessoa(Pessoa p,DividaItem dividaItem){
        this.dividaItem.put(p,dividaItem);
    }
    public void alterarValorItem(Pessoa p, double novoValor){
        this.dividaItem.put(p, new DividaItem(novoValor));
    }
}
