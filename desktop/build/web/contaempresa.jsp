

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastro Efetuado</title>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://fonts.googleapis.com/css?family=Jaldi|Roboto" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=IM+Fell+French+Canon+SC" rel="stylesheet">
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/bootstrap.css">	
        <link rel="stylesheet" href="css/style.css">	


    </head>
    <body>   
        <div class="corpo container-fluid">
            <div class="row">  
                <div class="text-center col-lg-12">       
                    <div class="row">			
                        <div class="text-center col-lg-12">
                            <h1> Confirme seus dados</h1>

                        </div>            
                    </div>
                    <div class="row">
                        <div class="text-left col-lg-9">                          
                            <p class="estilo">Nome: &nbsp; <%= request.getParameter("nome")%> </p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="text-left col-lg-9">                        
                            <p class="estilo">Cnpj:&nbsp; <%= request.getParameter("cnpj")%> </p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="text-left  col-lg-9">
                            <p class="estilo">${id}</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="text-left  col-lg-9">
                            <p class="estilo">Telefone: &nbsp; <%= request.getParameter("telefone")%> </p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="text-left col-lg-9">
                            <p class="estilo">E-mail: &nbsp;  <%= request.getParameter("email")%> </p>
                        </div>
                    </div>                 
                    <div class="row"> 
                        <div class="text-left  col-lg-9">
                            <p Class="estilo">Rede Social: &nbsp;  <%= request.getParameter("cnpj")%> </p>
                        </div>
                    </div>
                    <div class="row"> 

                        <div class="text-center col-lg-06">

                            <a class="botao btn btn-primary" href="#" onclick="window.history.back();">Voltar</a>
                            <a class="botao btn btn-primary" href="empresa.html" >Editar</a>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="js/jquery-3.2.1.min.js"></script> 
    </body>
</html>
