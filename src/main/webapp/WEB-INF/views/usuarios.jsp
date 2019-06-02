<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>RealEstate | Usuários Cadastrados</title>
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
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet"
	href="<c:url value="/dist/css/skins/_all-skins.min.css"/>">

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
<body class="hold-transition skin-blue sidebar-mini">
	<script type="text/javascript">
		function removeUsuario(id){
			$("#mensagem").load('<c:url value="/excluirusuario"/>' + '?usuarioId=' + id).removeClass("hidden");
			alerta();
			$("#usuario" + id).remove();
		}
		function alerta(){
			setTimeout(function(){
				$("#alerta").removeClass("hidden").slideDown("slow");
			}, 500);
		}
	</script>
	<!-- Site wrapper -->
	<div class="wrapper">

		<header class="main-header">
			<!-- Logo -->
			<a href="#" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
				<span class="logo-mini"><b>R</b>SLT</span> <!-- logo for regular state and mobile devices -->
				<span class="logo-lg"><b>RealEstate</b>Solutions</span>
			</a>
			<!-- Header Navbar: style can be found in header.less -->
			<nav class="navbar navbar-static-top">
				<!-- Sidebar toggle button-->
				<a href="#" class="sidebar-toggle" data-toggle="push-menu"
					role="button"> <span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
				</a>

				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">

						<!-- User Account: style can be found in dropdown.less -->
						<li class="dropdown user user-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <img
								src="<c:url value="/dist/img/avatar5.png"/>" class="user-image"
								alt="User Image"> <span class="hidden-xs">${sessionScope.nome}</span>
						</a>
							<ul class="dropdown-menu">
								<!-- User image -->
								<li class="user-header"><img
									src="<c:url value="/dist/img/avatar5.png"/>" class="img-circle"
									alt="User Image">

									<p>${sessionScope.nome} - ${sessionScope.cargo.descricao}</p></li>
								<!-- Menu Footer-->
								<li class="user-footer">
									<div class="pull-left">
										<a href="<c:url value="/atualizarusuario?usuarioId=${sessionScope.id}"/>"
											class="btn btn-default btn-flat">Perfil</a>
									</div>
									<div class="pull-right">
										<a href="<c:url value="/logout"/>"
											class="btn btn-default btn-flat">Sair</a>
									</div>
								</li>
							</ul></li>
					</ul>
				</div>
			</nav>
		</header>

		<!-- =============================================== -->

		<!-- Left side column. contains the sidebar -->
		<aside class="main-sidebar">
			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">
				<!-- Sidebar user panel -->
				<div class="user-panel">
					<div class="pull-left image">
						<img src="<c:url value="/dist/img/avatar5.png"/>"
							class="img-circle" alt="User Image">
					</div>
					<div class="pull-left info">
						<p>
							<c:out value="${sessionScope.nome}"></c:out>
						</p>
						<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
					</div>
				</div>

				<!-- sidebar menu: : style can be found in sidebar.less -->
				<ul class="sidebar-menu" data-widget="tree">
					<li class="header">MENU PRINCIPAL</li>
					<li><a href="<c:url value="/cadastroimovel"/>"> <i class="fa fa-home"></i>
							<span>Cadastrar Imóvel</span> <span class="pull-right-container">
						</span>
					</a>
					<li><a
						href="<c:url value="/cadastrocliente"/>"> <i
							class="fa fa-address-book"></i> <span>Cadastrar Cliente</span> <span
							class="pull-right-container"> </span>
					</a>
					<li><a
						href="<c:url value="/cadastrousuario"/>"> <i
							class="fa fa-user-circle"></i> <span>Cadastrar Usuário</span> <span
							class="pull-right-container"> </span>
					</a>
					<li><a href="<c:url value="/usuarios"/>">
							<i class="fa fa-list"></i> <span>Usuários Cadastrados</span> <span
							class="pull-right-container"> </span>
					</a>
					<li><a href="<c:url value="/imoveis"/>">
							<i class="fa fa-folder-open"></i> <span>Imóveis
								Cadastrados</span> <span class="pull-right-container"> </span>
					</a>
					<li><a href="<c:url value="/clientes"/>">
							<i class="fa fa-male"></i> <span>Clientes Cadastrados</span> <span
							class="pull-right-container"> </span>
					</a>
			</section>
			<!-- /.sidebar -->
		</aside>

		<!-- =============================================== -->

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>Usuários</h1>
			</section>

			<!-- Main content -->
			<section class="content">

				<!-- Default box -->
				<div class="box">
					<div class="box-header with-border">
						<h3 class="box-title">Relatório de Usuários Cadastrados</h3>

						<div class="box-tools pull-right">
							<button type="button" class="btn btn-box-tool"
								data-widget="collapse" data-toggle="tooltip" title="Collapse">
								<i class="fa fa-minus"></i>
							</button>
							<button type="button" class="btn btn-box-tool"
								data-widget="remove" data-toggle="tooltip" title="Remove">
								<i class="fa fa-times"></i>
							</button>
						</div>
					</div>
					<div class="box-body">
						<div class="row">
							<div class="col-xs-12">
								<div class="">
									<!-- /.box-header -->
									<div class="box-body table-responsive no-padding">
										<div id="mensagem"></div>
										<div id="alerta"
											class="alert alert-success alert-dismissable hidden">
											<a href="#" class="close" data-dismiss="alert"
												aria-label="close">&times;</a> Usuário Excluído com Sucesso!
										</div>
										<table class="table table-hover">
											<tr>
												<th>E-mail</th>
												<th>Nome</th>
												<th>Cargo</th>
											</tr>
											<c:forEach var="u" items="${listaDeUsuarios}">
												<tr id="usuario${u.id}">
													<td><c:out value="${u.email}"></c:out></td>
													<td><c:out value="${u.nome}"></c:out></td>
													<td><c:out value="${u.cargo.descricao}"></c:out></td>
													<td><a
														href="<c:url value="/atualizarusuario?usuarioId=${u.id}"/>"><i
															class="fa fa-pencil-square-o" aria-hidden="true"></i></a></td>
													<td><a href="#"
														onclick="return removeUsuario(${u.id})"><i
															class="fa fa-times" aria-hidden="true"></i> </a></td>
												</tr>
											</c:forEach>
										</table>
									</div>
									<!-- /.box-body -->
								</div>
								<!-- /.box -->
							</div>
						</div>
						<!-- /.box-body -->
						<div class="box-footer"></div>
						<!-- /.box-footer-->
					</div>
					<!-- /.box -->
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->

		<footer class="main-footer">
			<div class="pull-right hidden-xs">
				<b>Version</b> 2.4.0
			</div>
			<strong>Copyright &copy; 2017 <a href="#">Real Estate
					Solutions</a>.
			</strong> All rights reserved.
		</footer>

		<!-- jQuery 3 -->
		<script
			src="<c:url value="/bower_components/jquery/dist/jquery.min.js"/>"></script>
		<!-- Bootstrap 3.3.7 -->
		<script
			src="<c:url value="/bower_components/bootstrap/dist/js/bootstrap.min.js"/>"></script>
		<!-- SlimScroll -->
		<script
			src="<c:url value="/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"/>"></script>
		<!-- FastClick -->
		<script
			src="<c:url value="/bower_components/fastclick/lib/fastclick.js"/>"></script>
		<!-- AdminLTE App -->
		<script src="<c:url value="/dist/js/adminlte.min.js"/>"></script>
		<!-- AdminLTE for demo purposes -->
		<script src="<c:url value="/dist/js/demo.js"/>"></script>
		<script>
  $(document).ready(function () {
    $('.sidebar-menu').tree()
  })
</script>
</body>
</html>