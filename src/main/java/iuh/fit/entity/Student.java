/**
 * 
 */
package iuh.fit.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class Student extends Person {
	@Column(name = "EnrollmentDate")
	private LocalDateTime enrollmentDate;

	public Student(String firstName, String lastName, LocalDateTime enrollmentDate) {
		super(firstName, lastName);
		this.enrollmentDate = enrollmentDate;
	}
}
