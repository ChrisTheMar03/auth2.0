package pe.idat.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="movimientos_bancarios")
public class MovimientoBancario 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer movimientoBancarioId;
	
	@Column
	private String operacion;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH24:mm:ss",iso=ISO.DATE_TIME)
	private LocalDateTime fechaHora;
	
	@Column
	private Double monto;
	
	@ManyToOne
	@JoinColumn(name="user_id",nullable=false)
	private UserEntity userEntity;
	
	public MovimientoBancario() {		
	}

	public MovimientoBancario(Integer movimientoBancarioId, String operacion, LocalDateTime fechaHora, Double monto) {
		this.movimientoBancarioId = movimientoBancarioId;
		this.operacion = operacion;
		this.fechaHora = fechaHora;
		this.monto = monto;
	}
	
	public void prePersist() {
		fechaHora=LocalDateTime.now();
	}

	public Integer getMovimientoBancarioId() {
		return movimientoBancarioId;
	}

	public void setMovimientoBancarioId(Integer movimientoBancarioId) {
		this.movimientoBancarioId = movimientoBancarioId;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
}
