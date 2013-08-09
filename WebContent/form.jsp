<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/assets/css/bootstrap.min.css"></c:url>" rel="stylesheet">
<link href="<c:url value="/assets/css/bootstrap-glyphicons.css"></c:url>" rel="stylesheet">
<script type="text/javascript" src='<c:url value="/assets/js/jquery.min.js"></c:url>'></script>
<script type="text/javascript" src='<c:url value="/assets/js/bootstrap.js"></c:url>'></script>
<script type="text/javascript" src='<c:url value="/assets/js/bootstrap-inputmask.js"></c:url>'></script>

<title>Todo List</title>
</head>
<body>
	<div style="margin: 10px 10px 10px 10px;">

		<div class="panel" style="width: 560px; margin: 0 auto;">
			<div class="panel-heading">
				<h4 class="lead">List ToDo &nbsp;
					<a class="btn btn-info pull-right"  href="<c:url value='/todos'></c:url>">
						<span class="glyphicon glyphicon-list"></span>
					</a>
				</h4> 
			</div>
			<form action='<c:url value="/todos?salva"></c:url>' method="post">
			
				<input type="hidden" id="id" name="id" value="<c:if test="${todo != null}">${todo.id}</c:if>" >
			
				<label for="descricao">Descrição</label><br/>
				<input type="text" id="descricao" name="descricao" value="<c:if test="${todo != null}">${todo.descricao}</c:if>" class="form-control" required autocomplete="off"> 
				
				<br/>
				
				<label for="dataTermino">Terminar até ?</label><br/>
				<input type="text" id="dataTermino" name="dataTermino" value="<c:if test="${todo != null}"><fmt:formatDate value="${todo.dataTermino.time}" pattern="dd/MM/yyyy"/></c:if>" class="form-control" data-mask="99/99/9999" autocomplete="off" required>
				
				
				<br/>
				
				<label for="concluida">Concluida ?</label>
				<input type="checkbox" id="concluida" name="concluida" value="S" <c:if test="${todo != null && todo.concluida == 'S'}">checked</c:if>>
			
				<br/>
				
				<input type="submit" value="Salvar" class="btn btn-primary btn-lg btn-block">
			
			</form>
		</div>
	</div>

</body>
</html>