/**
 * 
 */
package com.juanjo.projectjpa.dao;

import java.util.List;

import com.juanjo.projectjpa.entity.SubGenero;

/**
 * @author Juanjo
 * CRUD tabla sub genero
 */
public interface SubGeneroDAO {
	
	void guardar(SubGenero subGenero);
	
	void actualizar(SubGenero subGenero);
	
	void eliminar(Long id);
	
	List<SubGenero> consultar();
	
	SubGenero consultarById(Long id);

}
