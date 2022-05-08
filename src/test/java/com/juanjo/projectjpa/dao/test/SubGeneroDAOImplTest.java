/**
 * 
 */
package com.juanjo.projectjpa.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.juanjo.projectjpa.dao.SubGeneroDAO;
import com.juanjo.projectjpa.dao.impl.SubGeneroDAOImpl;
import com.juanjo.projectjpa.entity.Genero;
import com.juanjo.projectjpa.entity.SubGenero;

/**
 * @author Juanjo
 *
 */
class SubGeneroDAOImplTest {
	
	private SubGeneroDAO subGeneroDAO = new SubGeneroDAOImpl();
	

	/**
	 * Test method for {@link com.juanjo.projectjpa.dao.impl.SubGeneroDAOImpl#guardar(com.juanjo.projectjpa.entity.SubGenero)}.
	 */
	@Test
	void testGuardar() {
		SubGenero subGenero = new SubGenero();
		subGenero.setDescripcion("Hard Core");
		subGenero.setFechaCreacion(LocalDateTime.now());
		subGenero.setEstatus(true);
		
		Genero genero = new Genero();
		genero.setDescripcion("Metal");
		genero.setFechaCreacion(LocalDateTime.now());
		genero.setEstatus(true);
		
		subGenero.setGenero(genero);
		
		this.subGeneroDAO.guardar(subGenero);
	}

	/**
	 * Test method for {@link com.juanjo.projectjpa.dao.impl.SubGeneroDAOImpl#actualizar(com.juanjo.projectjpa.entity.SubGenero)}.
	 */
	@Test
	void testActualizar() {
		SubGenero subGeneroConsultado = this.subGeneroDAO.consultarById(7L);
		
		subGeneroConsultado.setDescripcion("Trash Metal");
		subGeneroConsultado.getGenero().setDescripcion("Metal Trahs");
		
		this.subGeneroDAO.actualizar(subGeneroConsultado);
	}

	/**
	 * Test method for {@link com.juanjo.projectjpa.dao.impl.SubGeneroDAOImpl#eliminar(java.lang.Long)}.
	 */
	@Test
	void testEliminar() {
		this.subGeneroDAO.eliminar(7L);
	}

	/**
	 * Test method for {@link com.juanjo.projectjpa.dao.impl.SubGeneroDAOImpl#consultar()}.
	 */
	@Test
	void testConsultar() {
		List<SubGenero> subGenerosConsultados =  this.subGeneroDAO.consultar();
		assertTrue(subGenerosConsultados.size() > 0);
		
		for (SubGenero subGenero : subGenerosConsultados) {
			System.out.println("SubGeneroDAOImplTest.testConsultar(SubGenero) = "+subGenero.getDescripcion());
			System.out.println("SubGeneroDAOImplTest.testConsultar(Genero) = "+subGenero.getGenero().getDescripcion());
		}
		
	}

	/**
	 * Test method for {@link com.juanjo.projectjpa.dao.impl.SubGeneroDAOImpl#consultarById(java.lang.Long)}.
	 */
	@Test
	void testConsultarById() {
		fail("Not yet implemented");
	}

}
