/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Entidades.Cliente;
import java.util.ArrayList;
import Apoio.Entrada;

/**
 *
 * @author marcu
 */
public class ControlaCliente {

    ArrayList<Cliente> clientes = new ArrayList();
    int codigo = 1;

    public void salvar(Cliente c) {
        c.setId(codigo);
        clientes.add(c);
        codigo++;

    }

    public void recuperaTodos() {
        System.out.println("#### IMPRIMINDO CLIENTES ####");
        for (int i = 0; i < clientes.size(); i++) {
            Cliente clienteTemporario = clientes.get(i);
            clienteTemporario.imprimiAtributos();

        }
    }

    public Cliente recuperarUm(int id) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente clienteTemporario = clientes.get(i);
            if (clienteTemporario.getId() == id) {
                return clienteTemporario;
            }
        }

        return null;

    }

    public void excluir(Cliente c) {
        clientes.remove(c);
    }

    public void editar(Cliente c) {
        System.out.println("###  ARÉA DE EDIÇÃO DE INFORMAÇÕES REFERENTE A CLIENTE  ###");
        c.setNome(Entrada.leiaString("Digite o novo nome do Cliente:"));
        c.setCpf(Entrada.leiaString("Digite o novo CPF:"));
        c.setEmail(Entrada.leiaString("Digite o novo endereço de email:"));
        c.setTelefone(Entrada.leiaString("Digite a novo número de telefone:"));

    }

}
