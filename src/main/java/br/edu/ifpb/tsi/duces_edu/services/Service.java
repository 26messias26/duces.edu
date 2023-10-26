package br.edu.ifpb.tsi.duces_edu.services;

import java.util.List;

public interface Service<T,Integer> {
    
    public List<T> findAll();

    public T findById(Integer id);

    public T save(T t);
}
