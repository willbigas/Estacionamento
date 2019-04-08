/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estacionamento.interfaces;

import java.util.List;

/**
 *
 * @param <T>
 */
public interface DaoI<T> {

    public List<T> listar();

    public int cadastrar(T obj);

    public boolean alterar(T obj);

    public boolean deletarPorId(int id);

    public T lerPorId(int id);

    public List<T> pesquisar(String termo);
}
