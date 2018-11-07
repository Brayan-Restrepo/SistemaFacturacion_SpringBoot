package com.udemy.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.udemy.models.entity.Producto;

public interface IProductoDao extends CrudRepository<Producto, Long>{

	@Query("select p from Producto p where p.nombre like %?1%")
	public List<Producto> findByNombre(String term);
	
	// es lo mismo que el anterior metodo pero es automatico ver documentacion es interesante video 79 
	public List<Producto> findByNombreLikeIgnoreCase(String term);
}
