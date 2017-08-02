package pl.kurs.spring.crud.service;

import java.util.List;

import pl.kurs.spring.crud.model.Dog;

public interface DogService {
	Dog save(Dog newDog);
	Dog update(Dog exsitingDog);
	List<Dog> getAllDogs(String orderBy);
	void removeDog(Dog dog);
}
