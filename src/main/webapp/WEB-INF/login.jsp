<a href="register">Create an account</a>

<h2>Login Page</h2>
<form action="login" method="POST">
	<label for="username">Username </label> <input type="text"
		id="username" name="username" required /><br> <br> <label
		for="password"> Password </label> <input type="text" id="password"
		name="password" required /><br />
	<br /> <input type="submit" value="sign in" />


</form>
<%
String msg = (String)request.getAttribute("login");
if(msg != null){
	out.print(msg);
}
%>


