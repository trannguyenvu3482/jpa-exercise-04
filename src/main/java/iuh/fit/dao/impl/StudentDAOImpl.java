/**
 * 
 */
package iuh.fit.dao.impl;

import java.util.Collections;
import java.util.List;

import iuh.fit.dao.StudentDAO;
import iuh.fit.entity.Student;
import iuh.fit.entity.StudentGrade;
import iuh.fit.util.AppUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

/**
 * @author Trần Nguyên Vũ
 * @version 1.0
 * @created 9 Apr 2024 - 2:24:20 am
 */
public class StudentDAOImpl implements StudentDAO {
	private EntityManager em;

	public StudentDAOImpl() {
		em = Persistence.createEntityManagerFactory("sql-server-driver").createEntityManager();
	}

	@Override
	public List<Student> getAllStudents() {
		try {
			return AppUtils.castList(em.createQuery("SELECT s FROM Student s").getResultList(), Student.class);
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		}

	}

	@Override
	public Student getStudentByID(int id) {
		try {
			return em.find(Student.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<StudentGrade> getStudentCourseGradesByID(int id) {
		try {
			return em.find(Student.class, id).getStudentGrades();
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	@Override
	public List<StudentGrade> getStudentCourseGradesByName(String name) {
		try {
			return AppUtils.castList(em.createQuery("SELECT sg FROM StudentGrade sg WHERE sg.student.name = :name")
					.setParameter("name", name).getResultList(), StudentGrade.class);
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		}

	}

	@Override
	public Student getStudentByName(String name) {
		try {
			return em.createQuery("SELECT s FROM Student s WHERE s.name = :name", Student.class)
					.setParameter("name", "John Doe").getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
