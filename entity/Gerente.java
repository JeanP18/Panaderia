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
@Table(name = "gerentes")
@EntityListeners(AuditingEntityListener.class)

public class Gerente {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name= "nombre", nullable = false, length = 50 , unique = false)
	private String nombre;
	@Column(name= "cargo", nullable = false, length = 50 , unique = false)
	private String cargo;
	@Column(name= "ruc", nullable = false, length = 11 , unique = false)
	private String ruc;
	@Column(name= "direccion", nullable = false, length = 100 , unique = false)
	private String direccion;
	@Column (name ="activo")
	private boolean activo;
	@Column(name = "created_at", nullable= false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;
	@Column(name = "updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;



}
