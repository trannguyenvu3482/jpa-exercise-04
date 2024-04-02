/**
 * 
 */
package test;

import static org.hibernate.testing.transaction.TransactionUtil.doInJPA;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import iuh.fit.entity.Student;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * @author Trần Nguyên Vũ
 * @version 1.0
 * @created 2 Apr 2024 - 9:48:08 am
 */
class TestStudent {
	public EntityManagerFactory entityManagerFactory() {
		return Persistence.createEntityManagerFactory("sql-server-driver");
	}

	@Test
	void testAddStudent() {
		doInJPA(this::entityManagerFactory, entityManager -> {
			Student student = new Student("Novak", "Djokovic", LocalDateTime.now());
			entityManager.persist(student);
		});
	}

	@Test
	void testUpdateStudent() {
		doInJPA(this::entityManagerFactory, entityManager -> {
			Student student = entityManager.find(Student.class, 2);
			student.setFirstName("Roger");
			entityManager.merge(student);
		});
	}

	@Test
	void testDeleteStudent() {
		doInJPA(this::entityManagerFactory, entityManager -> {
			Student student = entityManager.find(Student.class, 2);
			entityManager.remove(student);
		});
	}

	@Test
	void testGetStudent() {
		doInJPA(this::entityManagerFactory, entityManager -> {
			Student student = entityManager.find(Student.class, 2);
			System.out.println(student);
		});
	}

	@Test
	void testGetAllStudents() {
		doInJPA(this::entityManagerFactory, entityManager -> {
			entityManager.createQuery("from Student", Student.class).getResultList().forEach(System.out::println);
		});
	}
}
