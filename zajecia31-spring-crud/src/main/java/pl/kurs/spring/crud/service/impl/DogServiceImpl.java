package pl.kurs.spring.crud.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.kurs.spring.crud.model.Dog;
import pl.kurs.spring.crud.service.DogService;

@Service
@Transactional
public class DogServiceImpl implements DogService {

	@PersistenceContext
	private EntityManager entityManager;

	private String orderDirection = "ASC";

	@Override
	public Dog save(Dog newDog) {
		System.out.println("SAVE");
		entityManager.persist(newDog);
		return newDog;
	}

	@Override
	public Dog update(Dog exsitingDog) {
		System.out.println("UPDATE");
		return entityManager.merge(exsitingDog);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dog> getAllDogs(String orderBy) {
		if (orderDirection.equals("ASC")) {
			orderDirection = "DESC";
		} else {
			orderDirection = "ASC";
		}
		
		return entityManager.createQuery("select d from Dog d order by d." + orderBy + " " + orderDirection).getResultList();
	}

	@Override
	public void removeDog(Dog dog) {
		entityManager.remove(entityManager.find(Dog.class, dog.getId()));
	}

}
