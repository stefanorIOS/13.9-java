<%@page import="entities.Empleado"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="style/reset.css">
    <link rel="stylesheet" href="style/header.css">
    <link rel="stylesheet" href="style/updateEmpleado.css">
    <script src="https://kit.fontawesome.com/b95dc486b7.js" crossorigin="anonymous"></script>
    <title>Foodtruck</title>
    
    <% Empleado e = (Empleado) request.getAttribute("emp");%>
</head>
<body>
 <jsp:include page="header.jsp"/>

    <div class="form" >
        <form action="empleadoeditar?dni=<%=e.getDni()%>" method="post">
            <div class="form__container">
                <h1>Modificar Empleado</h1>
                <div class="form__item">
                    <label>DNI</label>
                    <input name="dni" type="text" maxlength="8" value=<%=e.getDni() %>>
                </div>
                <div class="form__item">
                    <label>Nombre</label>
                    <input name="nombre" type="text" value="<%=e.getNombre()%>">
                </div>
                <div class="form__item">
                    <label>Turno</label>
                    <select name="turno">
                    	<option value="none" selected disabled hidden>Select an Option</option>
                        <option value="Tarde">Tarde</option>
                        <option value="Noche">Noche</option>
                    </select>
                </div>
                
                 <div class="form__item">
                    <label>Rol</label>
                    <select name="rol">
						<option value="Chef">Chef</option>
                        <option value="Delivery">Delivery</option>
                        <option value="Mozo">Mozo</option>
                    </select>
                </div>
                
                <div class="form__item">
                    <label>Contraseña</label>
                    <input name="password">
                </div>
                <button class="button" type="submit">Modificar</button>	
            </div>      
        </form>
    </div>
</div>
    
</body>
</html>