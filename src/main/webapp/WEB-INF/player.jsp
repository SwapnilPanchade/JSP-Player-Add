<%@page import="com.example.Entity.Player"%>
<%@page import="java.util.List"%>
<h1>This is the Players Page we will perform players related
	operations here</h1>
<br/>
<a href ="addplayer">Add New Player</a>
<%
List<Player> players = (List) request.getAttribute("players");
%>
<table border="1" >
    <tr>
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
        <td><%= player.getPid() %></td>
        <td><%= player.getPlayerName() %></td>
        <td><%= player.getPlayerAge() %></td>
        <td><%= player.getTeamName() %></td>
    </tr>
    <%
        }
    %>
</table>
