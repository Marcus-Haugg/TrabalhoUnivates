/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Entidades.Compras;
import java.util.ArrayList;
import Apoio.Entrada;

public class ControlaCompras {

    ArrayList<Compras> compras = new ArrayList();
    int codigo = 1;

    public void salvar(Compras c) {
        c.setId(codigo);
        compras.add(c);
        codigo++;
    }

    public void recuperaTodos() {
        System.out.println("#### LISTA DE COMPRAS ####");
        for (int i = 0; i < compras.size(); i++) {
            compras.get(i).imprimiAtributos();
        }
    }

    public Compras recuperarUm(int id) {
        for (int i = 0; i < compras.size(); i++) {
            Compras c = compras.get(i);
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public void excluir(Compras c) {
        compras.remove(c);
    }

    public void editar(Compras c) {
        System.out.println("### EDIÇÃO DE COMPRA ###");

        // Editando forma de pagamento e data da compra
        c.setFormaPagamento(Entrada.leiaString("Nova forma de pagamento: "));
        c.setDataCompra(Entrada.leiaString("Nova data da compra: "));

        // Pergunta quantos produtos deseja adicionar
        int quantidade = Entrada.leiaInt("Quantos produtos?");

        // Vetores auxiliares
        String[] produtos = new String[quantidade];
        int[] quantidades = new int[quantidade];
        double[] precos = new double[quantidade];
        double valorTotal = 0.0;
        String descricao = "";

        // Loop para inserir dados de cada produto
        for (int i = 0; i < quantidade; i++) {
            produtos[i] = Entrada.leiaString("Nome do produto " + (i + 1) + ": ");
            quantidades[i] = Entrada.leiaInt("Quantidade de " + produtos[i] + ": ");
            precos[i] = Entrada.leiaDouble("Preço unitário de " + produtos[i] + ": ");

            valorTotal += quantidades[i] * precos[i];
            descricao += produtos[i] + " x" + quantidades[i] + " (R$ " + precos[i] + " cada)\n";
        }

        // Atualiza os dados da compra
        c.setDescricaoCompra(descricao);
        c.setValorTotal(valorTotal);

        System.out.println("Compra editada com sucesso!");
    }

//    public void editar(Compras c) {
//    System.out.println("### EDIÇÃO DE COMPRA ###");
//    
//    // Editando forma de pagamento e data da compra
//    c.setFormaPagamento(Entrada.leiaString("Nova forma de pagamento: "));
//    c.setDataCompra(Entrada.leiaString("Nova data da compra: "));
//    
//    // Perguntando se o usuário quer alterar a descrição e os produtos
//    int quantidade = Entrada.leiaInt("Quantos produtos?");
//    
//    // Criando um novo vetor para armazenar os nomes dos produtos
//    String[] produtos = new String[quantidade];
//    double valorTotal = 0.0;
//    String descricao = "";
//    
//    // Loop para editar os produtos e seus preços
//    for (int i = 0; i < quantidade; i++) {
//        produtos[i] = Entrada.leiaString("Nome do produto " + (i + 1) + ": ");
//        double preco = Entrada.leiaDouble("Preço do produto " + (i + 1) + ": ");
//        valorTotal += preco; // Somando o valor total
//        descricao += produtos[i] + " (R$ " + preco + ")\n"; // Concatenando a descrição
//    }
//
//    // Atualizando os dados da compra
//    c.setDescricaoCompra(descricao);
//    c.setValorTotal(valorTotal);
//
//    System.out.println("Compra editada com sucesso!");
//}
}
