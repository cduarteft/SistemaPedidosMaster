package br.com.sistemadsdois.managedBean;

import br.com.sistemadsdois.dao.ClienteDAO;
import br.com.sistemadsdois.entidade.Cliente;
import br.com.sistemadsdois.util.excecao.ErroSistema;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@SessionScoped
@ManagedBean
public class ClientesBean extends CrudBean<Cliente, ClienteDAO>{
    
    private ClienteDAO clienteDAO;

    @Override
    public ClienteDAO getDAO() {
       if(clienteDAO == null){
           clienteDAO = new ClienteDAO();
       }
       return clienteDAO;
    }

    @Override
    public Cliente criarNovaEntidade() {
        return new Cliente();
    }
    
    
      
    
}
