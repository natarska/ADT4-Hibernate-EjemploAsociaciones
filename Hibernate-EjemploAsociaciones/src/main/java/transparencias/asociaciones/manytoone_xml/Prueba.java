package transparencias.asociaciones.manytoone_xml;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * 
 * @description Clase de prueba de Hibernate. En un caso real ser�a un DAO
 *  
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
			/*
			 * Cuidado que al hacer close, los objetos pasan a estado detached,
			 * si hago close y luego fuera del try un return del objeto no
			 * tendr� acceso al valor de sus propiedades, �nicamente la clave
			 * primaria. Nos dar�a una excepci�n como esta: Exception in thread
			 * "main" org.hibernate.ObjectNotFoundException: No row with the
			 * given identifier exists: [transparencias.mapeos.Vuelo#0] at
			 * org.hibernate
			 * .internal.SessionFactoryImpl$1$1.handleEntityNotFound
			 * (SessionFactoryImpl.java:253) at
			 * org.hibernate.proxy.AbstractLazyInitializer
			 * .checkTargetState(AbstractLazyInitializer.java:262) at
			 * org.hibernate
			 * .proxy.AbstractLazyInitializer.initialize(AbstractLazyInitializer
			 * .java:176) at
			 * org.hibernate.proxy.AbstractLazyInitializer.getImplementation
			 * (AbstractLazyInitializer.java:286) at
			 * org.hibernate.proxy.pojo.javassist
			 * .JavassistLazyInitializer.invoke
			 * (JavassistLazyInitializer.java:185) at
			 * transparencias.mapeos.Vuelo_$$_jvstb20_0
			 * .toString(Vuelo_$$_jvstb20_0.java) at
			 * transparencias.mapeos.Prueba.main(Prueba.java:87)
			 */
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
		
		// Cerramos la factoria de sesiones, sino el programa no finalizar�
		Utilidades.getSessionFactory().close();
	}

}
