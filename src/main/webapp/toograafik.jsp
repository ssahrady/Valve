<%@page import="java.util.Date"%>

<%@page import="javax.xml.ws.spi.http.HttpContext"%>
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
        <script src="js/bootstrap-modal.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
    	
        <div class="topbar">
            <div class="fill">
	            <div class="container">
	                <a class="brand" href="/Valve">Vahtkond</a>
	                <p class="pull-right">Logged in as <span class="username"><%= session.getAttribute("kasutaja") %></span></p>
	            </div>
            </div>
        </div>

        <div class="container">
            <div class="content">
            	<div class="page-header">
            		<h2>Töögraafiku redaktor</h2>
            		<h2><%= request.getAttribute("done") %></h2>
            	</div>
            	<form action="Main" method="post">
            	<input type="hidden" name="lisaToograafik" value="lisa"/>
				<div class="span14">
					<h1><small>Tekst</small></h1>
					<table>
						<tr>
							<th>#</th>
							<th>Piirlõik</th>
							<th>Kommentaar</th>
							<th>Algus</th>
							<th>Lõpp</th>
							<th class="w70"></th>
						</tr>
						<tr>
							<td>1</td>
							<td>Suvaline1</td>
							<td>Suvaline2</td>
							<td>20.11.11</td>
							<td>20.11.11</td>
							<td><a href="#muuta" class="pull-right btn">Muuda</a></td>
						</tr>
						<tr>
							<td>2</td>
							<td>Suvaline2</td>
							<td>Suvaline3</td>
							<td>20.11.11</td>
							<td>20.11.11</td>
							<td><a href="#muuta" class="pull-right btn">Muuda</a></td>
						</tr>
					</table>
					
					<div class="actions">
						<a href="" class="btn" data-controls-modal="lisaGraafik" data-backdrop="true" data-keyboard="true">Lisa</a>
						<a href="" class="btn success">Salvesta</a>
					</div>
				</div>
				<div class="clear"></div>
            </div>

			<div id="lisaGraafik" class="modal hide fade">
				<div class="modal-header">
					<a href="#" class="close">&times;</a>
					<h3>Lisa töögraafik</h3>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="span2">
							<span>Piirlõik:</span>
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
					<div class="actions">
						<a id="submitToograafik" href="#" class="btn">Lisa</a>
						<a href="" class="btn success" data-controls-modal="lisaToograafik" data-backdrop="true" data-keyboard="true">Lisa</a>
					</div>
			</div>

            <footer>
                <p>&copy; Company 2011</p>
            </footer>

        </div> <!-- /container -->
    </body>
</html>
