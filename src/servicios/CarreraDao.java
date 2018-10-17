package servicios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Carrera;
import util.Conexion;

public class CarreraDao {
	
	private Carrera carrera;
	private List<Carrera> carreras = new ArrayList<Carrera>();
	private Conexion con;
	
	public CarreraDao() {
		// TODO Auto-generated constructor stub
		this.con = Conexion.getConexion();
	}
	
	public void insertar(Carrera carrera){
		String sql = "INSERT INTO carrera (codigo, nombre, "
				+ "creditos, semestre) VALUES('"+carrera.getCodigo()+"',"
				+ " '"+carrera.getNombre()+"', "
				+ "'"+carrera.getCreditos()+"', "
				+ "'"+carrera.getSemestres()+"')";
		
		try {
			con.insert(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void actualizar(Carrera carrera){
		String sql = "UPDATE carrera SET "
				+ "nombre = '"+carrera.getNombre()+"', "
				+ "semestre = "+carrera.getSemestres()+", "
				+ "creditos = "+carrera.getCreditos()+" "
				+ "WHERE codigo = '"+carrera.getCodigo()+"'";
		try {
			con.insert(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void eliminar(Carrera carrera){
		String sql = "DELETE FROM carrera "
				+ "WHERE codigo = '"+carrera.getCodigo()+"'";
		try {
			con.insert(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Carrera buscar(String codigo){
		
		String sql = "SELECT * FROM carrera "
				+ "WHERE codigo = '"+codigo+"'";
		System.out.println(sql);
		
		carrera = null;
		ResultSet res;
		
		try {
			res = con.query(sql);
			while(res.next()){
        	    carrera = new Carrera();
        	    carrera.setCodigo(res.getString("codigo"));
        	    carrera.setNombre(res.getString("nombre"));
        	    carrera.setCreditos(res.getInt("creditos"));
        	    carrera.setSemestres(res.getInt("semestre"));
			}
	   	res.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return carrera;
	}
	
	public List<Carrera> listar(){
		String sql = "SELECT * FROM carrera ";
		
		
		carrera = null;
		ResultSet res;
		
		try {
			res = con.query(sql);
			while(res.next()){
        	    carrera = new Carrera();
        	    carrera.setCodigo(res.getString("codigo"));
        	    carrera.setNombre(res.getString("nombre"));
        	    carrera.setCreditos(res.getInt("creditos"));
        	    carrera.setSemestres(res.getInt("semestre"));
        	    this.carreras.add(carrera);
			}
	   	res.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.carreras;
	}

}
