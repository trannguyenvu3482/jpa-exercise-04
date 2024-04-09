/**
 * 
 */
package iuh.fit.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Trần Nguyên Vũ
 * @version 1.0
 * @created 19 Mar 2024 - 2:24:26 pm
 */

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Instructor extends Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "HireDate")
	private LocalDateTime hireDate;

	@OneToOne(mappedBy = "instructor", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	@ToString.Exclude
	private OfficeAssignment officeAssignment;

	@ManyToMany(mappedBy = "instructors")
	@ToString.Exclude
	private Set<Course> courses;

	public Instructor(String firstName, String lastName, LocalDateTime hireDate) {
		super(firstName, lastName);
		this.hireDate = hireDate;
	}
}
