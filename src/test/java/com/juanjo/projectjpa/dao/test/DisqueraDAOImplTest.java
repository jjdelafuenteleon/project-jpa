/**
 * 
 */
package com.juanjo.projectjpa.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import com.juanjo.projectjpa.dao.DisqueraDAO;
import com.juanjo.projectjpa.dao.impl.DisqueraDAOImpl;
import com.juanjo.projectjpa.entity.Disquera;

/**
 * @author Juanjo
 *
 */
class DisqueraDAOImplTest {
	
	private DisqueraDAO disqueraDAO = new DisqueraDAOImpl();

	/**
	 * Test method for {@link com.juanjo.projectjpa.dao.impl.DisqueraDAOImpl#guardar(com.juanjo.projectjpa.entity.Disquera)}.
	 */
	@Test
	void testGuardar() {
		Disquera disquera = new Disquera();
		disquera.setDescripcion("MegaForce");
		disquera.setFechaCreacion(LocalDateTime.now());
		disquera.setEstatus(true);
		
		this.disqueraDAO.guardar(disquera);
	}

	/**
	 * Test method for {@link com.juanjo.projectjpa.dao.impl.DisqueraDAOImpl#actualizar(com.juanjo.projectjpa.entity.Disquera)}.
	 */
	@Test
	void testActualizar() {
		Disquera disquera = this.disqueraDAO.consultarById(9L);
		
		disquera.setDescripcion("Disquera IronMaiden");
		
		//if (disquera == null) {
			this.disqueraDAO.actualizar(disquera);
		//}
		
	}

	/**
	 * Test method for {@link com.juanjo.projectjpa.dao.impl.DisqueraDAOImpl#eliminar(com.juanjo.projectjpa.entity.Disquera)}.
	 */
	@Test
	void testEliminar() {
		Long id = 10L;
		this.disqueraDAO.eliminar(id);
	}

	/**
	 * Test method for {@link com.juanjo.projectjpa.dao.impl.DisqueraDAOImpl#consultar()}.
	 */
	@Test
	void testConsultar() {
		List<Disquera> disqueraConsutada = this.disqueraDAO.consultar();
		
		assertTrue(disqueraConsutada.size() > 0);
		
		disqueraConsutada.forEach(disquera -> {
			System.out.println("DisqueraDAOImplTest.testConsultar(Disquera) = "+disquera.getDescripcion());
		});
	}

	/**
	 * Test method for {@link com.juanjo.projectjpa.dao.impl.DisqueraDAOImpl#consultarById(java.lang.Long)}.
	 */
	@Test
	void testConsultarById(Long id) {
		System.out.println("DisqueraDAOImplTest.testConsultarById(disquera before)");
		Disquera disquera = this.disqueraDAO.consultarById(id);
		assertNotNull(disquera);
		System.out.println("DisqueraDAOImplTest.testConsultarById(disquera) = "+disquera.getDescripcion());
	}
	
	void testConsultarByDescripcionJPQL() {
		Disquera disqueraConsultar = this.disqueraDAO.consultarByDescripcionJPQL("MegaForce");
		assertNotNull(disqueraConsultar);
		System.out.println("DisqueraDAOImplTest.testConsultarByDescripcion(Disquera) = "+disqueraConsultar);
	}
	
	void testConsultarByDescripcionNative() {
		Disquera disqueraConsultar = this.disqueraDAO.consultarByDescripcionNative("MegaForce");
		assertNotNull(disqueraConsultar);
		System.out.println("DisqueraDAOImplTest.testConsultarByDescripcion(Disquera) = "+disqueraConsultar);
	}

}
