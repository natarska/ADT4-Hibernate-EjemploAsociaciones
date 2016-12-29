package transparencias.asociaciones.onetomanyord_xml;

import java.util.Date;
import java.util.List;



/**
 * Clase simple que representa un Empleado
 * 
 *
 */

public class Empleado {

	private int id;
	private String nombre;
	private String rol;
	private Date fecha;
	
			
	private List<Cargo> cargos;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public Date getFecha() {
		return fecha;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}
	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", rol=" + rol
				+ ", fecha=" + fecha + ", cargos=" + cargos + "]";
	}
	
	
	
	

}
