package pe.idat.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.idat.entity.MovimientoBancario;

public interface MovimientoBancarioRepository extends JpaRepository<MovimientoBancario,Integer> 
{
	@Query(value="select * from movimientos_bancarios where user_id=?1",nativeQuery=true)
	public abstract Collection<MovimientoBancario> findByUserId(Integer userId);
}
