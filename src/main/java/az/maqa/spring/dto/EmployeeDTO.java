package az.maqa.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
	private Long id;

	private String name;

	private String surname;

	private String job;

	private Integer active;
}
