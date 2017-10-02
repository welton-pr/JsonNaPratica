/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.json.control;


import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import br.com.json.model.Cliente;
import br.com.json.model.Dependentes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 *
 * @author Laryssa
 */
public class Json {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List<Cliente> listaClientes = new ArrayList<>();
        
        Cliente c = new Cliente();
        c.setCodigo(1);
        c.setNome("Welton");
        c.setEmail("welton@casaoi.com.br");
        c.setNascimento(new Timestamp(System.currentTimeMillis()));
        Dependentes d = new Dependentes();
        d.setCodigo(1);
        d.setNome("Jose Junior");
        c.setDependentes(d);
        listaClientes.add(c);
        
        Cliente c2 = new Cliente();
        c2.setCodigo(1);
        c2.setNome("Welton");
        c2.setEmail("welton@casaoi.com.br");
        c2.setNascimento(new Timestamp(System.currentTimeMillis()));
        listaClientes.add(c2);
        
        Type type = new TypeToken<List<Cliente>>(){}.getType();
        
        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy HH:mm").create();
        String json = gson.toJson(listaClientes, type);
        System.out.println(json);
        List<Cliente> listaRetornoCliente = gson.fromJson(json, type);
        
        for(Cliente clienteRetorno: listaRetornoCliente){
            System.out.println(clienteRetorno.getCodigo());
            System.out.println(clienteRetorno.getNome());
            System.out.println(clienteRetorno.getEmail());
            System.out.println(clienteRetorno.getNascimento());
            System.out.println(clienteRetorno.getDependentes() != null?clienteRetorno.getDependentes().getCodigo():"");
            System.out.println(clienteRetorno.getDependentes() != null?clienteRetorno.getDependentes().getNome():"");

        }
        
           
    }
    
}
