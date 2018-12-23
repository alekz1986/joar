<%--
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
--%>
<%@ page import="com.joar.fact.config.Ctes" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title><%=Ctes.NOMBRE_APLICACION%> | Login</title>

    <link href="<%=request.getContextPath()%>/recursos/css/bootstrap.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/recursos/font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="<%=request.getContextPath()%>/recursos/css/animate.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/recursos/css/style.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/recursos/css/joarsys.css" rel="stylesheet">

</head>

<%
String mensaje = (String) request.getAttribute("error");
%>
<body class="gray-bg">

    <div class="middle-box text-center loginscreen animated fadeInDown">
        <div>
            <div>

                <h1 class="logo-name login-marca-agua">JOAR</h1>

            </div>
            <h2><strong>Bienvenido a JoarSystem</strong></h2>
            <p>Diseñado especialmente para satisfacer las necesidades de su negocio.
            </p>
            <!--
            <p>Perfectly designed and precisely prepared admin theme with over 50 pages with extra new web app views.
            </p>
            -->
            <p><strong>Iniciar Sesión.</strong></p>
            <form id="frmIngresar" class="m-t" role="form" method="post" action="<%=request.getContextPath()%>/login/ingresar">
                <div class="form-group">
                    <input name="usuario" type="text" class="form-control" placeholder="Usuario" required="">
                </div>
                <div class="form-group">
                    <input id="clave" name="clave" type="password" class="form-control" placeholder="Clave" required="">
                </div>
                <input type="hidden" name="chash" id="chash"/>
                <!--<button type="submit" class="btn btn-primary block full-width m-b">Ingresar</button>-->
                
                <% if (mensaje != null) { %>
                <div><span style="font-size:12px;" class="text-danger">${error}</span></div>
                <!--
                <div class="alert alert-danger" style="padding: 3px; font-size: 12px;">${error}</div> 
                -->
                <!--
                <small class="label label-danger">
                	<i class="fa fa-clock-o"></i>${error}
                </small>
                -->
                <p></p>
                <% } %>
                
                
                <button id="btnLogin" type="button" class="btn btn-primary block full-width m-b">Ingresar</button>

                <a href="#"><small>¿Perdió su clave?</small></a>
                
                <!--
                <p class="text-muted text-center"><small>Do not have an account?</small></p>
                <a class="btn btn-sm btn-white btn-block" href="register.html">Create an account</a>
                -->
            </form>
            <p class="m-t"> <small>Copyright @ 2019 JoarSystem Lima Perú. Todos los derechos reservados</small> </p>
        </div>
    </div>

    <!-- Mainly scripts -->
    <script src="<%=request.getContextPath()%>/recursos/js/jquery-3.3.1.min.js"></script>
    <script src="<%=request.getContextPath()%>/recursos/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/recursos/js/sha256.js"></script>
	<script type="text/javascript" >
		$(function() {
			$("#btnLogin").click(function() {
				//var hash = sha256.create();
				//hash.update("123456")
				//console.log("hex = " + hash.hex());
				$("#chash").val(sha256($("#clave").val()));
				$("#frmIngresar").submit();
			});
		});
	</script>
</body>

</html>
