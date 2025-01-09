<%@page import="java.util.List"%>
<%@page import="com.example.Entity.Player"%>
<form action="deleteplayer" method="post">

	<%
	List<Player> players = (List<Player>) request.getAttribute("players");
	%>
	<table border="1">
		<tr>
			<th>Select</th>
			<th>Player Id</th>
			<th>Player Name</th>
			<th>Player Age</th>
			<th>Player Team Name</th>
		</tr>
		<%
		// Assuming you have a List<Player> named 'players' retrieved from the database
		for (Player player : players) {
		%>
		<tr>
			<td><input type="radio" name="id" value="${player.getPid() }" /></td>
			<td><%=player.getPid()%></td>
			<td><%=player.getPlayerName()%></td>
			<td><%=player.getPlayerAge()%></td>
			<td><%=player.getTeamName()%></td>

		</tr>
		<%
		}
		%>
	</table>
	<br /> <input type="submit" value=" Delete selected player">
	<button type="button" style="padding: 03px 10px"
		onclick="window.location.href = 'player';">Cancel</button>
</form>