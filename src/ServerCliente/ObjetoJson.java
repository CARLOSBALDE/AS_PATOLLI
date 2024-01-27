/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerCliente;

import java.io.Serializable;

public class ObjetoJson implements Serializable {
    private String nombre;
    private int valor;

    public ObjetoJson(String nombre, int valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "ObjetoJson{" +
                "nombre='" + nombre + '\'' +
                ", valor=" + valor +
                '}';
    }
}

