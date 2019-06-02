<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>RealEstate | Cadastro de Cliente</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.7 -->
<link rel="stylesheet"
	href="<c:url value="/bower_components/bootstrap/dist/css/bootstrap.min.css"/>">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="<c:url value="/bower_components/font-awesome/css/font-awesome.min.css"/>">
<!-- Ionicons -->
<link rel="stylesheet"
	href="<c:url value="/bower_components/Ionicons/css/ionicons.min.css"/>">
<!-- Theme style -->
<link rel="stylesheet"
	href="<c:url value="/dist/css/AdminLTE.min.css"/>">
<!-- iCheck -->
<link rel="stylesheet"
	href="<c:url value="/plugins/iCheck/square/blue.css"/>">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"/>"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"/>"></script>
  <![endif]-->

<!-- Google Font -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition register-page">
	<div class="register-box">
		<div class="register-logo">
			<b>RealEstate</b>Solutions
		</div>

		<div class="register-box-body">
			<c:if test="${cliente != null}">
				<p class="login-box-msg">Atualizar Cliente</p>
			</c:if>
			<c:if test="${cliente == null}">
				<p class="login-box-msg">Cadastrar novo Cliente</p>
			</c:if>

			<c:if test="${cliente == null}">
				<form action="cadastrocliente" method="post">
			</c:if>
			<c:if test="${cliente != null}">
				<form action="atualizarcliente" method="post">
			</c:if>
			<c:if test="${cliente != null}">
				<input type="hidden" name="clienteId"
					value="<c:out value="${cliente.id}"/>" />
			</c:if>
			<div class="form-group has-feedback">
				<input type="text" class="form-control" name="nome"
					placeholder="Nome do Cliente"
					value="<c:out value="${cliente.nome}"/>" /> <span
					class="glyphicon glyphicon-user form-control-feedback"></span>
			</div>
			<div class="form-group has-feedback">
				<input type="text" class="form-control" name="contato"
					placeholder="Contato do Cliente"
					value="<c:out value="${cliente.contato}"/>" /> <span
					class="glyphicon glyphicon-envelope form-control-feedback"></span>
			</div>
			<div class="form-group has-feedback">
				<input type="text" class="form-control" name="endereco"
					placeholder="Endereço do Cliente"
					value="<c:out value="${cliente.endereco}"/>" /> <span
					class="glyphicon glyphicon-pushpin form-control-feedback"></span>
			</div>
			<div class="row">
				<div class="col-xs-8"></div>
				<!-- /.col -->
				<c:if test="${cliente == null}">
					<div class="col-xs-4">
						<button type="submit" class="btn btn-primary btn-block btn-flat">Cadastrar</button>
					</div>
				</c:if>
				<c:if test="${cliente != null}">
					<div class="col-xs-4">
						<button type="submit" class="btn btn-primary btn-block btn-flat">Atualizar</button>
					</div>
				</c:if>
				<!-- /.col -->
			</div>
			</form>

			<c:if test="${cliente != null}">
				<a href="<c:url value="/clientes"/>" class="text-center">Voltar ao Relatório de
					Clientes</a>
			</c:if>
			<c:if test="${cliente == null}">
				<a href="<c:url value="/login"/>" class="text-center">Voltar ao Dashboard</a>
			</c:if>
		</div>
		<!-- /.form-box -->
	</div>
	<!-- /.register-box -->

	<!-- jQuery 3 -->
	<script
		src="<c:url value="/bower_components/jquery/dist/jquery.min.js"/>"></script>
	<!-- Bootstrap 3.3.7 -->
	<script
		src="<c:url value="/bower_components/bootstrap/dist/js/bootstrap.min.js"/>"></script>
	<!-- iCheck -->
	<script src="<c:url value="/plugins/iCheck/icheck.min.js"/>"></script>
	<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' // optional
    });
  });
</script>
</body>
</html>
