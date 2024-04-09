/**
 * 
 */
package iuh.fit.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Trần Nguyên Vũ
 * @version 1.0
 * @created 19 Mar 2024 - 1:59:28 pm
 */

@Getter
@Setter
@NoArgsConstructor
@ToString

@Entity
public class Student extends Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "EnrollmentDate")
	private LocalDateTime enrollmentDate;

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@ToString.Exclude
	private List<StudentGrade> studentGrades;

	public Student(String firstName, String lastName, LocalDateTime enrollmentDate) {
		super(firstName, lastName);
		this.enrollmentDate = enrollmentDate;
	}
}
