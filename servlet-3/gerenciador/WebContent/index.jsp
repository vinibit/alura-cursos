<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"></head>
<body>
	Bem vindo ao nosso gerenciador de empresas!
	<c:if test="${not empty usuarioLogado}">
    	<br />Você está logado como ${usuarioLogado.email}<br/>
	</c:if>
	<br />
	<form action="executa" method="post">
		<input type="hidden" name="tarefa" value="NovaEmpresa">
		Nome: <input type="text" name="nome" />
		<input type="submit"	value="Adicionar" />
	</form>
	<br />
	<form action="executa" method="post">
		<input type="hidden" name="tarefa" value="Login">
		Email: <input type="text" name="email" /><br /> 
		Senha: <input type="password" name="senha" /><br /> 
		<input type="submit" value="Login" />
	</form>
	<br />
	<form action="executa" method="post">
		<input type="hidden" name="tarefa" value="Logout"> 
		<input type="submit" value="Logout" />
	</form>

</body>
</html>