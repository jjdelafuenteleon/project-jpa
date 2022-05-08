/**
 * 
 */
package com.juanjo.projectjpa.dao;

import java.util.List;

import com.juanjo.projectjpa.entity.Disquera;

/**
 * @author Juanjo
 * Interaface que genera las transacciones 
 */
public interface DisqueraDAO {

	void guardar(Disquera disquera);
	
	void actualizar(Disquera disquera);
	
	void eliminar(Long id);
	
	List<Disquera> consultar();
	
	Disquera consultarById(Long id);
	/**
	 * Metodo que permite consultar con JPQL la disquera a partir de una descripcion
	 * @param descripcion
	 * @return
	 */
	Disquera consultarByDescripcionJPQL(String descripcion);
	
	/**
	 * Metodo que permite consultar con JPQL la disquera a partir de una descripcion
	 * @param descripcion
	 * @return
	 */
	Disquera consultarByDescripcionNative(String descripcion);
	
}
