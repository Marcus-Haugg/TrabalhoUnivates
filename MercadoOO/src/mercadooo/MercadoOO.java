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

/**
 *
 * @author marcu
 */
public class MercadoOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ControlaCliente cliente = new ControlaCliente();
        ControlaProduto produto = new ControlaProduto();
        ControlaCompras compras = new ControlaCompras();

        int opcao = 0;

        while (opcao != 99) {

            opcao = Entrada.leiaInt(""
                    + "[1] Cadastrar Produto\n"
                    + "[2] Listar Produtos\n"
                    + "[3] Excluir Produto\n"
                    + "[4] Editar Produto\n"
                    + "[5] Recuperar um Produto\n"
                    + "[6] Cadastrar Cliente\n"
                    + "[7] Listar Clientes\n"
                    + "[8] Excluir Cliente\n"
                    + "[9] Editar Cliente\n"
                    + "[10] Recuperar Cliente\n"
                    + "[11] Cadastrar Compras\n"
                    + "[12] Listar Compras \n"
                    + "[13] Excluir Compra\n"
                    + "[14] Editar Compra\n"
                    + "[15] Recuperar Compra\n"
                    + "[99] Sair do Sistema\n"
            );

            if (opcao == 1) {

                Produto p1 = new Produto();

                p1.setNome(Entrada.leiaString("Digite o nome do produto que deseja cadastrar:"));
                p1.setPreco(Entrada.leiaDouble("Digite o valor do produto:"));
                p1.setQtdeEstoque(Entrada.leiaInt("Informe a quantidade do produto disponível no estoque:"));

                produto.salvar(p1);

            } else if (opcao == 2) {
                produto.recuperaTodos();

            } else if (opcao == 3) {
                int id = Entrada.leiaInt("Digite o ID do produto que deseja excluir:");
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
                c.setTelefone(Entrada.leiaString("Digite o Telefone do cliente:"));
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
//            if (opcao == 11) {
//                // Instanciando o objeto 'Compra'
//                Compras compra = new Compras();
//
//                // Recebendo os dados da compra
//                compra.setFormaPagamento(Entrada.leiaString("Forma de pagamento: "));
//                compra.setDataCompra(Entrada.leiaString("Data da compra: "));
//
//                // Perguntando quantos produtos serão comprados
//                int quantidade = Entrada.leiaInt("Quantos produtos deseja adicionar?");
//
//                // Criando um vetor para armazenar os nomes dos produtos
//                String[] produtos = new String[quantidade];
//                double valorTotal = 0.0;
//                String descricao = "";
//
//                // Loop para adicionar os produtos e seus preços
//                for (int i = 0; i < quantidade; i++) {
//                    produtos[i] = Entrada.leiaString("Nome do produto " + (i + 1) + ": ");
//                    double preco = Entrada.leiaDouble("Preço do produto " + (i + 1) + ": ");
//                    valorTotal += preco; // Somando o valor total
//                    descricao += produtos[i] + " (R$ " + preco + ")\n";
//                }
//
//                // Definindo os valores na compra
//                compra.setDescricaoCompra(descricao);
//                compra.setValorTotal(valorTotal);
//
//                // Simulando a função de salvar
//                compras.salvar(compra);
//
//                System.out.println("Compra cadastrada com sucesso!");
            if (opcao == 11) {
                Compras compra = new Compras();

                compra.setFormaPagamento(Entrada.leiaString("Forma de pagamento: "));
                compra.setDataCompra(Entrada.leiaString("Data da compra: "));

                int quantidade = Entrada.leiaInt("Quantos produtos deseja adicionar?");
                String[] produtos = new String[quantidade];
                int[] quantidades = new int[quantidade];
                double[] precos = new double[quantidade];
                double valorTotal = 0.0;
                String descricao = "";

                for (int i = 0; i < quantidade; i++) {
                    produtos[i] = Entrada.leiaString("Nome do produto " + (i + 1) + ": ");
                    quantidades[i] = Entrada.leiaInt("Quantidade de " + produtos[i] + ": ");
                    precos[i] = Entrada.leiaDouble("Preço unitário de " + produtos[i] + ": ");

                    valorTotal += precos[i] * quantidades[i];

                    descricao += produtos[i] + " x" + quantidades[i]
                            + " (R$ " + precos[i] + " cada)\n";
                }

                compra.setDescricaoCompra(descricao);
                compra.setValorTotal(valorTotal);

                compras.salvar(compra);
                System.out.println("Compra cadastrada com sucesso!");

            } else if (opcao == 12) {
                compras.recuperaTodos();

            } else if (opcao == 13) {
                int id = Entrada.leiaInt("Digite o ID da compra que deseja excluir:");
                Compras compraTemp = compras.recuperarUm(id);
                if (compraTemp != null) {
                    compras.excluir(compraTemp);
                    System.out.println("Compra excluída com sucesso!");
                } else {
                    System.out.println("Compra não encontrada.");
                }

            } else if (opcao == 14) {
                int id = Entrada.leiaInt("Digite o ID da compra que deseja editar:");
                Compras compraTemp = compras.recuperarUm(id);
                if (compraTemp != null) {
                    compras.editar(compraTemp);
                } else {
                    System.out.println("Compra não encontrada.");
                }

            } else if (opcao == 15) {
                int id = Entrada.leiaInt("Digite o ID da compra que deseja recuperar:");
                Compras compraTemp = compras.recuperarUm(id);
                if (compraTemp != null) {
                    System.out.println("### COMPRA RECUPERADA ###");
                    compraTemp.imprimiAtributos();
                } else {
                    System.out.println("Compra não encontrada.");
                }
            }

        }
        System.exit(0);
    }

}
