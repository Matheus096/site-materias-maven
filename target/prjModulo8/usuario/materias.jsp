<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Página de listagem</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<style>
        *{
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        #tab{
            margin-top: 50px;
            margin: auto;
            max-width: 85vw;
        }

        #tab tr:hover{
            background: rgb(207, 206, 206);
        }
        
        #bot{
            width: 100px;
            margin-top: 25px;
            margin-left: auto;
            margin-right: auto;
        }
        
        #bot_bot{
            width: 100px;
        }
        
        #delete{
            background-color: rgb(255, 111, 111);
        }
        
        #edit{
            background-color: rgb(219, 219, 68);
        }
        
        #delete:hover{
             background-color: rgb(204, 56, 56);
        }
        
        #edit:hover{
             background-color: rgb(206, 172, 61);
        }
        
    </style>
</head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<body>

<%

String email = (String) session.getAttribute("email");

if(email == null) {
	response.sendRedirect("../index.jsp");
	
}

%>

<c:url value="prjModulo8/index.jsp" var="index"></c:url>

<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">Adicionar</button>

<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Matérias</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form id="form-adicionar" action="enviar">
          <div class="mb-3">
            <label for="recipient-name" class="col-form-label">Titulo</label>
            <input type="text" class="form-control" id="recipient-name" name="titulo">
          </div>
          <div class="mb-3">
            <label for="message-text" class="col-form-label">Descrição</label>
            <textarea name="descricao" class="form-control" id="message-text"></textarea>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="submit" form="form-adicionar" class="btn btn-primary">Salvar</button>
      </div>
    </div>
  </div>
</div>

<div class="container my-4" style="max-width: 850px;">
	<h1 class="display-4" style="text-align: center; margin-top: 18px;">Usuarios Cadastrados</h1>
	<br>
	<div id="table_bx">
   <table class="table table-bordered" id="tab">
       <thead class="table-dark">
         <tr>
           <th scope="col">Matéria</th>
           <th scope="col">Descrição</th>
           <th scope="col">ID</th>
           <th scope="col"></th>
         </tr>
       </thead>
       <tbody>
          <c:forEach varStatus="contagem" items="${materias}" var="materia">
                <tr>
                  <td>${materia.titulo}</td>
                  <td>${materia.descricao}</td>
                  <td>${materia.id}</td>
                <td>
                  	<div class="container">
                  		<div class="row">
                  			<div class="col-md-6 p-0">
                  				<a id="edit" class="btn tooltip-test" title="Editar Matéria" href="editar?id=${materia.id}"><i class="bi bi-pencil-square"></i></a>
                  			</div>
                  			<div class="col-md-6 p-0" >
                  			    
           
                  			      
								   <a type="submit" id="delete" onclick="setaDadosModal('${materia.titulo}')" data-bs-toggle="modal" data-bs-target="#staticBackdrop" title="Excluir Matéria" class="btn delete tooltip-test">
								     <i class="bi bi-trash"></i>
								   </a>
                  			    
                  			    
								
								<!-- Modal -->
								
							
								<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
								  <div class="modal-dialog modal-dialog-centered">
								    <div class="modal-content">
								      <div class="modal-header">
								        <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
								        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
								      </div>
								      <div class="modal-body">
								        <p id="nome-materia">Tem certeza que deseja excluir  ?</p>
								      </div>
								      <div class="modal-footer">
								        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
								        <button type="submit" form="deletof${contagem.index}" class="btn btn-primary">Excluir</button>
								        
								        <form action="deletar">
								            <input class="d-none" type="text" name="titulo" id="campo">
								            <button type="submit" class="btn btn-primary">Excluir</button>
								        </form>
								        
								        
								      </div>
								    </div>
								  </div>
								</div>
							
								
                  			</div>
                  		</div>
                  	</div>
                  </td>
                </tr> 
      </c:forEach>
      </tbody>
    </table>
    </div>
	<div id="bot">
		<a href="../index.jsp" id="bot_bot" class="btn btn-secondary">Voltar</a>
	</div>
	<div id="logout">
		<a href="deslogar.jsp" id="des" class="btn btn-secondary">Deslogar</a>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
</body>
</html>