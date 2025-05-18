/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author marcu
 */
public class Compras {
    
    private int id;
    private String formaPagamento;
    private double valorTotal;
    private String dataCompra;
    private String descricaoCompra;
    private Cliente cliente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getDescricaoCompra() {
        return descricaoCompra;
    }

    public void setDescricaoCompra(String descricaoCompra) {
        this.descricaoCompra = descricaoCompra;
    }
    
    public void imprimirAtributos(){
        System.out.println("ID: " + id);
        System.out.println("Forma de Pagamento: " + formaPagamento);
        System.out.println("Valor total da compra: " + valorTotal);
        System.out.println("Data da compra: " + dataCompra);
        System.out.println("Descrição da compra: \n" + descricaoCompra);
        if (cliente != null) {
        System.out.println("Cliente: " + cliente.getNome() + " (ID: " + cliente.getId() + ")");
    }
    }
    
}
