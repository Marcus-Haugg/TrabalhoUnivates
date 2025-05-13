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
        c.setFormaPagamento(Entrada.leiaString("Nova forma de pagamento:"));
        c.setDataCompra(Entrada.leiaString("Nova data da compra:"));
        c.setDescricaoCompra(Entrada.leiaString("Nova descrição da compra:"));
    }
}
