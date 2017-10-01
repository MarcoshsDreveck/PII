
package br.com.pii.dao;

import br.com.pii.conexao.Conexao;
import br.com.pii.entity.Fotografos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juliana
 */
public class FotografoDAO {
    public void insertCad(Fotografos fotografos) throws Exception {
        String sql = "insert into fotografos "
                + "(nome, celular, email, senha, nascimento) values (?, ?, ?, ?, ?)";

        java.sql.PreparedStatement sqlPrep
                = Conexao.getConnection().prepareStatement(sql);

        sqlPrep.setString(1, fotografos.getNome());
        sqlPrep.setString(2, fotografos.getCelular());
        sqlPrep.setString(3,  fotografos.getEmail());
        sqlPrep.setString(4,  fotografos.getSenha());
        sqlPrep.setString(5,  fotografos.getNascimento());
       
        
        try{
            System.out.println("Cadastrando");
            sqlPrep.execute();
        }catch(Exception e){
            System.out.println("Erro ao cadastrar dados pessoais: " + e.getMessage());
        }
        
    }

    public void alter(Fotografos fotografos) throws Exception {
        String sql = " update into fotografos "
                + "(nome, celular, email, senha, nascimento) values (?, ?, ?, ?, ?)";
        java.sql.PreparedStatement sqlPrep = Conexao.getConnection().prepareStatement(sql);

        sqlPrep.setString(1, fotografos.getNome());
        sqlPrep.setString(2, fotografos.getCelular());
        sqlPrep.setString(3, fotografos.getEmail());
        sqlPrep.setString(4, fotografos.getSenha());
        sqlPrep.setString(5, fotografos.getNascimento());        
        sqlPrep.execute();
    }

    public void deleteById(int id) throws Exception {
        String sql = "delete from fotografos where id = " + id;

        java.sql.PreparedStatement sqlPrep
                = Conexao.getConnection().prepareStatement(sql);

        sqlPrep.execute();
    }

    public List<Fotografos> getList() throws Exception {
        String sql = "select * from fotografos";

        java.sql.PreparedStatement sqlPrep
                = Conexao.getConnection().prepareStatement(sql);

        ResultSet rs = sqlPrep.executeQuery();

        List<Fotografos> list = new ArrayList<Fotografos>();

        rs.first();

        if (rs.getRow() > 0) { //Tabela está zerada
            do {
                list.add(new Fotografos(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("celular"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("nascimento")
                        
                        )
                );
            } while (rs.next());
        }
        return list;
    }

}

