<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style/reset.css">
    <link rel="stylesheet" href="style/header.css">
    <link rel="stylesheet" href="style/altaPlato.css">
    <title>Foodtruck</title>
</head>
<body>
   <jsp:include page="header.jsp"/>
	<div class="form">
        <form action="busquedaCliente" method="GET" >
            <div class="form__container">
                <h1>Buscar Cliente </h1>
                
                <div class="form__item">
                    <label>Nombre</label>
                    <input name="nombre">
                </div>
                  
            
                 <div class="form__item">
                    <label>Documento</label>
                    <input name="dni">
                </div>
                
                <div class="form__item">
                    <label>direccion</label>
                    <input name="direccion">
                </div>
              
                 <button class="button" type="submit">Buscar</button>
               </div>
        </form>
        
    </div>
    
</body>
</html>