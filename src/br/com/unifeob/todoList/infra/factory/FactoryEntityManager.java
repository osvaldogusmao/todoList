package br.com.unifeob.todoList.infra.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FactoryEntityManager {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("todoList");;

	public EntityManager createEntityManager() {
		System.out.println("Criou o entity manager");
		return factory.createEntityManager();
	}

	public void closeEntityManager(EntityManager entityManager) {
		entityManager.close();
	}

	public void closeEntityManagerFactory(EntityManagerFactory factory) {
		factory.close();
	}
}
