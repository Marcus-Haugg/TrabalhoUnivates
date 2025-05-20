/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mercadooo;

import Controladores.ControlaCliente;
import Controladores.ControlaCompras;
import Controladores.ControlaProduto;
import Entidades.Cliente;
import Entidades.Produto;
import Entidades.Compras;
import Apoio.Entrada;

public class MercadoOO {

    public static void main(String[] args) {

        ControlaCliente cliente = new ControlaCliente();
        ControlaProduto produto = new ControlaProduto();
        ControlaCompras compras = new ControlaCompras();

        int opcao = 0;

        while (opcao != 99) {

            opcao = Entrada.leiaInt("""
                    [1] Cadastrar Produto
                    [2] Listar Produtos
                    [3] Excluir Produto
                    [4] Editar Produto
                    [5] Recuperar um Produto
                    [6] Cadastrar Cliente
                    [7] Listar Clientes
                    [8] Excluir Cliente
                    [9] Editar Cliente
                    [10] Recuperar Cliente
                    [11] Cadastrar Compras
                    [12] Listar Compras 
                    [13] Excluir Compra
                    [14] Editar Compra
                    [15] Recuperar Compra
                    [99] Sair do Sistema
                    """);

//Opção 1 (Cadastrar produto)
            if (opcao == 1) {
                Produto p1 = new Produto();
                p1.setNome(Entrada.leiaString("Digite o nome do produto que deseja cadastrar: "));
                p1.setPreco(Entrada.leiaDouble("Digite o valor do produto: "));
                p1.setQtdeEstoque(Entrada.leiaInt("Informe a quantidade do produto disponível no estoque: "));
                produto.salvar(p1);

//Opção 2 (Listrar produtos)              
            } else if (opcao == 2) {
                produto.recuperaTodos();

//Opção 3 (Excluir produto)           
            } else if (opcao == 3) {
                int id = Entrada.leiaInt("Digite o ID do produto que deseja excluir: ");
                Produto produtoTemporario = produto.recuperarUm(id);
                produto.excluir(produtoTemporario);

//Opção 4 (Editar produto)               
            } else if (opcao == 4) {
                int id = Entrada.leiaInt("Digite o ID do produto que deseja editar: ");
                Produto produtoTemporario = produto.recuperarUm(id);
                produto.editar(produtoTemporario);

//Opção 5 (Recuperar um produto)                
            } else if (opcao == 5) {
                int id = Entrada.leiaInt("Digite o ID do produto que deseja recuperar: ");
                System.out.println("IMPRIMINDO PRODUTO Recuperado...");
                Produto produtoTemporario = produto.recuperarUm(id);
                produtoTemporario.imprimirAtributos();

//Opção 6 (Cadastrar cliente)
            } else if (opcao == 6) {
                Cliente c = new Cliente();
                c.setNome(Entrada.leiaString("Digite o nome do cliente que deseja cadastrar: "));
                c.setCpf(Entrada.leiaString("Digite o CPF do cliente: "));
                c.setEmail(Entrada.leiaString("Digite o Email do cliente : "));
                c.setTelefone(Entrada.leiaString("Digite o Telefone do cliente: "));
                cliente.salvar(c);

//Opção 7 (Listar clientes)
            } else if (opcao == 7) {
                cliente.recuperaTodos();

//Opção 8 (Excluir cliente)
            } else if (opcao == 8) {
                int id = Entrada.leiaInt("Digite o ID do cliente que deseja excluir: ");
                Cliente clienteTemporario = cliente.recuperarUm(id);
                cliente.excluir(clienteTemporario);

//Opção 9 (Editar cliente)
            } else if (opcao == 9) {
                int id = Entrada.leiaInt("Digite o ID do Cliente que deseja editar: ");
                Cliente clienteTemporario = cliente.recuperarUm(id);
                cliente.editar(clienteTemporario);

//Opção 10 (Recuperar um cliente)
            } else if (opcao == 10) {
                int id = Entrada.leiaInt("Digite o ID do Cliente que deseja recuperar: ");
                System.out.println("IMPRIMINDO CLIENTE RECUPERADO...");
                Cliente clienteTemporario = cliente.recuperarUm(id);
                clienteTemporario.imprimirAtributos();

//Opção 11 (Cadastrar compra)
            } else if (opcao == 11) {
                Compras compraTemporaria = new Compras();

                compraTemporaria.setFormaPagamento(Entrada.leiaString("Forma de pagamento: "));
                compraTemporaria.setDataCompra(Entrada.leiaString("Data da compra: "));

                int idCliente = Entrada.leiaInt("ID do cliente da compra: ");
                Cliente clienteTemporario = cliente.recuperarUm(idCliente);
                if (clienteTemporario == null) {
                    System.out.println("Cliente não encontrado. Compra cancelada.");
                    continue;
                }
                compraTemporaria.setCliente(clienteTemporario);

                int quantidade = Entrada.leiaInt("Quantos produtos deseja adicionar?");
                String descricao = "";
                double valorTotal = 0.0;

                for (int i = 0; i < quantidade; i++) {
                    int idProduto = Entrada.leiaInt("ID do produto " + (i + 1) + ": ");
                    Produto produtoTemporario = produto.recuperarUm(idProduto);
                    if (produtoTemporario == null) {
                        System.out.println("Produto com ID " + idProduto + " não encontrado.");
                        i--;
                        continue;
                    }

                    int qtde = Entrada.leiaInt("Quantidade de " + produtoTemporario.getNome() + ": ");
                    double valorItem = produtoTemporario.getPreco() * qtde;

                    descricao += produtoTemporario.getNome() + " x" + qtde
                            + " (R$ " + produtoTemporario.getPreco() + " cada)\n";
                    valorTotal += valorItem;
                }

                compraTemporaria.setDescricaoCompra(descricao);
                compraTemporaria.setValorTotal(valorTotal);
                compras.salvar(compraTemporaria);

                System.out.println("Compra cadastrada com sucesso!");

//Opção 12 (Listar compras)
            } else if (opcao == 12) {
                compras.recuperaTodos();

//Opção 13 (Excluir compra)
            } else if (opcao == 13) {
                int id = Entrada.leiaInt("Digite o ID da compra que deseja excluir: ");
                Compras compraTemporaria = compras.recuperarUm(id);
                if (compraTemporaria != null) {
                    compras.excluir(compraTemporaria);
                    System.out.println("Compra excluída com sucesso!");
                } else {
                    System.out.println("Compra não encontrada.");
                }

//Opção 14 (Editar compra)                
            } else if (opcao == 14) {
                int id = Entrada.leiaInt("Digite o ID da compra que deseja editar: ");
                Compras compraTemporaria = compras.recuperarUm(id);

                if (compraTemporaria != null) {
                    int idCliente = Entrada.leiaInt("Digite o ID do cliente associado à compra: ");
                    Cliente clienteTemporario = cliente.recuperarUm(idCliente);

                    if (clienteTemporario != null) {
                        compraTemporaria.setCliente(clienteTemporario);
                        compras.editar(compraTemporaria);
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }

                } else {
                    System.out.println("Compra não encontrada.");
                }

//Opção 15 (Recuperar uma compra)                
            } else if (opcao == 15) {
                int id = Entrada.leiaInt("Digite o ID da compra que deseja recuperar: ");
                Compras compraTemporaria = compras.recuperarUm(id);
                if (compraTemporaria != null) {
                    System.out.println("### COMPRA RECUPERADA ###");
                    compraTemporaria.imprimirAtributos();
                } else {
                    System.out.println("Compra não encontrada.");
                }
            }
        }

        System.exit(0);
    }
}
