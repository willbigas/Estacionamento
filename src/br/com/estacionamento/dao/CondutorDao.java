package br.com.estacionamento.dao;

import br.com.estacionamento.interfaces.DaoI;
import br.com.estacionamento.model.Condutor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alunos
 */
public class CondutorDao extends Dao implements DaoI<Condutor> {

    public CondutorDao() {
        //Contrutor da super classe Dao. Faz a conexão.
        super();
    }

    @Override
    public List<Condutor> listar() {
        try {
            PreparedStatement stmt;
            stmt = conexao.prepareStatement("SELECT "
                    + "id, nome FROM condutor ORDER BY id DESC");
            ResultSet result = stmt.executeQuery();
            List<Condutor> lista = new ArrayList<>();
            while (result.next()) {
                Condutor co = new Condutor();
                co.setId(result.getInt("id"));
                co.setNome(result.getString("nome"));
                lista.add(co);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    /**
     * Método para cadastrar um produto no banco de dados
     * <br>Retorna id do produto cadastrado
     * <br><b>Retorna 0 (zero) se houver erro</b>
     *
     * @param obj
     * @return int
     */
    @Override
    public int cadastrar(Condutor obj) {
        try {
            PreparedStatement stmt;
            stmt = conexao.prepareStatement(
                    "INSERT INTO condutor(nome)"
                    + " VALUES(?)", PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, obj.getNome());
            ResultSet res;
            if (stmt.executeUpdate() > 0) {
                res = stmt.getGeneratedKeys();
                res.next();
                return res.getInt(1);
            } else {
                return 0;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }

    @Override
    public boolean alterar(Condutor obj) {
        try {
            PreparedStatement stmt = conexao.prepareStatement("UPDATE CONDUTOR "
                    + "SET NOME = ?  WHERE ID  =?");
            stmt.setString(1, obj.getNome());
            stmt.setInt(2, obj.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean deletarPorId(int id) {
        try {
            PreparedStatement stmt = conexao.prepareStatement("DELETE FROM CONDUTOR WHERE ID = ?");
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public Condutor lerPorId(int id) {
        try {
            PreparedStatement stmt = conexao.prepareStatement(""
                    + "SELECT id, nome FROM condutor "
                    + " WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                Condutor co = new Condutor();
                co.setId(res.getInt("id"));
                co.setNome(res.getString("nome"));
                return co;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }

    @Override
    public List<Condutor> pesquisar(String termo) {
        try {
           PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM condutor WHERE nome LIKE ?");
            stmt.setString(1, "%"+termo+"%");
            ResultSet res = stmt.executeQuery();
            List<Condutor> lista = new ArrayList<>();
            while (res.next()) {
                Condutor co = new Condutor();
                co.setId(res.getInt("id"));
                co.setNome(res.getString("nome"));
                lista.add(co);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }

    }

}
