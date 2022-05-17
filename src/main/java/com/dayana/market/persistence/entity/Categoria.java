package com.dayana.market.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id @Getter @Setter @Column(name = "id_categoria")
    private Integer idCategoria;

    @Getter @Setter
    private String descripcion;

    @Getter @Setter
    private Integer estado;

    @Getter @Setter @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;


}
