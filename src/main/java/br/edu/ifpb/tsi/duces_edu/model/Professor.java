package br.edu.ifpb.tsi.duces_edu.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Professor extends Usuario{

    private Boolean IsCoordenador = false;
    
}
