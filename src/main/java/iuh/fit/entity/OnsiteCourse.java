/**
 * 
 */
package iuh.fit.entity;

import java.io.Serializable;
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
 * @created 1 Apr 2024 - 8:22:42 pm
 */

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class OnsiteCourse extends Course implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "Days")
	private String days;

	@Column(name = "Location")
	private String location;

	@Column(name = "Time", columnDefinition = "datetime2")
	private transient LocalDateTime time;

	public OnsiteCourse(String title, int credits, String days, String location, LocalDateTime time) {
		super(title, credits);
		this.days = days;
		this.location = location;
		this.time = time;
	}
}
