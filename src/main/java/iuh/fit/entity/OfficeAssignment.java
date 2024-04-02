/**
 * 
 */
package iuh.fit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Trần Nguyên Vũ
 * @version 1.0
 * @created 1 Apr 2024 - 8:26:47 pm
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
public class OfficeAssignment {

	@Column(name = "Location")
	private String location;

	@Column(name = "Timestamp")
	private java.sql.Timestamp timestamp;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "InstructorID")
	private Instructor instructor;

	public OfficeAssignment(String location, java.sql.Timestamp timestamp) {
		this.location = location;
		this.timestamp = timestamp;
	}
}