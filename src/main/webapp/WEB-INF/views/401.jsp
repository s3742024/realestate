<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>RealEstate | Erro</title>
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

	<section class="content">
		<div class="error-page">
			<h2 class="headline text-yellow">401</h2>

			<div class="error-content">
				<h3>
					<i class="fa fa-warning text-yellow"></i> Oops! Você não é um
					administrador.
				</h3>

				<p>
					Você não possui permissão para acessar esta página. <a
						href="<c:url value="/login"/>">Voltar à página principal</a>
				</p>
			</div>
		</div>
	</section>



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