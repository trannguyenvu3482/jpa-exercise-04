/**
 * 
 */
package test;

import static org.hibernate.testing.transaction.TransactionUtil.doInJPA;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import iuh.fit.entity.Student;
import iuh.fit.entity.StudentGrade;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * The Class TestStudent.
 *
 * @author Trần Nguyên Vũ
 * @version 1.0
 * @created 2 Apr 2024 - 9:48:08 am
 */
class TestStudent {
	/**
	 * Entity manager factory.
	 *
	 * @return the entity manager factory
	 */
	public EntityManagerFactory entityManagerFactory() {
		return Persistence.createEntityManagerFactory("sql-server-driver");
	}

	/**
	 * Test add student.
	 */
	@Test
	void testAddStudent() {
		doInJPA(this::entityManagerFactory, entityManager -> {
			Student student = new Student("Novak", "Djokovic", LocalDateTime.now());
			entityManager.persist(student);
		});
	}

	/**
	 * Test update student.
	 */
	@Test
	void testUpdateStudent() {
		doInJPA(this::entityManagerFactory, entityManager -> {
			Student student = entityManager.find(Student.class, 2);
			student.setFirstName("Roger");
			entityManager.merge(student);
		});
	}

	/**
	 * Test delete student.
	 */
	@Test
	void testDeleteStudent() {
		doInJPA(this::entityManagerFactory, entityManager -> {
			Student student = entityManager.find(Student.class, 35);
			entityManager.remove(student);
		});
	}

	/**
	 * Test get student.
	 */
	@Test
	void testGetStudent() {
		doInJPA(this::entityManagerFactory, entityManager -> {
			Student student = entityManager.find(Student.class, 2);
			System.out.println(student);
		});
	}

	/**
	 * Test get all students.
	 */
	@Test
	void testGetAllStudents() {
		doInJPA(this::entityManagerFactory, entityManager -> {
			entityManager.createQuery("select s from Student s", Student.class).getResultList()
					.forEach(System.out::println);
		});
	}

	/**
	 * Test get student grades.
	 */
	@Test
	void testGetStudentGrades() {
		doInJPA(this::entityManagerFactory, entityManager -> {
			Student student = entityManager.find(Student.class, 2);
			List<StudentGrade> studentGrades = student.getStudentGrades();

			studentGrades.forEach(System.out::println);
		});
	}

	/**
	 * Find student by first name or last name match.
	 *
	 * @param matchString the match string
	 */
	@Test
	void findStudentByFirstNameOrLastNameMatch() {
		doInJPA(this::entityManagerFactory, entityManager -> {
			String matchString = "Yan";
			List<Student> students = entityManager.createQuery(
					"select s from Student s where s.firstName like :matchString or s.lastName like :matchString",
					Student.class).setParameter("matchString", "%" + matchString + "%").getResultList();

			students.forEach(System.out::println);
		});
	}
}
