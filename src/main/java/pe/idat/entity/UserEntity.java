package pe.idat.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UserEntity implements Serializable 
{
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;	
	
	@Column(unique=true,nullable=false)
	private String username;
	
	@Column(nullable=false)
	private String password;
	
	@Column
	private String nombre;
	
	@Column
	private String celular;
	
	@OneToMany(mappedBy="userEntity")
	private Collection<MovimientoBancario> itemsMovimientoBancario=new ArrayList<>();
	
	public UserEntity() {		
	}

	public UserEntity(Integer userId, String username, String password, String nombre, String celular) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.nombre = nombre;
		this.celular = celular;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Collection<MovimientoBancario> getItemsMovimientoBancario() {
		return itemsMovimientoBancario;
	}

	public void setItemsMovimientoBancario(Collection<MovimientoBancario> itemsMovimientoBancario) {
		this.itemsMovimientoBancario = itemsMovimientoBancario;
	}
}
