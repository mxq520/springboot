<html>
	<head>
		<title></title>
		<meta charset="utf-8"></meta>
	</head>

	<body>
		<table align="center" border="1" width="50%">
			<tr>
				<th>id</th>
				<th>name</th>
				<th>age</th>
			</tr>
			<#list list as user>
				<tr>
					<td>${user.userid}</td>
					<td>${user.username}</td>
					<td>${user.userage}</td>
				</tr>
			</#list>
		</table>
	</body>
</html>