<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bài tập</title>
</head>

<body>
<h1><%= request.getContextPath() %></h1>
	<%-- Bài tập: Hãy in ra màn hình 10 số đầu tiên của dãy Fibonacci --%>
	<%-- 0 1 1 2 3 5 8 13 21 34 --%>
	<%! int[] num = new int[10]; %>
	
	<% 
	num[0] = 0;
	num[1] = 1;
	
	for(int i = 2; i < num.length; i++){ 
		num[i] = num[i-1] + num[i - 2];
	}
	%>

	<% for(int i = 0; i < num.length; i++){ %> 
		<span><%=num[i]%></span>
	<% } %>


</body>
</html>