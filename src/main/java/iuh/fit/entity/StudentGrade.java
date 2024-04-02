/**
 * 
 */
package iuh.fit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Trần Nguyên Vũ
 * @version 1.0
 * @created 1 Apr 2024 - 8:28:57 pm
 */

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class StudentGrade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int enrollmentID;

	@ManyToOne
	@ToString.Exclude
	@JoinColumn(name = "CourseID")
	private Course course;

	@Column(name = "Grade")
	private double grade;

	@ManyToOne
	@ToString.Exclude
	@JoinColumn(name = "StudentID")
	private Student student;

	public StudentGrade(Student student, Course course, double grade) {
		this.student = student;
		this.course = course;
		this.grade = grade;
	}
}
