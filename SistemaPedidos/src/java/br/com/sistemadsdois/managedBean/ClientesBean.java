package br.com.sistemadsdois.managedBean;

import br.com.sistemadsdois.dao.ClienteDAO;
import br.com.sistemadsdois.entidade.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class ClientesBean {
        
        private Cliente cliente = new Cliente();
        private List<Cliente> clientes = new ArrayList<>();
        private ClienteDAO clienteDAO = new ClienteDAO();
        
        public void adicionarCliente(){
            clienteDAO.salvar(cliente);
            cliente = new Cliente();     
        }
        
        public void listar(){
            clientes = clienteDAO.buscar();
        }
        
        public void editar(Cliente c){
            cliente = c;
        }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
        
     
        
        
     
}
