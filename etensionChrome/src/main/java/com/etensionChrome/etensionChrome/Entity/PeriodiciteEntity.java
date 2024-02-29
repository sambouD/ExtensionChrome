package com.etensionChrome.etensionChrome.Entity;


import jakarta.persistence.*;

@Entity
public class PeriodiciteEntity {

    @Id
    @GeneratedValue
    private Long id;


    @Enumerated(EnumType.STRING)
    private TypePeriode typePeriodicite;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypePeriode getTypePeriodicite() {
        return typePeriodicite;
    }

    public void setTypePeriodicite(TypePeriode typePeriodicite) {
        this.typePeriodicite = typePeriodicite;
    }
}
