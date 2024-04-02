/**
 * 
 */
package iuh.fit;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * @author Trần Nguyên Vũ
 * @version 1.0
 * @created 19 Mar 2024 - 2:00:40 pm
 */
public class Main {

	public static void main(String[] args) {
		try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("sql-server-driver");
				EntityManager em = emf.createEntityManager()) {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
