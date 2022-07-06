<%@page import="org.springframework.ui.Model"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
        table,tr,td{
            text-align: center;
            align-content: center;
            justify-content: center;
            border: 1px solid black;
            width: 300px;
        }
        body{
            align-content: center;
            justify-content: center;    
            
        }
    </style>

<%
String code = ""+session.getAttribute("category_code");

String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "yebelo";
String userId = "root";
String password = "root";

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<h2 align="center"><font><strong>Category table</strong></font></h2>
    <center>
<table>
<tr>

</tr>
<tr bgcolor="yellow">
<td><b>CategoryCode</b></td>
<td><b>Value</b></td>
</tr>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM category";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr bgcolor="lavender">

<td><%=resultSet.getString("category_code") %></td>
<td><%=resultSet.getString("Value") %></td>
</tr>


<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
    
<br><br>	
    <a href="/"><button class="btn btn-info">Back to search</button></a>
    </center>   