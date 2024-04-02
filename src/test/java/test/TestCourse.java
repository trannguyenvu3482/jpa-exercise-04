/**
 * 
 */
package test;

import static org.hibernate.testing.transaction.TransactionUtil.doInJPA;

import org.junit.jupiter.api.Test;

import iuh.fit.entity.Course;
import iuh.fit.entity.OnlineCourse;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * @author Trần Nguyên Vũ
 * @version 1.0
 * @created 2 Apr 2024 - 4:42:14 am
 */
class TestCourse {
	public EntityManagerFactory entityManagerFactory() {
		return Persistence.createEntityManagerFactory("sql-server-driver");
	}

	@Test
	void testAddCourse() {
		doInJPA(this::entityManagerFactory, entityManager -> {
			Course course = new OnlineCourse("Standard Programming", 3, "https://sv.iuh.edu.vn/StandardProgramming");
			entityManager.persist(course);
		});
	}

	@Test
	void testGetCourse() {
		doInJPA(this::entityManagerFactory, entityManager -> {
			Course course = entityManager.find(Course.class, 4062);
			System.out.println(course);
		});
	}

	@Test
	void testGetAllCourse() {
		doInJPA(this::entityManagerFactory, entityManager -> {
			entityManager.createQuery("select c from Course c", Course.class).getResultList()
					.forEach(System.out::println);
		});
	}

	@Test
	void testUpdateCourse() {
		doInJPA(this::entityManagerFactory, entityManager -> {
			Course course = entityManager.find(Course.class, 4062);
			course.setTitle("Standard Programming 2");
			course.setCredits(2);

			entityManager.merge(course);
		});
	}

	@Test
	void testDeleteCourse() {
		doInJPA(this::entityManagerFactory, entityManager -> {
			Course course = entityManager.find(Course.class, 4062);
			entityManager.remove(course);
		});
	}
}
