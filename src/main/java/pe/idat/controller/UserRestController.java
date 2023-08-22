package pe.idat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.idat.entity.UserEntity;
import pe.idat.service.UserService;

@RestController
@RequestMapping("/user")
public class UserRestController 
{
	@Autowired
	private UserService userService;
	
	public UserRestController() {		
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody UserEntity userEntity)
	{
		userService.insert(userEntity);
		return new ResponseEntity<>("¡Usuario registrado!",HttpStatus.CREATED);
	}
}
