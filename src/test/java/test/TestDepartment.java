/**
 * 
 */
package test;

import static org.hibernate.testing.transaction.TransactionUtil.doInJPA;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import iuh.fit.entity.Department;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * @author Trần Nguyên Vũ
 * @version 1.0
 * @created 2 Apr 2024 - 4:57:19 am
 */
class TestDepartment {
	public EntityManagerFactory entityManagerFactory() {
		return Persistence.createEntityManagerFactory("sql-server-driver");
	}

	@Test
	void testAddDepartment() {
		doInJPA(this::entityManagerFactory, entityManager -> {
			Department department = new Department("Technology", 500000, LocalDateTime.now(), 1);
			entityManager.persist(department);
		});
	}

	@Test
	void testUpdateDepartment() {
		doInJPA(this::entityManagerFactory, entityManager -> {
			Department department = entityManager.find(Department.class, 8);
			department.setName("Technology 2");
			department.setBudget(400000);
			entityManager.merge(department);
		});
	}

	@Test
	void testDeleteDepartment() {
		doInJPA(this::entityManagerFactory, entityManager -> {
			Department department = entityManager.find(Department.class, 8);
			entityManager.remove(department);
		});
	}

	@Test
	void testGetDepartment() {
		doInJPA(this::entityManagerFactory, entityManager -> {
			Department department = entityManager.find(Department.class, 8);
			System.out.println(department);
		});
	}

	@Test
	void testGetAllDepartment() {
		doInJPA(this::entityManagerFactory, entityManager -> {
			entityManager.createQuery("select d from Department d", Department.class).getResultList()
					.forEach(System.out::println);
		});
	}

}
