/**
 * 
 */
package iuh.fit.dao;

import java.util.List;

import iuh.fit.entity.Course;

/**
 * @author Trần Nguyên Vũ
 * @version 1.0
 * @created 9 Apr 2024 - 12:18:20 am
 */
public interface CourseDAO {
	public List<Course> getAllCourses();

	public Course getCourseById(int id);

	public Course getCourseByName(String name);

}
