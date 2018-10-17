package pruebas;

import entities.Carrera;
import servicios.CarreraDao;

public class Pruebas {

	public Pruebas() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Carrera carrera = new Carrera();
		CarreraDao cDao = new CarreraDao();
		
		carrera.setCodigo("115");
		carrera.setNombre("Ingeniería de Sistemas");
		carrera.setSemestres(10);
		carrera.setCreditos(160);
		
		System.out.println(cDao.listar().size());
		
		//cDao.insertar(carrera);
		
		Carrera c2 = cDao.buscar("118");
		
		System.out.println(c2.getNombre());
		
		c2.setNombre("Ing MINAS");
		cDao.actualizar(c2);
		c2 = cDao.buscar("118");
		System.out.println(c2.getNombre());
		cDao.eliminar(c2);

	}

}
