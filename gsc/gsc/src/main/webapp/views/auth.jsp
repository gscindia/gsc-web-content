<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="../../asset/js/jquery-3.6.0-min.js"></script>
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<script src="../../asset/js/gsc-web.js"></script>
<link rel="stylesheet" href="../../asset/css/style.css" />

<meta charset="ISO-8859-1">
<title>Garalgacha Science Club</title>


</head>
<body>
	<nav>
		<div class="nav-wrapper">
			<a href="#!" class="brand-logo">Logo</a> <a href="#"
				data-target="mobile-demo" class="sidenav-trigger"><i
				class="material-icons">menu</i></a>
			<ul class="right hide-on-med-and-down">

				<li><a href="#">Sign out</a></li>
			</ul>
		</div>
	</nav>

	<ul class="sidenav" id="mobile-demo">

		<li><a href="#">Sign out</a></li>
	</ul>
	<main>
		<div class="container">
			<div class="row">
				<div>
					<h2>
						Do you know me <span class="material-icons"> login </span>
					</h2>

				</div>
			</div>
			<div class="row">
				<div class="col s8">
					<form id="loginform">
						<div class="row">
							<div class="input-field col s12">
								<i class="material-icons prefix">face</i> <input id="email"
									name="id" type="text" class="validate"> <label
									for="email">User</label>
							</div>
						</div>

						<div class="row">
							<div class="input-field col s12">
								<i class="material-icons prefix">password</i> <input
									id="password" name="password" type="password" class="validate">
								<label for="password">Password</label>
							</div>
						</div>
						<button class="btn waves-effect waves-light" id="auth-id"  type="button"
							name="action">
							Sign in <i class="material-icons right">fingerprint</i>
						</button>
					</form>
				</div>
			</div>
		</div>
	</main>
	<footer class="page-footer">
		<div class="container">
			<div class="row">
				<div class="col l6 s12">
					<h5 class="white-text">Footer Content</h5>
					<p class="grey-text text-lighten-4">You can use rows and
						columns here to organize your footer content.</p>
				</div>
				<div class="col l4 offset-l2 s12">
					<h5 class="white-text">Links</h5>
					<ul>
						<li><a class="grey-text text-lighten-3" href="#!">Link 1</a></li>
						<li><a class="grey-text text-lighten-3" href="#!">Link 2</a></li>
						<li><a class="grey-text text-lighten-3" href="#!">Link 3</a></li>
						<li><a class="grey-text text-lighten-3" href="#!">Link 4</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="footer-copyright">
			<div class="container">
				© 2022 Copyright Text <a class="grey-text text-lighten-4 right"
					href="#!">More Links</a>
			</div>
		</div>
	</footer>
</body>
</html>