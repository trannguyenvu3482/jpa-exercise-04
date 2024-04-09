/**
 * 
 */
package iuh.fit.entity;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Trần Nguyên Vũ
 * @version 1.0
 * @created 1 Apr 2024 - 8:32:17 pm
 */

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Department {

	@Column(name = "Administrator")
	private int administrator;

	@Column(name = "Budget")
	private double budget;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DepartmentID")
	private int id;

	@Column(name = "Name")
	private String name;

	@Column(name = "StartDate")
	private LocalDateTime startDate;

	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	private Set<Course> courses;

	public Department(String name, double budget, LocalDateTime startDate, int administrator) {
		this.name = name;
		this.administrator = administrator;
		this.budget = budget;
		this.startDate = startDate;
	}

	public Department(int id, String name, double budget, LocalDateTime startDate, int administrator) {
		this.id = id;
		this.name = name;
		this.administrator = administrator;
		this.budget = budget;
		this.startDate = startDate;
	}
}
