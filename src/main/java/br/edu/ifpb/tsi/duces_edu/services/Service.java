package br.edu.ifpb.tsi.duces_edu.services;

import java.util.List;

public interface Service<T,UUID> {
    
    public List<T> findAll();

    public T findById(UUID id);

    public T save(T t);
}
