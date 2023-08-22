package pe.idat.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.idat.entity.MovimientoBancario;
import pe.idat.repository.MovimientoBancarioRepository;

@Service
public class MovimientoBancarioServiceImpl implements MovimientoBancarioService
{
	@Autowired
	private MovimientoBancarioRepository repository;
	
	@Override
	@Transactional
	public void insert(MovimientoBancario movimientoBancario) {
		repository.save(movimientoBancario);		
	}
	
	@Override
	@Transactional(readOnly=true)
	public Collection<MovimientoBancario> findAll() {
		return repository.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Collection<MovimientoBancario> findByUserId(Integer userId) {
		return repository.findByUserId(userId);
	}
}
