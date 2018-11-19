
package br.com.sistemadsdois.dao;

import br.com.sistemadsdois.entidade.Cliente;
import br.com.sistemadsdois.util.FabricaConexoes;
import br.com.sistemadsdois.util.excecao.ErroSistema;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ClienteDAO implements CrudDAO<Cliente>{
    
    @Override
    public void salvar(Cliente cliente) throws ErroSistema{
        try {
            Connection conexao = FabricaConexoes.getConexao();
            PreparedStatement ps;
            if(cliente.getId() == null){
             ps = conexao.prepareStatement("INSERT INTO `cliente` (`nome`,`sobrenome`,`email`,`endereco`,`telefone`,`dataNasc`)  VALUES(?,?,?,?,?,?)");      
            }else {
                ps = conexao.prepareStatement("update cliente set nome=?, sobrenome=?, email=?, endereco=?, telefone=?, dataNasc=? where id=?");
                ps.setInt(7, cliente.getId());
            } 
                ps.setString(1, cliente.getNome());
                ps.setString(2, cliente.getSobrenome());
                ps.setString(3, cliente.getEmail());
                ps.setString(4, cliente.getEndereco());
                ps.setString(5, cliente.getTelefone());
                ps.setString(6, cliente.getDataNasc());
            ps.execute();
            FabricaConexoes.fecharConexao();
        } catch (SQLException ex) {
          throw new ErroSistema("Erro ao tentar Salvar!", ex);
        }
    } 
    @Override
    public void deletar(Cliente cliente) throws ErroSistema{
     try{
        Connection conexao = FabricaConexoes.getConexao();
        PreparedStatement ps = conexao.prepareStatement("delete from cliente where id= ?");
        ps.setInt(1, cliente.getId());
        ps.execute();
    } catch (SQLException ex){
      throw new ErroSistema("Erro ao deletar o Cliente!", ex);
    }
}

    @Override
    public List<Cliente> buscar() throws ErroSistema{
    try {
        Connection conexao = FabricaConexoes.getConexao();
        PreparedStatement ps = conexao.prepareStatement("select * from cliente");
        ResultSet resultSet = ps.executeQuery();
        List<Cliente> clientes = new ArrayList<>();
            
        while(resultSet.next()){
            Cliente cliente = new Cliente();
            cliente.setId(resultSet.getInt("idCliente"));
            cliente.setNome(resultSet.getString("nome"));
            cliente.setSobrenome(resultSet.getString("sobrenome"));
            cliente.setEmail(resultSet.getString("email"));
            cliente.setEndereco(resultSet.getString("endereco"));
            cliente.setTelefone(resultSet.getString("telefone"));
            cliente.setDataNasc(resultSet.getString("dataNasc"));
            clientes.add(cliente);
        }
            FabricaConexoes.fecharConexao();
            return clientes;
        }catch (SQLException ex){
            throw new ErroSistema("Erro ao buscar os Clientes!", ex);
        }
     }
  }
    

