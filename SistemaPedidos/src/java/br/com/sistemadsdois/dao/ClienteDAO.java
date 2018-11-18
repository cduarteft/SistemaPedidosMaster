
package br.com.sistemadsdois.dao;

import br.com.sistemadsdois.entidade.Cliente;
import br.com.sistemadsdois.util.FabricaConexoes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClienteDAO {
    
    public void salvar(Cliente cliente){
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
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    public List<Cliente> buscar(){
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
            return clientes;
        }catch (SQLException ex){
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
     }
  }
    

