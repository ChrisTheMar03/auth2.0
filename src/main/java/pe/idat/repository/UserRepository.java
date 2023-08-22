package pe.idat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.idat.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Integer> 
{
	public abstract UserEntity findByUsername(String username);
}
