package transparencias.asociaciones.onetomanyord_xml;

public class Cargo {

	private int id;
	private String nombre;
	private long sueldo;
	
	
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
	public long getSueldo() {
		return sueldo;
	}
	public void setSueldo(long sueldo) {
		this.sueldo = sueldo;
	}

	@Override
	public String toString() {
		return "Cargo [id=" + id + ", nombre=" + nombre + ", sueldo=" + sueldo
				+ "]";
	}
	
	

}


