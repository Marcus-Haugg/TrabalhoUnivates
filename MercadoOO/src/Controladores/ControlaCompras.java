/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Entidades.Compras;
import java.util.ArrayList;
import Apoio.Entrada;
import Entidades.Cliente;
import Controladores.ControlaCliente;

public class ControlaCompras {

    ControlaCliente controlaCliente = new ControlaCliente();

    ArrayList<Compras> compras = new ArrayList();
    int codigo = 1;

    public void salvar(Compras c) {
        c.setId(codigo);
        compras.add(c);
        codigo++;
    }

// public void recuperaTodos() {
//    if (compras.isEmpty()) {
//        System.out.println("Nenhuma compra cadastrada.");
//        return;
//    }
//
//    System.out.println("=== Lista de Compras ===");
//
//    for (int i = 0; i < compras.size(); i++) {
//        Compras c = compras.get(i);
//        System.out.println("ID: " + c.getId());
//        System.out.println("Data da Compra: " + c.getDataCompra());
//        System.out.println("Forma de Pagamento: " + c.getFormaPagamento());
//        System.out.println("Descrição da Compra:");
//        System.out.println(c.getDescricaoCompra());
//        System.out.println("Valor Total: R$ " + c.getValorTotal());
//
//        if (c.getCliente() != null) {
//            System.out.println("Cliente: " + c.getCliente().getNome());
//            System.out.println("CPF do Cliente: " + c.getCliente().getCpf());
//        } else {
//            System.out.println("Cliente: [Nenhum cliente vinculado]");
//        }
//
//        System.out.println("-------------------------------");
//    }
//}
    public void recuperaTodos() {
        if (compras.isEmpty()) {
            System.out.println("Nenhuma compra cadastrada.");
            return;
        }

        System.out.println("Lista de Compras:");
        for (int i = 0; i < compras.size(); i++) {
            Compras c = compras.get(i);

            System.out.println("-------------------------------");
            System.out.println("ID da Compra: " + c.getId());
            System.out.println("Cliente: " + (c.getCliente() != null ? c.getCliente().getNome() : "Não informado"));
            System.out.println("Data da Compra: " + c.getDataCompra());
            System.out.println("Forma de Pagamento: " + c.getFormaPagamento());
            System.out.println("Produtos:");
            System.out.println(c.getDescricaoCompra());
            System.out.printf("Valor Total: R$ %.2f%n", c.getValorTotal());
            System.out.println("-------------------------------\n");
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

    public void editar(Compras compra) {
        String novaFormaPgto = Entrada.leiaString("Forma de pagamento atual: " + compra.getFormaPagamento() + "\nNova forma de pagamento: ");
        String novaData = Entrada.leiaString("Data atual: " + compra.getDataCompra() + "\nNova data da compra: ");

        int novoIdCliente = Entrada.leiaInt("ID atual do cliente: " + compra.getCliente().getId() + "\nNovo ID do cliente: ");
        Cliente novoCliente = controlaCliente.recuperarUm(novoIdCliente);
        if (novoCliente == null) {
            System.out.println("Cliente não encontrado. Cliente não será alterado.");
        } else {
            compra.setCliente(novoCliente);
        }

        compra.setFormaPagamento(novaFormaPgto);
        compra.setDataCompra(novaData);

        System.out.println("Informações da compra atualizadas (produtos não foram alterados).");
    }

//    public void editar(Compras c) {
//        c.setFormaPagamento(Entrada.leiaString("Nova forma de pagamento: "));
//        c.setDataCompra(Entrada.leiaString("Nova data da compra: "));
//
//        // Editar os produtos manualmente
//        String descricao = "";
//        double valorTotal = 0.0;
//
//        int quantidade = Entrada.leiaInt("Quantos produtos deseja adicionar?:");
//
//        for (int i = 0; i < quantidade; i++) {
//            String nomeProduto = Entrada.leiaString("Nome do produto " + (i + 1) + ": ");
//            double preco = Entrada.leiaDouble("Preço do produto " + (i + 1) + ": ");
//
//            descricao += nomeProduto + " (R$ " + preco + ")\n";
//            valorTotal += preco;
//        }
//
//        c.setDescricaoCompra(descricao);
//        c.setValorTotal(valorTotal);
//
//        System.out.println("Compra atualizada com sucesso!");
//    }
//
}
