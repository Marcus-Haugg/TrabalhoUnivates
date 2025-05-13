/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author marcu
 */
public class Produto {
    
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private int qtdeEstoque;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtdeEstoque() {
        return qtdeEstoque;
    }

    public void setQtdeEstoque(int qtdeEstoque) {
        this.qtdeEstoque = qtdeEstoque;
    }
    
    public void imprmiAtributos(){
        System.out.println("ID:" + id);
        System.out.println("Nome:" + nome);
        System.out.println("Descrição:" + descricao);
        System.out.println("Preço:" + preco);
        System.out.println("Quantidade em Estoque:" + qtdeEstoque);
    }
    
    
}
