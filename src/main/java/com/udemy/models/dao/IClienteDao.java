package com.udemy.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.udemy.models.entity.Cliente;

public interface IClienteDao extends PagingAndSortingRepository<Cliente, Long>{

	
}
