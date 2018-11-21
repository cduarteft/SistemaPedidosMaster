
package br.com.sistemadsdois.managedBean;

import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

@ManagedBean
public class loginBean {
    
    private String username;
     
    private String password;
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
   
    public void login(ActionEvent actionEvent) throws IOException {
    RequestContext context = RequestContext.getCurrentInstance();
    FacesMessage msg = null;
    boolean loggedIn = false;
   if(username != null && username.equals("admin") && password != null && password.equals("admin")) {
            loggedIn = true;
            FacesContext.getCurrentInstance().getExternalContext().redirect("gerenciarUsuario.jsf");
   }
   if(username != null && username.equals("user") && password != null && password.equals("user")) {
            loggedIn = true;
            FacesContext.getCurrentInstance().getExternalContext().redirect("template.jsf");
       
    } else {
      loggedIn = false;
      msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
              "Erro de autenticação!!!", "Usuario ou senha incorretos!");
      FacesContext.getCurrentInstance().addMessage(null, msg);
      context.addCallbackParam("loggedIn", loggedIn);
     
    }
  }
}
