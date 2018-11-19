
package br.com.sistemadsdois.dao;

import br.com.sistemadsdois.util.excecao.ErroSistema;
import java.util.List;


public interface CrudDAO <E>{ //E - Representando a entidade
    
    public void salvar(E entidade)throws ErroSistema;
    public void deletar(E entidade)throws ErroSistema;
    public List<E> buscar()throws ErroSistema;
    
        
        
    
}
