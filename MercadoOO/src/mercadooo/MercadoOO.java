/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mercadooo;

import Controller.ControllerCliente;
import Controller.ControllerCompras;
import Controller.ControllerProduto;
import Model.Cliente;
import Model.Produto;
import a2_poo.Entrada;

/**
 *
 * @author marcu
 */
public class MercadoOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ControllerCliente cliente = new ControllerCliente();
        ControllerProduto produto = new ControllerProduto();
        ControllerCompras compras = new ControllerCompras();

        int opcao = 0;

        while (opcao != 99) {

            opcao = Entrada.leiaInt(""
                    + "[1] Cadastrar Produto\n"
                    + "[2] Listar Produtos\n"
                    + "[3] Excluir Produto\n"
                    + "[4] Editar Produto\n"
                    + "[5] Recuperar um Produto\n"
                    + "[6] Cadastrar Cliente\n"
                    + "[7] Listra Clientes\n"
                    + "[8] Exluir Cliente\n"
                    + "[9] Editar Cliente\n"
                    + "[10] Recuperar Cliente\n"
                    + "[11] Cadastrar Compras\n"
                    + "[12] Listar Compras \n"
                    + "[13] Excluir Compra\n"
                    + "[14] Editar Compra\n"
                    + "[15] Recuperar Compra\n"
                    + "[16] Editar Compra\n"
                    + "[99] Sair do Sistema\n"
            );

            if (opcao == 1) {

                Produto p1 = new Produto();

                p1.setNome(Entrada.leiaString("Digite o nome do produtodo que deseja cadastrar:"));
                p1.setDescricao(Entrada.leiaString("Escreva uma breve descrição do produto:"));
                p1.setPreco(Entrada.leiaDouble("Escrva o valor do produto:"));
                p1.setQtdeEstoque(Entrada.leiaInt("Informe a quantidade do produto disponivel no estoque:"));

                produto.salvar(p1);

            } else if (opcao == 2) {
                produto.recuperaTodos();

            } else if (opcao == 3) {
                int id = Entrada.leiaInt("Digite o ID do porduto que deseja excluir:");
                Produto protudoTemporario = produto.recuperarUm(id);
                produto.excluir(protudoTemporario);

            } else if (opcao == 4) {
                int id = Entrada.leiaInt("Digite o ID do produto que deseja editar:");
                Produto protudoTemporario = produto.recuperarUm(id);
                produto.editar(protudoTemporario);

            } else if (opcao == 5) {
                int id = Entrada.leiaInt("Digite o ID do produto que deseja recuperar:");
                System.out.println("IMRIMINDO PRODUTO Recuperado...");
                Produto protudoTemporario = produto.recuperarUm(id);
                protudoTemporario.imprmiAtributos();

            } else if (opcao == 6) {
                Cliente c = new Cliente();
                c.setNome(Entrada.leiaString("Digite o nome do cliente que deseja cadastrar:"));
                c.setCpf(Entrada.leiaString("Digite o CPF do cliente:"));
                c.setEmail(Entrada.leiaString("Digite o Email do cliente :"));
                c.setTelefone(Entrada.leiaString("Digite o Telefono do cliente:"));
                cliente.salvar(c);

            } else if (opcao == 7) {
                cliente.recuperaTodos();

            } else if (opcao == 8) {
                int id = Entrada.leiaInt("Digite o ID do cliente que deseja excluir:");
                Cliente clienteTemporario = cliente.recuperarUm(id);
                cliente.excluir(clienteTemporario);

            } else if (opcao == 9) {
                int id = Entrada.leiaInt("Digite o ID do Cliente que deseja editar:");
                Cliente clienteTemporario = cliente.recuperarUm(id);
                cliente.editar(clienteTemporario);

            } else if (opcao == 10) {
                int id = Entrada.leiaInt("Digite o ID do Cliente que deseja recuperar:");
                System.out.println("IMRIMINDO CLIENTE RECUPERADO...");
                Cliente clienteTemporario = cliente.recuperarUm(id);
                clienteTemporario.imprimiAtributos();
            }

        }

    }

}
