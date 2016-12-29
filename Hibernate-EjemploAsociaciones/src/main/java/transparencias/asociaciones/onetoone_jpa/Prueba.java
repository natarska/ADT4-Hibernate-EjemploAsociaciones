package transparencias.asociaciones.onetoone_jpa;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * 
 * @description Clase de prueba de Hibernate. En un caso real ser�a un DAO
 */
public class Prueba {

	/**
	 * M�todo para actualizar un empleado
	 * 
	 * @param emp
	 */
	public void borraEmpleado(Empleado emp) {
		// Conseguimos un objeto sesi�n para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {

			// abrimos una transacci�n
			tx = session.beginTransaction();
			// Guardamos el objeto en la sesi�n
			session.delete(emp);
			// Commit de la transacci�n
			session.getTransaction().commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Ocurri� un error");
		} finally {
			
			session.close();
		}

	}

	/**
	 * M�todo para actualizar un empleado
	 * 
	 * @param emp
	 */
	public void actualizaEmpleado(Empleado emp) {
		// Conseguimos un objeto sesi�n para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {

			// abrimos una transacci�n
			tx = session.beginTransaction();
			// Guardamos el objeto en la sesi�n
			session.update(emp);
			// Commit de la transacci�n
			session.getTransaction().commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Ocurri� un error");
		} finally {
			session.close();
		}

	}

	/**
	 * M�todo para almacenar un empleado
	 * 
	 * @param emp
	 */
	public void almacenaEmpleado(Empleado emp) {
		// Conseguimos un objeto sesi�n para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {

			// abrimos una transacci�n
			tx = session.beginTransaction();
			// Guardamos el objeto en la sesi�n
			session.save(emp);
			// Commit de la transacci�n
			session.getTransaction().commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Ocurri� un error");
		} finally {
			session.close();
		}

	}

	/**
	 * M�todo para recuperar un empleado
	 * 
	 * @param id
	 * @return
	 */
	public Empleado RecuperaEmpleado(int id) {
		// Conseguimos un objeto sesi�n para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Empleado emp = new Empleado();

		// abrimos una transacci�n
		session.beginTransaction();
		// Recuperamos el empleado
		emp = (Empleado) session.load(Empleado.class, id);
		// Commit de la transacci�n
		session.getTransaction().commit();

		return emp;
	}

	public static void main(String[] args) {
		
		//�Que pasar�a si intento crear otro empleado con el mismo cargo? Que al recuperarlo me va a dar error, 
				//porque intenta encontrar una fila Cargo con el mismo id y esto no existe
				//Cuidado si hacemos esta prueba: despu�s reiniciar los indices de clave primaria
				//de ambas tablas al mismo valor, sino dar� error siempre despu�s de hacer la prueba
				//Para Ello:
				//ALTER table Empleados.Empleado AUTO_INCREMENT=10;
				//ALTER table Empleados.Cargo AUTO_INCREMENT=10;
		
/*		Empleado emp = new Empleado();
		Empleado emp1 = new Empleado();
		Empleado empR;
		emp.setNombre("Pankaj");
		emp.setRol("CEO");
		emp.setFecha(new Date());
		emp1.setNombre("Maria");
		emp1.setRol("Programador");
		emp1.setFecha(new Date());
		Cargo cargo=new Cargo();
		cargo.setNombre("jefe");
		cargo.setSueldo(10000);
		emp.setCargo(cargo);
		emp1.setCargo(cargo);
	
		Prueba prueba = new Prueba();
		prueba.almacenaEmpleado(emp);
		// Hibernate sincroniza el estado del objeto para que tenga el id
		// autogenerado de BD
		System.out.println("Empleado almacenado:" + emp.toString());
		empR = prueba.RecuperaEmpleado(emp.getId());
		System.out.println("Empleado recuperado:" + empR.toString());
		
		prueba.almacenaEmpleado(emp1);
		// Hibernate sincroniza el estado del objeto para que tenga el id
		// autogenerado de BD
		System.out.println("Empleado almacenado:" + emp1.toString());
		empR = prueba.RecuperaEmpleado(emp1.getId());
		System.out.println("Empleado recuperado:" + empR.toString());
*/
		Empleado emp = new Empleado();
		Empleado emp1 = new Empleado();
		Empleado empR;
		emp.setNombre("Pankaj");
		emp.setRol("CEO");
		emp.setFecha(new Date());
		emp1.setNombre("Maria");
		emp1.setRol("Programador");
		emp1.setFecha(new Date());
		Cargo cargo=new Cargo();
		cargo.setNombre("jefe");
		cargo.setSueldo(10000);
		emp.setCargo(cargo);
		Cargo cargo1=new Cargo();
		cargo1.setNombre("secretario");
		cargo1.setSueldo(8000);
		emp1.setCargo(cargo1);

		Prueba prueba = new Prueba();
		prueba.almacenaEmpleado(emp);
		// Hibernate sincroniza el estado del objeto para que tenga el id
		// autogenerado de BD
		System.out.println("Empleado almacenado:" + emp.toString());
		empR = prueba.RecuperaEmpleado(emp.getId());
		System.out.println("Empleado recuperado:" + empR.toString());
		
		prueba.almacenaEmpleado(emp1);
		// Hibernate sincroniza el estado del objeto para que tenga el id
		// autogenerado de BD
		System.out.println("Empleado almacenado:" + emp1.toString());
		empR = prueba.RecuperaEmpleado(emp1.getId());
		System.out.println("Empleado recuperado:" + empR.toString());
		
		// Cerramos la factoria de sesiones, sino el programa no finalizar�
		Utilidades.getSessionFactory().close();
		
		
		
	}

}
