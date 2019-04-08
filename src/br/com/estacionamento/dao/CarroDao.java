package br.com.estacionamento.dao;

import br.com.estacionamento.interfaces.DaoI;
import br.com.estacionamento.model.Carro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alunos
 */
public class CarroDao extends Dao implements DaoI<Carro> {

    public CarroDao() {
        //Contrutor da super classe Dao. Faz a conexão.
        super();
    }

    @Override
    public List<Carro> listar() {
        try {
            PreparedStatement stmt;
            stmt = conexao.prepareStatement("SELECT "
                    + "id, placa, cor , modelo, marca FROM carro ORDER BY id DESC");
            ResultSet result = stmt.executeQuery();
            List<Carro> lista = new ArrayList<>();
            while (result.next()) {
                Carro c = new Carro();
                c.setId(result.getInt("id"));
                c.setPlaca(result.getString("placa"));
                c.setCor(result.getString("cor"));
                c.setModelo(result.getString("modelo"));
                c.setMarca(result.getString("marca"));
                lista.add(c);
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
    public int cadastrar(Carro obj) {
        try {
            PreparedStatement stmt;
            stmt = conexao.prepareStatement(
                    "INSERT INTO carro(placa, cor, modelo , marca)"
                    + " VALUES(?, ?, ? , ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, obj.getPlaca());
            stmt.setString(2, obj.getCor());
            stmt.setString(3, obj.getModelo());
            stmt.setString(4, obj.getMarca());
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
    public boolean alterar(Carro obj) {
        try {
            PreparedStatement stmt = conexao.prepareStatement("UPDATE CARRO "
                    + "SET PLACA = ? , COR = ? , MODELO = ? , MARCA = ? WHERE ID  =?");
            stmt.setString(1, obj.getPlaca());
            stmt.setString(2, obj.getCor());
            stmt.setString(3, obj.getModelo());
            stmt.setString(4, obj.getMarca());
            stmt.setInt(5, obj.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean deletarPorId(int id) {
        try {
            PreparedStatement stmt = conexao.prepareStatement("DELETE FROM CARRO WHERE ID = ?");
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public Carro lerPorId(int id) {
        try {
            PreparedStatement stmt = conexao.prepareStatement(""
                    + "SELECT id, placa , cor , modelo , marca FROM carro "
                    + " WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                Carro c = new Carro();
                c.setId(res.getInt("id"));
                c.setPlaca(res.getString("placa"));
                c.setCor(res.getString("cor"));
                c.setModelo(res.getString("modelo"));
                c.setMarca(res.getString("marca"));
                return c;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }

    @Override
    public List<Carro> pesquisar(String termo) {
        try {
           PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM carro WHERE placa LIKE ? OR cor LIKE ? "
                   + "OR modelo LIKE ? OR marca LIKE ?");
            stmt.setString(1, "%"+termo+"%");
            stmt.setString(2, "%"+termo+"%");
            stmt.setString(3, "%"+termo+"%");
            stmt.setString(4, "%"+termo+"%");
            ResultSet res = stmt.executeQuery();
            List<Carro> lista = new ArrayList<>();
            while (res.next()) {
                Carro c = new Carro();
                c.setId(res.getInt("id"));
                c.setPlaca(res.getString("placa"));
                c.setCor(res.getString("cor"));
                c.setModelo(res.getString("modelo"));
                c.setMarca(res.getString("marca"));
                lista.add(c);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }

    }

}
