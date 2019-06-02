<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>RealEstate | Cadastro de Usu�rio</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="<c:url value="/bower_components/bootstrap/dist/css/bootstrap.min.css"/>">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="<c:url value="/bower_components/font-awesome/css/font-awesome.min.css"/>">
  <!-- Ionicons -->
  <link rel="stylesheet" href="<c:url value="/bower_components/Ionicons/css/ionicons.min.css"/>">
  <!-- Theme style -->
  <link rel="stylesheet" href="<c:url value="/dist/css/AdminLTE.min.css"/>">
  <!-- iCheck -->
  <link rel="stylesheet" href="<c:url value="/plugins/iCheck/square/blue.css"/>">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"/></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"/></script>
  <![endif]-->

  <!-- Google Font -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition register-page">
<div class="register-box">
  <div class="register-logo">
    <b>RealEstate</b>Solutions
  </div>

  <div class="register-box-body">
  <c:if test="${usuario == null}">
    <p class="login-box-msg">Cadastrar novo usu�rio</p>
  </c:if>
    <c:if test="${usuario != null}">
    <p class="login-box-msg"> Atualizar usu�rio</p>
  </c:if>

<c:if test="${usuario == null}">
    <form action="cadastrousuario" method="post">
</c:if>
<c:if test="${usuario != null}">
    <form action="atualizarusuario" method="post">
</c:if>
			<c:if test="${usuario != null}">
				<input type="hidden" name="usuarioId"
					value="<c:out value="${usuario.id}"/>" />
			</c:if>
      <div class="form-group has-feedback">
        <input type="text" class="form-control" name="nome" placeholder="Nome" value="<c:out value="${usuario.nome}"/>" />
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="email" class="form-control" name="email" placeholder="Email" value="<c:out value="${usuario.email}"/>" />
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" name="senha" placeholder="Senha" value="<c:out value="${usuario.senha}"/>" />
        <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
      	<label>Cargo</label>
        <select class="form-control" name="cargo">
      <c:forEach var="c" items="${listaDeCargos}">
          <option value="${c.id}">${c.descricao}</option>
      </c:forEach>
        </select>
      </div>
      <div class="row">
        <div class="col-xs-8">
        </div>
        <!-- /.col -->
				<c:if test="${usuario == null}">
					<div class="col-xs-4">
						<button type="submit" class="btn btn-primary btn-block btn-flat">Cadastrar</button>
					</div>
				</c:if>
				<c:if test="${usuario != null}">
					<div class="col-xs-4">
						<button type="submit" class="btn btn-primary btn-block btn-flat">Atualizar</button>
					</div>
				</c:if>
        <!-- /.col -->
      </div>
    </form>

    			<c:if test="${usuario != null}">
				<a href="<c:url value="/usuarios"/>" class="text-center">Voltar ao Relat�rio de
					Usu�rios</a>
			</c:if>
			<c:if test="${usuario == null}">
				<a href="/login" class="text-center">Voltar ao Dashboard</a>
			</c:if>
  </div>
  <!-- /.form-box -->
</div>
<!-- /.register-box -->

<!-- jQuery 3 -->
<script src="<c:url value="/bower_components/jquery/dist/jquery.min.js"/>"></script>
<!-- Bootstrap 3.3.7 -->
<script src="<c:url value="/bower_components/bootstrap/dist/js/bootstrap.min.js"/>"></script>
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
