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

//Salvar
    public void salvar(Compras c) {
        c.setId(codigo);
        compras.add(c);
        codigo++;
    }

//Recuperar todos
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
            System.out.println("Cliente: " + c.getCliente().getNome());
            System.out.println("Data da Compra: " + c.getDataCompra());
            System.out.println("Forma de Pagamento: " + c.getFormaPagamento());
            System.out.println("Produtos:");
            System.out.println(c.getDescricaoCompra());
            System.out.printf("Valor Total: R$", c.getValorTotal());
            System.out.println("-------------------------------\n");
        }
    }

//Recuperar um
    public Compras recuperarUm(int id) {
        for (int i = 0; i < compras.size(); i++) {
            Compras c = compras.get(i);
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

//Excluir
    public void excluir(Compras c) {
        compras.remove(c);
    }

//Editar
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

        System.out.println("Informações da compra atualizadas.");
    }


}
