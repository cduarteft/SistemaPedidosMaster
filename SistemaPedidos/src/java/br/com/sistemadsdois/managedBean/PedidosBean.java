
package br.com.sistemadsdois.managedBean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import br.com.sistemadsdois.entidade.Pedidos;
import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

@ManagedBean
public class PedidosBean {
  
       private Pedidos pedido = new Pedidos();
       private List<Pedidos> pedidos =  new ArrayList<>();
       private String[] SelectedPedidos;
       private List<SelectItem> ped;
       
       public void adicionarPedido(){
           pedidos.add(pedido);
           pedido = new Pedidos(); 
       }
       @PostConstruct
       public void init(){
    ped = new ArrayList<SelectItem>();
        SelectItemGroup tiposelecao = new SelectItemGroup("Tipo:");
        tiposelecao.setSelectItems(new SelectItem[] {
            new SelectItem("Pizza", "Pizza"),
            new SelectItem("Kalzone", "Kalzone"),
            new SelectItem("Pastel", "Pastel")
        });
         
        SelectItemGroup acomp = new SelectItemGroup("Acompanhamento:");
        acomp.setSelectItems(new SelectItem[]{
            new SelectItem("Refrigerante", "Refrigerante"),
            new SelectItem("Suco", "Suco"),
            new SelectItem("Milkshake", "Milkshake")
        });
 
        ped.add(tiposelecao);
        ped.add(acomp);
      }

    public String[] getSelectedPedidos() {
        return SelectedPedidos;
    }

    public void setSelectedPedidos(String[] SelectedPedidos) {
        this.SelectedPedidos = SelectedPedidos;
    }

    public List<SelectItem> getPed() {
        return ped;
    }

    public void setPed(List<SelectItem> ped) {
        this.ped = ped;
    }
       
    public Pedidos getPedido() {
        return pedido;
    }

    public void setPedido(Pedidos pedido) {
        this.pedido = pedido;
    }

    public List<Pedidos> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedidos> pedidos) {
        this.pedidos = pedidos;
    }
}
