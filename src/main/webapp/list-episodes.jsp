<%@ page import="java.util.* , com.anushka.web.jdbc.*"  %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<head>
<title>Rate your personal favourite </title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>


<%
		
			List<Episode>episodes = (List<Episode>)  request.getAttribute("EPISODE_LIST");

%>
<body style="background-color:#9933CC; margin-top: 20px;">


<div class="container"   >
			
			<div id = "content">
			
			<table  class="table table-primary table-striped">
			
			<tr>
							<th>Episode Number</th>
						    <th>Season Number</th>
						    <th>Episode Name</th>
						    <th>Rating</th>
			</tr>
			
			<%  for(Episode temp : episodes) { %>
			
			<tr>
					<td><%=     temp.getEpnum()  %></td>
					<td><%=     temp.getSeason()   %></td>
					<td><%=     temp.getEpname() %></td>
					<td><%=     temp.getRating() %></td>
			</tr>
			
			
			
			<% } %>
			
			</table>
			</div>
</div>

</body>
  <!-- Footer -->
<footer class="page-footer font-small blue">

  <!-- Copyright -->
  <div class="footer-copyright text-center py-3" style="background-color:#aa66cc;">Rate your favourite F.R.I.E.N.D.S. episodes
  </div>
  <!-- Copyright -->

</footer>
<!-- Footer -->
</html>