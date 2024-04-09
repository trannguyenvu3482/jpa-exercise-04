/**
 * 
 */
package iuh.fit.dao.impl;

import java.util.List;

import iuh.fit.dao.CourseDAO;
import iuh.fit.entity.Course;
import iuh.fit.util.AppUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

/**
 * @author Trần Nguyên Vũ
 * @version 1.0
 * @created 9 Apr 2024 - 12:18:27 am
 */
public class CourseDAOImpl implements CourseDAO {
	private EntityManager em;

	public CourseDAOImpl() {
		em = Persistence.createEntityManagerFactory("sql-server-driver").createEntityManager();
	}

	@Override
	public List<Course> getAllCourses() {
		try {
			return AppUtils.castList(em.createQuery("SELECT c FROM Course c").getResultList(), Course.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Course getCourseById(int id) {
		try {
			return em.find(Course.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Course getCourseByName(String name) {
		try {
			return (Course) em.createQuery("SELECT c FROM Course c WHERE c.title = :name").setParameter("name", name)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
