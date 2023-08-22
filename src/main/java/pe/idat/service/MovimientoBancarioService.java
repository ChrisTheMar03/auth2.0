package pe.idat.service;

import java.util.Collection;

import pe.idat.entity.MovimientoBancario;

public interface MovimientoBancarioService 
{
	public abstract void insert(MovimientoBancario movimientoBancario);
	public abstract Collection<MovimientoBancario> findAll();
	public abstract Collection<MovimientoBancario> findByUserId(Integer userId);
}
