package br.com.unifeob.todoList.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.unifeob.todoList.entity.ToDo;
import br.com.unifeob.todoList.infra.factory.FactoryEntityManager;

public class ToDoDAO {

	private EntityManager entityManager;

	public ToDoDAO() {
		entityManager = new FactoryEntityManager().createEntityManager();
	}

	@SuppressWarnings("unchecked")
	public List<ToDo> lista() {
		return entityManager.createQuery("from ToDo").getResultList();
	}

	public void salva(ToDo toDo) {
		entityManager.getTransaction().begin();
		entityManager.merge(toDo);
		entityManager.getTransaction().commit();
	}

	public ToDo carrega(Long idTodo) {
		return entityManager.find(ToDo.class, idTodo);
	}

	public void remove(ToDo toDo) {
		entityManager.getTransaction().begin();
		entityManager.remove(toDo);
		entityManager.getTransaction().commit();

	}
}
