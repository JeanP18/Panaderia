package com.grupo3.sistemacomprapanaderia.entity;


import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="detallecompras")
@EntityListeners(AuditingEntityListener.class)
public class DetalleCompra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	

    @Column(name = "cantidadComprada", nullable = false)
    private int cantidadComprada;
    @Column(name = "precioUnitario", nullable = false)
    private float precioUnitario;
    @Column(name = "subTotal", nullable = false)
    private float subTotal;
    @Column(name="created_at",nullable = false,updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;
	@Column(name="updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;
	
	@Column(name="activo")
	private boolean activo;
	
	@ManyToOne()
	@JoinColumn(name = "compra_id")
	private Compra compra;
	
	@ManyToOne()
	@JoinColumn(name = "producto_id")
	private Producto producto;
	


}
