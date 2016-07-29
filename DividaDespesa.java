/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financasgenerica;

/**
 *
 * @author Otavio
 */
public class DividaDespesa extends Divida {
    private double valorPago;

    public DividaDespesa(double valorTotal,double valorPago) {
        super(valorTotal);
        this.valorPago = valorPago;
    }

    /**
     * compara duas dividas
     * @param outra
     * @return true se a divida for maior que outra e false se a divida for maior que a outra
     */
    public boolean isMaior(DividaDespesa outra){
        return this.getValor() == outra.getValor();
    }
    public double getValorPago() {
        return valorPago;
    }
    public double valorApagar(){
        return getValor() - valorPago;
    }
    public double valorAreceber(){
        isMaior(this);
        return valorPago - getValor();
    
    }
}
