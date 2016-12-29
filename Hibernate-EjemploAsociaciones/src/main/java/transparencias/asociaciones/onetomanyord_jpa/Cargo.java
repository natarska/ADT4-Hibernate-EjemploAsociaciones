package transparencias.asociaciones.onetomanyord_jpa;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="Cargo",uniqueConstraints=@UniqueConstraint(columnNames={"CARGO_ID"} ) )
public class Cargo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CARGO_ID", nullable=false, unique=true)
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


