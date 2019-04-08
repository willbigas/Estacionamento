package br.com.estacionamento.dao;

import br.com.estacionamento.factory.Conexao;
import java.sql.Connection;

public class Dao {

    protected Connection conexao;

    public Dao() {
        conexao = Conexao.getConexao();
    }

}
