<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
	@ SuppressWarnings("unchecked")
	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");


/* for (int i = 0; i < lista.size(); i++){
	out.println(lista.get(i).getId());
	out.println(lista.get(i).getNome());
	out.println(lista.get(i).getTelefone());
	out.println(lista.get(i).getEmail());
}
 */
 %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Agenda de Contatos</title>
<link rel="icon" href="imagens/agenda.png">
<link rel="stylesheet" href="style.css">
<script src="scripts/confirmador.js"></script>
</head>
<body>
	<h2><a class="titAgenda" href="index.html">Agenda de contatos</a></h2>
	<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Telefone</th>
				<th>Email</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%for (int i = 0; i < lista.size(); i++) { %>
				<tr>
					<td><%=lista.get(i).getId()%></td>
					<td><%=lista.get(i).getNome()%></td>
					<td><%=lista.get(i).getTelefone()%></td>
					<td><%=lista.get(i).getEmail()%></td>
					<td><a href="select?id=<%=lista.get(i).getId()%>" class="botao1">Editar</a>
					<a href="javascript: confirmar(<%=lista.get(i).getId()%>)" class="botao2" >Excluir</a>
					</td>
				</tr>	
			<%} %>
		</tbody>
	</table>
	<a href="novo.html" class="botaoNovoContato">Novo Contato</a>
	<a href="report" class="botao2">Relatório</a>
</body>
</html>