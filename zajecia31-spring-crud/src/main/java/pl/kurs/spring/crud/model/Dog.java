package pl.kurs.spring.crud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Dog {
	
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Id
    private int id;
	
    @NotEmpty
	private String breed;
    @NotNull
	private Integer age;
    @NotEmpty
	private String color;
    @NotEmpty
	private String name;
    @NotNull
	private Character gender;
	
	
}
