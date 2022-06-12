/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alkemy.disney.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "personaje")
public class PersonajeEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;

    private String nombre;

    private Integer edad;

    private float peso;

    private String historia;

    @ManyToMany(mappedBy = "personajes", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<PeliculaEntity> peliculas = new HashSet<>();

    public void addPais(PeliculaEntity pelicula) {
        this.peliculas.add(pelicula);
    }

    public void removePais(PeliculaEntity pelicula) {
        this.peliculas.remove(pelicula);
    }

}
