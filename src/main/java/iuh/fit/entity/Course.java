/**
 * 
 */
package iuh.fit.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Trần Nguyên Vũ
 * @version 1.0
 * @created 19 Mar 2024 - 1:53:03 pm
 */

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CourseID")
	private int id;

	@Column(name = "Title", columnDefinition = "varchar(255)")
	private String title;

	@Column(name = "Credits")
	private int credits;

	@ManyToOne
	@ToString.Exclude
	@JoinColumn(name = "DepartmentID")
	private Department department;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "CourseInstructor", joinColumns = @JoinColumn(name = "CourseID"), inverseJoinColumns = @JoinColumn(name = "PersonID"))
	@ToString.Exclude
	private Set<Instructor> instructors;

	public Course(String title, int credits) {
		super();
		this.title = title;
		this.credits = credits;
	}

}
