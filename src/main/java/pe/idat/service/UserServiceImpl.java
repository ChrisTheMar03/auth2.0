package pe.idat.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.idat.entity.UserEntity;
import pe.idat.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService, UserDetailsService
{
	@Autowired
	private UserRepository repository;

	@Override
	@Transactional
	public void insert(UserEntity userEntity) 
	{
		BCryptPasswordEncoder bCrypt=new BCryptPasswordEncoder();
		String passwordBCrypt=bCrypt.encode(userEntity.getPassword());
		
		userEntity.setPassword(passwordBCrypt);
		
		repository.save(userEntity);
	}

	@Override
	@Transactional(readOnly=true)
	public UserEntity findById(Integer userId) {
		return repository.findById(userId).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public UserEntity findByUsername(String username) {
		return repository.findByUsername(username);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		UserEntity userDb=this.findByUsername(username);
		
		if(userDb!=null)
		{
			Collection<GrantedAuthority> authorities=new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			
			User user=new User(userDb.getUsername(),userDb.getPassword(),authorities);
			return user;
		}
		
		throw new UsernameNotFoundException("¡Error, usuario no existe!");
	}
}
