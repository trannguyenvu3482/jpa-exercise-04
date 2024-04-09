/**
 * 
 */
package iuh.fit.dao;

import java.util.List;

import iuh.fit.entity.Student;
import iuh.fit.entity.StudentGrade;

/**
 * @author Trần Nguyên Vũ
 * @version 1.0
 * @created 9 Apr 2024 - 2:23:36 am
 */
public interface StudentDAO {
	public List<Student> getAllStudents();

	public Student getStudentByID(int id);

	public Student getStudentByName(String name);

	public List<StudentGrade> getStudentCourseGradesByName(String name);

	public List<StudentGrade> getStudentCourseGradesByID(int id);

}
