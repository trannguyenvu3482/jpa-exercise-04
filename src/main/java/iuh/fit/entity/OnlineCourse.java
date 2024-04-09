/**
 * 
 */
package iuh.fit.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Trần Nguyên Vũ
 * @version 1.0
 * @created 1 Apr 2024 - 8:25:46 pm
 */

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class OnlineCourse extends Course implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "URL")
	private String url;

	public OnlineCourse(String title, int credits, String url) {
		super(title, credits);
		this.url = url;
	}
}
