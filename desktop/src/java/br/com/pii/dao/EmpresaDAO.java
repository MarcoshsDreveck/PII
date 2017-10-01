
package br.com.pii.dao;

import br.com.pii.conexao.Conexao;
import br.com.pii.entity.Empresas;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juliana
 */
public class EmpresaDAO {
    public void insertCad(Empresas empresas) throws Exception {
        String sql = "insert into empresas "
                + "(cnpj, endereco, telefone, email, senha, nome, redesocial, site, razaosocial) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        java.sql.PreparedStatement sqlPrep
                = Conexao.getConnection().prepareStatement(sql);

        sqlPrep.setString(1, empresas.getCnpj());
        sqlPrep.setString(2, empresas.getEndereco());
        sqlPrep.setString(3, empresas.getTelefone());
        sqlPrep.setString(4, empresas.getEmail());
        sqlPrep.setString(5, empresas.getSenha());
        sqlPrep.setString(6, empresas.getNome());
        sqlPrep.setString(7, empresas.getRedesocial());
        sqlPrep.setString(8, empresas.getSite());
        sqlPrep.setString(9, empresas.getRazaosocial());
        
        try{
            System.out.println("Cadastrando");
            sqlPrep.execute();
        }catch(Exception e){
            System.out.println("Erro ao cadastrar empresa: " + e.getMessage());
        }
        
    }

    public void alter(Empresas empresas) throws Exception {
        String sql = " update into empresas "
                + "(cnpj, endereco, telefone, email, senha, nome, redesocial, site, razaosocial ) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        java.sql.PreparedStatement sqlPrep = Conexao.getConnection().prepareStatement(sql);

        sqlPrep.setString(1, empresas.getCnpj());
        sqlPrep.setString(2, empresas.getEndereco());
        sqlPrep.setString(3, empresas.getTelefone());
        sqlPrep.setString(4, empresas.getEmail());
        sqlPrep.setString(5, empresas.getSenha());
        sqlPrep.setString(6, empresas.getNome());
        sqlPrep.setString(7, empresas.getRedesocial());
        sqlPrep.setString(8, empresas.getSite());
        sqlPrep.setString(9, empresas.getRazaosocial());
        sqlPrep.execute();
    }

    public void deleteById(int id) throws Exception {
        String sql = "delete from empresas where id = " + id;

        java.sql.PreparedStatement sqlPrep
                = Conexao.getConnection().prepareStatement(sql);

        sqlPrep.execute();
    }

    public List<Empresas> getList() throws Exception {
        String sql = "select * from empresas";

        java.sql.PreparedStatement sqlPrep
                = Conexao.getConnection().prepareStatement(sql);

        ResultSet rs = sqlPrep.executeQuery();

        List<Empresas> list = new ArrayList<Empresas>();

        rs.first();

        if (rs.getRow() > 0) { //Tabela está zerada
            do {
                list.add(new Empresas(
                        rs.getInt("id"),
                        rs.getString("cnpj"),
                        rs.getString("endereco"),
                        rs.getString("telefone"),
                        rs.getString("redesocial"),
                        rs.getString("site"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("razaosocial")
                        
                        )
                );
            } while (rs.next());
        }
        return list;
    }

}

