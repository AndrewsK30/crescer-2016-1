/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.crescer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andrews.silva
 */
public abstract class  PessoaDown implements IPessoa{
    Connection connection = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    
    
    @Override
    public void insert(Pessoa pessoa) {
        final String insert = "INSERT INTO PESSOA2("
                    + "IDPESSOA, NMPESSOA ) "
                    + "VALUES (?, ?)";
           try {
            connection = ConnectionUtils.initConnection();
            try{
                 preparedStatement = connection.prepareStatement(insert);
                 preparedStatement.setInt(1,lastId());
                 preparedStatement.setString(2,pessoa.getNome());
                 preparedStatement.executeUpdate();
            }catch(SQLException e){
                System.err.format("SQLException: %s", e);
            }
        }catch(SQLException e){
            System.err.format("SQLException: %s", e);
        }     
    }
    
    private int lastId() throws SQLException{
        final String query = "SELECT IDPessoa FROM PESSOA2 WHERE numrows = 1;";
        statement = connection.createStatement();
        final ResultSet resultSet = statement.executeQuery(query);
        return resultSet.getRow();       
    }
    

    @Override
    public void update(Pessoa pessoa) {
        final String update = "UPDATE PESSOA2"
                    + "NMPESSOA = ?"
                    + "WHERE IDPESSOA = ?";
           try {
            connection = ConnectionUtils.initConnection();
            try{
                 preparedStatement = connection.prepareStatement(update);
                 preparedStatement.setString(1,pessoa.getNome());
                 preparedStatement.setInt(2,pessoa.getId());                 
                 preparedStatement.executeUpdate();
            }catch(SQLException e){
                System.err.format("SQLException: %s", e);
            }
        }catch(SQLException e){
            System.err.format("SQLException: %s", e);
        }  
    }

    @Override
    public void delete(Pessoa pessoa) {
        final String update = "DELETE FROM PESSOA2"
                    + "WHERE IDPESSOA = ?";
           try {
            connection = ConnectionUtils.initConnection();
            try{
                 preparedStatement = connection.prepareStatement(update);
                 preparedStatement.setInt(1,pessoa.getId());                 
                 preparedStatement.executeUpdate();
            }catch(SQLException e){
                System.err.format("SQLException: %s", e);
            }
        }catch(SQLException e){
            System.err.format("SQLException: %s", e);
        }  
    }

    public List<Pessoa> listAll() {
            final String query = "SELECT * FROM Pessoa2";
            List<Pessoa> listaPessoa = new ArrayList<Pessoa>();
       try (final Connection connection = ConnectionUtils.initConnection()) {
        try (final Statement statement = connection.createStatement()) {
           try (final ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    listaPessoa.add(new Pessoa(resultSet.getString(2),resultSet.getInt(1)));                   
                }           
            } catch (final SQLException e) {
              System.err.format("SQLException: %s", e);
            }

        } catch (final SQLException e) {
          System.err.format("SQLException: %s", e);
        }
       } catch (SQLException e) {
           System.err.format("SQLException: %s", e);
       }finally{
           return listaPessoa;
       }
    }

    public List<Pessoa> findNome(String nome) {
        List<Pessoa> listaPessoa = new ArrayList<Pessoa>();
        final String query = "SELECT * FROM PESSOA2 WHERE NMPessoa = ? ;";
        try (final Connection connection = ConnectionUtils.initConnection()) {
            try (final Statement statement = connection.createStatement()) {
               try (final ResultSet resultSet = statement.executeQuery(query)) {
                    while (resultSet.next()) {
                        listaPessoa.add(new Pessoa(resultSet.getString(2),resultSet.getInt(1)));                   
                    }           
                } catch (final SQLException e) {
                  System.err.format("SQLException: %s", e);
                }

            } catch (final SQLException e) {
              System.err.format("SQLException: %s", e);
            }
           } catch (SQLException e) {
               System.err.format("SQLException: %s", e);
           }finally{
               return listaPessoa;
           }

    }
    
}
