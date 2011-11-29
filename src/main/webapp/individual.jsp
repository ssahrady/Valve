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
        <title>JSP Page</title>
    </head>
    <body>
        <div class="topbar">
            <div class="fill">
	            <div class="container">
	                <a class="brand" href="/Valve">Vahtkond</a>
	                <form action="" class="pull-right">
				        <input class="input-small" type="text" placeholder="Username">
				        <input class="input-small" type="password" placeholder="Password">
				        <button class="btn" type="submit">Sign in</button>
				    </form>
	            </div>
            </div>
        </div>

        <div class="container">
            <div class="content">
            	<div class="page-header">
            		<h2>Piirvalvuri individuaalne töögraafik</h2>
            	</div>
				<div class="span14">
					<h1><small>Piirvalvur: Peeter Lump</small><a class="btn margin-left-20" href="#">Muuda</a></h1>
					<div class="row margin-left-0">
						<div class="input">
							<span>Alates</span>
							<input data-datepicker="datepicker" class="span2" type="text" name="alates"/>
						</div>
						<div class="input">
							<span>Kuni</span>
							<input data-datepicker="datepicker" class="span2" type="text" name="kuni"/>
						</div>
						
						<a href="#" class="btn margin-top-17">Värskenda</a>
					</div>
					<table>
						<tr>
							<th>#</th>
							<th>Piirkõik</th>
							<th>Vahtkond</th>
							<th>Algus</th>
							<th>Lõpp</th>
						</tr>
						<tr>
							<td>1</td>
							<td>Suvaline1</td>
							<td>Suvaline2</td>
							<td>20.11.11</td>
							<td>20.11.11</td>
						</tr>
						<tr>
							<td>2</td>
							<td>Suvaline2</td>
							<td>Suvaline3</td>
							<td>20.11.11</td>
							<td>20.11.11</td>
						</tr>
					</table>
					
					<div class="actions">
						<a href="" class="btn">Lisa</a>
						<a href="" class="btn success">Salvesta</a>
					</div>
				</div>
				<div class="clear"></div>
            </div>

            <footer>
                <p>&copy; Company 2011</p>
            </footer>

        </div> <!-- /container -->
    </body>
</html>
