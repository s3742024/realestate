<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>RealEstate | Cadastro de Usuário</title>
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
  	<script src="<c:url value="/bower_components/jquery/dist/jquery.js"/>"></script>
  	<script src="<c:url value="/bower_components/jquery/dist/jquery.validate.js"/>"></script>
  	<style type="text/css">
label {
    display: block;
    margin-top: 10px;
}
label.error {
    float: none;
    color: red;
    margin: 0 .5em 0 0;
    vertical-align: top;
    font-size: 10px
}
p {
    clear: both;
}
.submit {
    margin-top: 1em;
}
em {
    font-weight: bold;
    padding-right: 1em;
    vertical-align: top;
}
</style>
<script type="text/javascript">
$(document).ready( function() {
    $("#formulario").validate({
        // Define as regras
        rules: {
            detalhes: {
                required: true, minlength: 30
            },
            descricao: {
                required: true, minLength: 20
            },
            valor: {
                required: true, minlength: 5
            },
            imagem: {
                required: true, minlength: 2
            }
        },
        // Define as mensagens de erro para cada regra
        messages: {
            detalhes: {
                required: "Informe os detalhes do imóvel", minLength: "O seu nome deve conter, no mínimo, 30 caracteres"
            },
            descricao: {
                required: "Informe uma breve descrição do imóvel", minLenght: "A descrição deve conter, no mínimo 20 caracteres"
            },
            valor: {
                required: "Informe o valor do imóvel", minLength: "O valor do imóvel deve conter, no mínimo, 5 caracteres"
            },
            imagem: {
                required: "Insira uma foto do imóvel", minLength: "A imagem do imóvel deve conter um nome"
            }
        }
    });
});

</script>

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
			<c:if test="${imovel != null}">
				<p class="login-box-msg">Atualizar Imóvel</p>
			</c:if>
			<c:if test="${imovel == null}">
				<p class="login-box-msg">Cadastrar novo Imóvel</p>
			</c:if>

			<c:if test="${imovel == null}">
				<form action="cadastroimovel" id="formulario" method="post"
					enctype="multipart/form-data">
			</c:if>
			<c:if test="${imovel != null}">
				<form action="atualizarimovel" method="post"
					enctype="multipart/form-data">
			</c:if>
			<c:if test="${imovel != null}">
				<input type="hidden" name="imovelId"
					value="<c:out value="${imovel.id}"/>" />
			</c:if>
			<div class="form-group has-feedback">
				<input type="text" class="form-control" name="detalhes"
					placeholder="Detalhes do Imóvel"
					value="<c:out value="${imovel.detalhes}"/>" /> <span
					class="glyphicon glyphicon-user form-control-feedback"></span>
			</div>
			<div class="form-group has-feedback">
				<input type="text" class="form-control" name="descricao"
					placeholder="Breve Descrição do Imóvel"
					value="<c:out value="${imovel.descricao}"/>" /> <span
					class="glyphicon glyphicon-envelope form-control-feedback"></span>
			</div>
			<div class="form-group">
				<label for="foto">Foto</label> <input type="file" id="foto"
					name="imagem" value="<c:out value="${imovel.fotos}"/>" />
			</div>
			<div class="form-group has-feedback">
				<input type="text" class="form-control" name="valor"
					placeholder="Valor do Imóvel"
					value="<c:out value="${imovel.valor}"/>" /> <span
					class="glyphicon glyphicon-log-in form-control-feedback"></span>
			</div>
			<div class="form-group has-feedback">
				<label>Situação do Imóvel</label> <select class="form-control"
					name="status">
					<c:forEach var="s" items="${listaDeStatus}">
						<option value="${s.id}">${s.descricao}</option>
					</c:forEach>
				</select> <label>Proprietário</label> <select class="form-control"
					name="proprietario">
					<c:forEach var="p" items="${listaDeProprietarios}">
						<option value="${p.id}">${p.nome}</option>
					</c:forEach>
				</select>
			</div>
			<div class="row">
				<div class="col-xs-8"></div>
				<!-- /.col -->
				<c:if test="${imovel == null}">
					<div class="col-xs-4">
						<button id="botao" type="submit" class="btn btn-primary btn-block btn-flat">Cadastrar</button>
					</div>
				</c:if>
				<c:if test="${imovel != null}">
					<div class="col-xs-4">
						<button type="submit" class="btn btn-primary btn-block btn-flat">Atualizar</button>
					</div>
				</c:if>
				<!-- /.col -->
			</div>
			</form>

			<c:if test="${imovel != null}">
				<a href="<c:url value="/imoveis"/>" class="text-center">Voltar ao Relatório de
					Imóveis</a>
			</c:if>
			<c:if test="${imovel == null}">
				<a href="<c:url value="/login"/>" class="text-center">Voltar ao Dashboard</a>
			</c:if>
		</div>
		<!-- /.form-box -->
	</div>
	<!-- /.register-box -->

	
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
