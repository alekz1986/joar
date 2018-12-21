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

<body class="gray-bg">

    <div class="middle-box text-center loginscreen animated fadeInDown">
        <div>
            <div>

                <h1 class="logo-name login-marca-agua">JOAR</h1>

            </div>
            <h3>Bienvenido a JoarSystem</h3>
            <p>Diseñado especialmente para satisfacer las necesidades de su negocio.
            </p>
            <!--
            <p>Perfectly designed and precisely prepared admin theme with over 50 pages with extra new web app views.
            </p>
            -->
            <p>Iniciar Sesión.</p>
            <form class="m-t" role="form" action="<%=request.getContextPath()%>/login/ingresar">
                <div class="form-group">
                    <input type="usuario" class="form-control" placeholder="Usuario" required="">
                </div>
                <div class="form-group">
                    <input type="clave" class="form-control" placeholder="Clave" required="">
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">Ingresar</button>

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

</body>

</html>
