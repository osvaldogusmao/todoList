<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/assets/css/bootstrap.min.css"></c:url>" rel="stylesheet">
<link href="<c:url value="/assets/css/bootstrap-glyphicons.css"></c:url>" rel="stylesheet">

<title>Todo List</title>
</head>
<body>
<div style="margin: 10px 10px 10px 10px;">

	<div class="panel" style="width: 560px; margin: 0 auto;">
		<div class="panel-heading">
			<h4 class="lead">List ToDo &nbsp;
				<a class="btn btn-success pull-right" href='<c:url value="/todos?novo"></c:url>'>
					<span class="glyphicon glyphicon-plus"></span>
				</a>
			</h4> 
		</div>
		<a href="" class="list-group-item active">Pendentes</a>
		<ul class="list-group">
			<c:forEach var="todo" items="${todos }">
				<c:if test="${todo.concluida != 'S' }" >
					<li class="list-group-item">
						<a class="pull-left" style="text-decoration: none;" href='<c:url value="/todos?favoritar&id=${todo.id}"></c:url>'>
							<c:if test="${todo.favorita != 'S' }" >
								<span class="glyphicon glyphicon-star-empty"></span>
							</c:if>
							<c:if test="${todo.favorita == 'S' }" >
								<span class="glyphicon glyphicon-star"></span>
							</c:if>
						</a>
						<span class="col-lg-8">
							<a class="pull-left" style="text-decoration: none;" href='<c:url value="/todos?alteraStatus&id=${todo.id}"></c:url>'>
								<span class="glyphicon glyphicon-ok-circle"></span>
							</a>
							&nbsp;
							${todo.descricao }

						</span>
						&nbsp;
						&nbsp;
						<a class="btn btn-default btn-sm" href='<c:url value="/todos?edita&id=${todo.id}"></c:url>'>
							<span class="glyphicon glyphicon-pencil"></span>
						</a>
						&nbsp;
						<a class="btn btn-danger btn-sm" href='<c:url value="/todos?remove&id=${todo.id}"></c:url>'>
							<span class="glyphicon glyphicon-remove"></span>
						</a>
					</li>
				</c:if>
			</c:forEach>
		</ul>
		<hr>
		<a href="" class="list-group-item active">Realizadas</a>
		<ul class="list-group">
			<c:forEach var="todo" items="${todos }">
				<c:if test="${todo.concluida eq 'S' }" >
					<li class="list-group-item">
						<a class="pull-left" style="text-decoration: none;" href='<c:url value="/todos?favoritar&id=${todo.id}"></c:url>'>
							<c:if test="${todo.favorita != 'S' }" >
								<span class="glyphicon glyphicon-star-empty"></span>
							</c:if>
							<c:if test="${todo.favorita == 'S' }" >
								<span class="glyphicon glyphicon-star"></span>
							</c:if>
						</a>
						<span class="col-lg-9">
							<a class="pull-left" style="text-decoration: none;" href='<c:url value="/todos?alteraStatus&id=${todo.id}"></c:url>'>
								<span class="glyphicon glyphicon-ok-sign"></span>
							</a>
							&nbsp;
							<span style="text-decoration:line-through;">${todo.descricao }</span>
						</span>
						&nbsp;
						&nbsp;	
						<a class="btn btn-default btn-sm" href='<c:url value="/todos?edita&id=${todo.id}"></c:url>'>
							<span class="glyphicon glyphicon-pencil"></span>
						</a>
						&nbsp;
						<a class="btn btn-danger btn-sm" href='<c:url value="/todos?remove&id=${todo.id}"></c:url>'>
							<span class="glyphicon glyphicon-remove"></span>
						</a>
					</li>
				</c:if>

			</c:forEach>
		</ul>
		<hr>
		<div class="panel-footer" style="height: 100px;">
			<h5>Legenda</h5>
			<div style="width: 33%; float: left;">
				<span class="glyphicon glyphicon-ok-circle"></span> Concluir tarefa <br/>
				<span class="glyphicon glyphicon-ok-sign"></span> Tarefa concluida <br/>
			</div>
			
			<div style="width: 33%; float: left;">
				<span class="glyphicon glyphicon-pencil"></span> Editar <br/>
				<span class="glyphicon glyphicon-remove"></span> Remover <br/>
			</div>
			
			<div style="width: 33%; float: left;">
				<span class="glyphicon glyphicon-star"></span> Com prioridade <br/>
				<span class="glyphicon glyphicon-star-empty"></span> Sem prioridade <br/>			
			</div>

		</div>
	</div>
</div>
	
<script type="text/javascript">


function alteraStatusTarefa(idToDo){
	
	var url = window.location.href+''+idToDo;

	window.location = url;
};


function redirect(url){
	console.log(url);
	window.location = window.location.href+url;
};

</script>

</body>
</html>