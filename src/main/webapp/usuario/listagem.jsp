<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Página de listagem</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<style>
        *{
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        
        #logout{
            padding: 1px;
            margin-top: 20px;
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
        
        .modal_classe{
            width: 100vw;
            height: 100vh;
            background-color: rgba(0, 0, 0, 0.555);
            position: fixed;
            top: 0px;
            left: 0px;
            z-index: 2000;
            display: none;
            justify-content: center;
            align-items: center;
        }

        .modal_classe.mostrar{
            display: flex;
        }

        .modal_legal{
            padding: 30px;
            width: 400px;
            min-width: 300px; 
            box-shadow: 0px 0px 15px rgb(68, 68, 68);
            border-radius: 5px;
            background-color: white;
            position: relative;
        }

        @keyframes modal {
            from{
              opacity: 0;
              transform: translate3d(0, 60px, 0);
            }
            to{
              opacity: 1;
              transform: translate3d(0, 0, 0);
            }
        }

        .mostrar .modal_legal{
            animation: modal .3s;
        }

        .fechar{
            position: absolute;
            top: 12px;
            right: 12px;
            width: 20px;
            background: white;
            cursor: pointer;
            border: 4px solid white
        }
        
    </style>
</head>
<body>

<%

String email = (String) session.getAttribute("email");

if(email == null) {
	response.sendRedirect("../index.jsp");
	
}

%>

<div class="container my-4" style="max-width: 850px;">
	<h1 class="display-4" style="text-align: center; margin-top: 18px;">Matérias Cadastradas</h1>
	<br>

	<div id="logout">
	    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">Adicionar</button>
	    <button type="button" class="btn btn-primary" onclick="notificar()" >Notificar</button>
	    
        <a id="edit" class="btn tooltip-test" title="Editar Usuario" style="margin-left: 66%;" href="editarUsuario?nome=${usuario.nome}">Editar</a>
       
		<a href="usuario/deslogar.jsp" id="des" class="btn btn-secondary" style="margin-left: 2%; ">Deslogar</a>
	</div>

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
<hr>
	
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
		<a href="index.jsp" id="bot_bot" class="btn btn-secondary">Voltar</a>
	</div>
</div>

<script>

//funcao pra testar notificação
function showNotification(){
    
    const notification = new Notification("Notificação !", {
        body:"Voce tem atividades pendentes !"
    })
}

function notificar(){
	if(Notification.permission === "granted"){
    showNotification()
  }else if(Notification.permission !== "denied"){
    Notification.requestPermission().then(permission => {
        if(permission === "granted"){
            showNotification()
        }
    });

  }
}



function setaDadosModal(valor) {
	
	document.getElementById('nome-materia').innerHTML = 'Tem certeza que deseja excluir ' + '"' + valor + '"' + ' ?';
	document.getElementById('campo').value = valor;
}
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>           		
</body>
</html>