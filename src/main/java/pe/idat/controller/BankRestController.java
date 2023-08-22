package pe.idat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.idat.entity.MovimientoBancario;
import pe.idat.service.MovimientoBancarioService;

@RestController
@RequestMapping("/bank")
public class BankRestController 
{
	@Autowired
	private MovimientoBancarioService movimientoBancarioService;
	
	public BankRestController() {		
	}
	
	@GetMapping("/movimientos")
	public ResponseEntity<?> listar_GET() {
		return new ResponseEntity<>(movimientoBancarioService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/movimientos/{userId}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer userId) {
		return new ResponseEntity<>(movimientoBancarioService.findByUserId(userId),HttpStatus.OK);
	}
	
	@PostMapping("/operacion_registrar")
	public ResponseEntity<?> registrar_GET(@RequestBody MovimientoBancario movimientoBancario) 
	{
		movimientoBancarioService.insert(movimientoBancario);
		return new ResponseEntity<>("¡Operación registrada!",HttpStatus.CREATED);
	}
}
