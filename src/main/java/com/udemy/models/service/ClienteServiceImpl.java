package com.udemy.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.udemy.models.dao.IClienteDao;
import com.udemy.models.dao.IProductoDao;
import com.udemy.models.entity.Cliente;
import com.udemy.models.entity.Producto;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteDao iClienteDao;
	
	@Autowired
	private IProductoDao iProductoDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return (List<Cliente>) this.iClienteDao.findAll();
	}

	@Override
	public Page<Cliente> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return  this.iClienteDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Cliente findOne(Long id) {
		// TODO Auto-generated method stub
		return this.iClienteDao.findOne(id);
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		// TODO Auto-generated method stub
		this.iClienteDao.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		this.iClienteDao.delete(id);
	}

	@Override
	public List<Producto> findByNombre(String term) {
		// TODO Auto-generated method stub
		return this.iProductoDao.findByNombre(term);
	}

}
