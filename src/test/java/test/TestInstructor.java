/**
 * 
 */
package test;

import static org.hibernate.testing.transaction.TransactionUtil.doInJPA;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import iuh.fit.entity.Instructor;
import iuh.fit.entity.OfficeAssignment;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * @author Trần Nguyên Vũ
 * @version 1.0
 * @created 2 Apr 2024 - 9:57:00 am
 */

class TestInstructor {
	public EntityManagerFactory entityManagerFactory() {
		return Persistence.createEntityManagerFactory("sql-server-driver");
	}

	@Test
	void testAddInstructor() {
		doInJPA(this::entityManagerFactory, entityManager -> {
			Instructor instructor = new Instructor("Novak", "Djokovic", LocalDateTime.now());
			instructor.setOfficeAssignment(
					new OfficeAssignment("20 John", java.sql.Timestamp.valueOf(LocalDateTime.now())));
			entityManager.persist(instructor);
		});
	}

	@Test
	void testUpdateInstructor() {
		doInJPA(this::entityManagerFactory, entityManager -> {
			Instructor instructor = entityManager.find(Instructor.class, 2);
			instructor.setFirstName("Roger");
			entityManager.merge(instructor);
		});
	}

	@Test
	void testDeleteInstructor() {
		doInJPA(this::entityManagerFactory, entityManager -> {
			Instructor instructor = entityManager.find(Instructor.class, 2);
			entityManager.remove(instructor);
		});
	}

	@Test
	void testGetInstructor() {
		doInJPA(this::entityManagerFactory, entityManager -> {
			Instructor instructor = entityManager.find(Instructor.class, 2);
			System.out.println(instructor);
		});
	}

	@Test
	void testGetAllInstructors() {
		doInJPA(this::entityManagerFactory, entityManager -> {
			entityManager.createQuery("select i from Instructor i", Instructor.class).getResultList()
					.forEach(System.out::println);
		});
	}

	@Test
	void findInstructorByFirstNameOrLastNameMatch() {
		doInJPA(this::entityManagerFactory, entityManager -> {
			String matchString = "Novak";
			entityManager.createQuery(
					"select i from Instructor i where i.firstName like :matchString or i.lastName like :matchString",
					Instructor.class).setParameter("matchString", "%" + matchString + "%").getResultList()
					.forEach(System.out::println);
		});
	}
}
