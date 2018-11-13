package com.ucbcba.logindemo.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subcategoria")
public class Subcategoria {
    private Integer id;

    @Column(unique = true)
    private String nombre;
    private String descripcion;
    private List<Post> posts;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subcategoria", orphanRemoval = true)
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
