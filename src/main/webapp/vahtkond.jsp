<%@page import="org.hsqldb.lib.Iterator"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Styles -->
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <!-- Scripts -->
        <script src="js/jquery-1.7.1.min.js" type="text/javascript"></script>
        <script src="js/bootstrap-datepicker.js"></script>
        <script src="js/bootstrap-modal.js"></script>
        <script src="js/bootstrap-alerts.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
		<% 
			ResultSet rs = (ResultSet)request.getAttribute("rs");
		%>		
        <div class="topbar">
            <div class="fill">
	            <div class="container">
	                <a class="brand" href="/Valve/Main">Vahtkond</a>
	                <form action="Main" class="pull-right" method="post">
	                	<button class="btn" name="logout" type="submit">Log out</button>
				    </form>
				    <p class="pull-right">Logged in as <span class="username"><%= session.getAttribute("kasutaja") %></span></p>	                
	            </div>
            </div>
        </div>

        <div class="container">
            <div class="content">
            	<div class="page-header">
            		<h2>Vahtkonna redaktor</h2>
            		<h2><%= request.getAttribute("done") %></h2>
            	</div>
            	<form action="Main" method="post" id="vahtkondSubmit">
            	<input type="hidden" name="lisaVahtkond" value="lisa"/>
				<div class="span14">
					<div class="span7">
						<div class="row">
							<div class="span2">
								<span>Kood:</span>
							</div>
							<div class="span5">
								<input type="text" name="kood"/>
							</div>
						</div>
						
						<div class="row">
							<div class="span2">
								<span>Nimetus:</span>
							</div>
							<div class="span5">
								<input type="text" name="nimetus"/>
							</div>
						</div>
						
						<div class="row">
							<div class="span2">
								<span>Piiripunkt:</span>
							</div>
							<div class="span5">
								<select name="piiripunkt">
									<% 
									while( rs.next() ){
									%>
									<option value="<%= rs.getString("PIIRIPUNKT_ID") %>"><%= rs.getString("NIMETUS") %></option>
									<%
									}
									%>
								</select>
							</div>
						</div>
						
						<div class="row">
							<div class="span2">
								<span>Alates:</span>
							</div>
							<div class="span5">
								<input type="text" data-datepicker="datepicker" name="alates"/>
							</div>
						</div>
						
						<div class="row">
							<div class="span2">
								<span>Kuni:</span>
							</div>
							<div class="span5">
								<input type="text" data-datepicker="datepicker" name="kuni"/>
							</div>
						</div>
					</div>
					
					<div class="span7">
						<div class="row">
							<div class="span2">
								<span>Kommentaar:</span>
							</div>
							<div class="span5">
								<textarea name="kommentaar"></textarea>
							</div>
						</div>
						<a href="Toograafik.java" class="btn pull-right actions">Töögraafik</a>
					</div>
					</form>
					<table class="margin-top-17">
						<tr>
							<th>Piirvalvurid</th>
							<th>Alates</th>
							<th>Kuni</th>
							<th>Kommentaar</th>
						</tr>
						<tr>
							<td>Suvaline1</td>
							<td>20.11.11</td>
							<td>20.11.11</td>
							<td>Kommentaaaar<a href="#muuta" class="pull-right btn">Muuda</a></td>
						</tr>
						<tr>
							<td>Suvaline2</td>
							<td>20.11.11</td>
							<td>20.11.11</td>
							<td>Kommentaaar<a href="#muuta" class="pull-right btn">Muuda</a></td>
						</tr>
					</table>
					
					<div class="actions">
						<a id="submitVahtkond" href="#" class="btn">Lisa</a>
						<a href="" class="btn success" data-controls-modal="lisaVahtkond" data-backdrop="true" data-keyboard="true">Salvesta</a>
					</div>
				</div>
				<div class="clear"></div>
            </div>


			<div id="lisaVahtkond" class="modal hide fade">
				<div class="modal-header">
					<a href="#" class="close">&times;</a>
					<h3>Lisa vahtkond</h3>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="span2">
							<span>Piirvalvur:</span>
						</div>
						<div class="span5">
							<input type="text" name="kood"/>
						</div>
					</div>
					
					<div class="row">
						<div class="span2">
							<span>Alates:</span>
						</div>
						<div class="span5">
							<input type="text" data-datepicker="datepicker" name="alates"/>
						</div>
					</div>
					
					<div class="row">
						<div class="span2">
							<span>Kuni:</span>
						</div>
						<div class="span5">
							<input type="text" data-datepicker="datepicker" name="kuni"/>
						</div>
					</div>
					
					<div class="row">
						<div class="span2">
							<span>Kommentaar:</span>
						</div>
						<div class="span5">
							<textarea name="kommentaar"></textarea>
						</div>
					</div>
				
				</div>
				<div class="modal-footer">
				  <a href="#" class="btn primary">Lisa</a>
				</div>
			</div>
			

            <footer>
                <p>&copy; Company 2011</p>
            </footer>

        </div> <!-- /container -->		
        
    </body>
    
    <script type="text/javascript">
	    $("#submitVahtkond").click(function() {
	    	var isError = false;
	        $("#vahtkondSubmit").find("input, select, textarea").each(function() {
		        if($(this).text() == "" && $(this).val() == "") {
		        	$(".page-header").after('<div data-alert="alert" class="alert-message error fade in"><a href="#" class="close">×</a><p><strong>Holy guacamole!</strong> Every field must be filled.</p></div>');
		        	isError = true;
		            return false;
		        }
	        });
	        if(isError == false)
	        	$("#vahtkondSubmit").submit();
	    });
    </script>
</html>
