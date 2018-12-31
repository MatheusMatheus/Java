<%@page import="java.net.URL"%>
<%@page import="java.net.HttpURLConnection"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Farmácia</title>

<!-- Bootstrap core CSS -->
<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="resources/css/shop.css" rel="stylesheet">

</head>

<body>

	<!-- Page Content -->
	<div class="container">
		<h2>Farmácia</h2>
		<p>Lista de medicamentos</p>
		<table class="table">
			<thead>
				<tr>
					<th>Medicamento</th>
					<th>laboratório</th>
					<th>Exibir</th>
					<th>Editar</th>
					<th>Excluir</th>
				</tr>
			</thead>
			<tbody>
			<jsp:useBean id="dao" class = "farmacia.model.dao.MedicamentoDAO"/>
				<c:forEach var="medicamento" items="${dao.lista}">
					<tr>
						<td>${medicamento.nome}</td>
						<td>${medicamento.laboratorio.nome}</td>
						<td><button type="button" class="btn exibir">Exibir</button></td>
						<td><button type="button" class="btn editar">Editar</button></td>
						<td><button type="button" class="btn excluir">Excluir</button></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<button type="button" class="btn">Inserir medicamento</button>
	</div>
	<!-- /.container -->



	<!-- Bootstrap core JavaScript -->
	<script src="resources/jquery/jquery.min.js"></script>
	<script src="resources/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="resources/js/carregar.js"></script>
</body>

</html>