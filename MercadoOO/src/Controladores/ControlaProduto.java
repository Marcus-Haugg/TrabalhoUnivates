/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Entidades.Produto;
import java.util.ArrayList;
import Apoio.Entrada;

/**
 *
 * @author marcu
 */
public class ControlaProduto {

    ArrayList<Produto> produtos = new ArrayList();
    int codigo = 1;

    public void salvar(Produto p) {
        p.setId(codigo);
        produtos.add(p);
        codigo++;

    }

    public void recuperaTodos() {
        System.out.println("#### IMPRIMINDO PRODUTOS ####");
        for (int i = 0; i < produtos.size(); i++) {
            Produto produtoTemporario = produtos.get(i);
            produtoTemporario.imprmiAtributos();

        }
    }

    public void excluir(Produto p) {
        produtos.remove(p);
    }

    public Produto recuperarUm(int id) {
        for (int i = 0; i < produtos.size(); i++) {
            Produto protudoTemporario = produtos.get(i);
            if (protudoTemporario.getId() == id) {
                return protudoTemporario;
            }
        }

        return null;

    }

    public void editar(Produto p) {
        System.out.println("###  ÁREA DE EDIÇÃO DE INFORMAÇÕES REFERENTE A PRODUTOS  ###");
        p.setNome(Entrada.leiaString("Digite o novo nome do produto:"));
        p.setPreco(Entrada.leiaDouble("Digite o novo preço do Produto:"));
        p.setQtdeEstoque(Entrada.leiaInt("Digite a nova quantidade do estoque:"));

    }

}
