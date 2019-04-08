package br.com.estacionamento.dao;

import br.com.estacionamento.interfaces.DaoI;
import br.com.estacionamento.model.TipoCliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alunos
 */
public class TipoClienteDao extends Dao implements DaoI<TipoCliente> {

    public TipoClienteDao() {
        //Contrutor da super classe Dao. Faz a conexão.
        super();
    }

    @Override
    public List<TipoCliente> listar() {
        try {
            PreparedStatement stmt;
            stmt = conexao.prepareStatement("SELECT "
                    + "id, idTipo FROM tipoCliente ORDER BY id DESC");
            ResultSet result = stmt.executeQuery();
            List<TipoCliente> lista = new ArrayList<>();
            while (result.next()) {
                TipoCliente tc = new TipoCliente();
                tc.setId(result.getInt("id"));
                tc.setIdTipo(result.getInt("idTipo"));
                lista.add(tc);
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
    public int cadastrar(TipoCliente obj) {
        try {
            PreparedStatement stmt;
            stmt = conexao.prepareStatement(
                    "INSERT INTO tipoCliente(idTipo)"
                    + " VALUES(?)", PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, obj.getIdTipo());
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
    public boolean alterar(TipoCliente obj) {
        try {
            PreparedStatement stmt = conexao.prepareStatement("UPDATE tipoCliente "
                    + "SET idTipo = ?  WHERE ID  =?");
            stmt.setInt(1, obj.getIdTipo());
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
            PreparedStatement stmt = conexao.prepareStatement("DELETE FROM tipoCliente WHERE ID = ?");
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public TipoCliente lerPorId(int id) {
        try {
            PreparedStatement stmt = conexao.prepareStatement(""
                    + "SELECT id, idTipo FROM tipoCliente "
                    + " WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                TipoCliente tc = new TipoCliente();
                tc.setId(res.getInt("id"));
                tc.setIdTipo(res.getInt("idTipo"));
                return tc;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }

    /**
     * @deprecated  -- Não é usado para este objeto.
     * @param termo
     * @return 
     */
    @Override
    public List<TipoCliente> pesquisar(String termo) {
        return null;

    }

}
