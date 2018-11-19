
package br.com.sistemadsdois.managedBean;

import br.com.sistemadsdois.dao.CrudDAO;
import br.com.sistemadsdois.util.excecao.ErroSistema;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


public abstract class CrudBean<E, D extends CrudDAO>{
   
    private String estadoTela = "buscar";//inserir,editar,buscar
    private E entidade;
    private List<E> entidades;
    
    public void novo(){  
        entidade = criarNovaEntidade();
        mudarParaInseri();
    }
    public void salvar(){  
        try {
            getDAO().salvar(entidade);
            entidade = criarNovaEntidade();
            adicionarMensagem("Salvo com sucesso!", FacesMessage.SEVERITY_INFO);
            mudarParaBusca();
        } catch (ErroSistema ex) {
           Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
           adicionarMensagem(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }
    public void editar(E entidade){ 
        this.entidade = entidade;
        mudarParaEdita();
    }
    public void deletar(E entidade){    
        try {
            getDAO().deletar(entidade);
            entidades.remove(entidade);
            adicionarMensagem("Deletado com sucesso!", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagem(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }
    public void buscar(){ 
        if(!isBusca()){
            mudarParaBusca();
            return;
        }
        try {
            entidades = getDAO().buscar();
            if(entidades == null || entidades.size() < 1){
              adicionarMensagem("Não temos nada cadastrado!", FacesMessage.SEVERITY_WARN);
            }
        } catch (ErroSistema ex) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagem(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }
    public void adicionarMensagem(String menasgem, FacesMessage.Severity tipoErro){
        
        FacesMessage fm = new FacesMessage(tipoErro, menasgem, null);
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }
    
    // getters e setters

    public E getEntidade() {
        return entidade;
    }

    public void setEntidade(E entidade) {
        this.entidade = entidade;
    }

    public List<E> getEntidades() {
        return entidades;
    }

    public void setEntidades(List<E> entidades) {
        this.entidades = entidades;
    }
    
    
    
    //Responsavel por criar métodos nas classes bean
    public abstract D getDAO();
    public abstract E criarNovaEntidade();
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public boolean isInseri(){
        return "inserir".equals(estadoTela);
    }
    public boolean isEdita(){
        return "editar".equals(estadoTela);
    }
    public boolean isBusca(){
        return "buscar".equals(estadoTela);
    }
    
    public void mudarParaInseri(){
        estadoTela = "inserir";
    }
    public void mudarParaEdita(){
        estadoTela = "editar";
    }
    public void mudarParaBusca(){
        estadoTela = "buscar";
    }
    
    
}
