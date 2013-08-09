package br.com.unifeob.todoList.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.unifeob.todoList.dao.ToDoDAO;
import br.com.unifeob.todoList.entity.ToDo;
import br.com.unifeob.todoList.util.Util;

@WebServlet("/todos")
public class TodoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final ToDoDAO dao;

	public TodoServlet() {
		this.dao = new ToDoDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Map<String, String[]> parameterMap = request.getParameterMap();

		String urlPath = request.getContextPath() + "/todos";

		Long idTodo;

		if (parameterMap.size() == 0) {
			request.setAttribute("todos", lista());
			dispatcher(request, response, "/index.jsp");
		}
		if (parameterMap.containsKey("novo")) {
			dispatcher(request, response, "/form.jsp");
		}
		if (parameterMap.containsKey("edita")) {
			idTodo = Long.parseLong(request.getParameter("id"));
			request.setAttribute("todo", carrega(idTodo));
			dispatcher(request, response, "/form.jsp");
		}
		if (parameterMap.containsKey("remove")) {
			idTodo = Long.parseLong(request.getParameter("id"));
			remove(idTodo);
			redirect(response, urlPath);
		}
		if (parameterMap.containsKey("alteraStatus")) {
			idTodo = Long.parseLong(request.getParameter("id"));
			alteraStatus(idTodo);
			redirect(response, urlPath);
		}
		if (parameterMap.containsKey("favoritar")) {
			idTodo = Long.parseLong(request.getParameter("id"));
			favoritar(idTodo);
			redirect(response, urlPath);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		String urlPath = request.getContextPath() + "/todos";

		Map<String, String[]> parameterMap = request.getParameterMap();

		if (parameterMap.containsKey("salva")) {

			ToDo toDo;

			if (request.getParameter("id").isEmpty()) {
				toDo = new ToDo();

				toDo.setDescricao(request.getParameter("descricao"));
				toDo.setDataTermino(Util.converterStringParaCalendar(request.getParameter("dataTermino")));
				toDo.setConcluida(request.getParameter("concluida"));
				toDo.setFavorita("N");
			} else {
				toDo = dao.carrega(Long.parseLong(request.getParameter("id")));

				toDo.setDescricao(request.getParameter("descricao"));
				toDo.setDataTermino(Util.converterStringParaCalendar(request.getParameter("dataTermino")));
				toDo.setConcluida(request.getParameter("concluida"));

				salva(toDo);
			}
			salva(toDo);

			redirect(response, urlPath);
		}

	}

	/**
	 * 
	 * MŽtodos privados
	 * 
	 * */
	private List<ToDo> lista() {
		return dao.lista();
	}

	private void salva(ToDo toDo) {
		dao.salva(toDo);
	}

	private ToDo carrega(Long idTodo) {
		return dao.carrega(idTodo);
	}

	private void remove(Long id) {
		ToDo toDo = carrega(id);
		dao.remove(toDo);
	}

	private void alteraStatus(Long idTodo) {
		ToDo toDo = carrega(idTodo);
		if (toDo.getConcluida().equals("S")) {
			toDo.setConcluida("N");
		} else {
			toDo.setConcluida("S");
		}
		dao.salva(toDo);
	}

	private void favoritar(Long idTodo) {
		ToDo toDo = carrega(idTodo);
		if (toDo.getFavorita().equals("S")) {
			toDo.setFavorita("N");
		} else {
			toDo.setFavorita("S");
		}
		dao.salva(toDo);
	}

	private void dispatcher(HttpServletRequest request, HttpServletResponse response, String url) {
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void redirect(HttpServletResponse response, String url) {
		try {
			response.sendRedirect(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
