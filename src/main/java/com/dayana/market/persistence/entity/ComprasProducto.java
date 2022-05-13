package com.dayana.market.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "compras_productos")
public class ComprasProducto {

    @Id
    @Column(name = "id_compra")
    private Integer id_compra;

    @Column(name = "id_producto")
    private Integer id_producto;

    private Integer cantidad;

    private float  total;

    private Integer estado;



}
