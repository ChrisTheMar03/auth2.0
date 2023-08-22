package pe.idat.service;

import pe.idat.entity.UserEntity;

public interface UserService 
{
	public abstract void insert(UserEntity userEntity);
	public abstract UserEntity findById(Integer userId);
	public abstract UserEntity findByUsername(String username);
}
