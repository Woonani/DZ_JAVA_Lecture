<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="" method="post">
		<label for="empno">EMPNO:</label> <input type="number" id="empno"
			name="empno" required> <br> <label for="ename">ENAME:</label>
		<input type="text" id="ename" name="ename"> <br> <label
			for="job">JOB:</label> <input type="text" id="job" name="job">
		<br> <label for="mgr">MGR:</label> <input type="number" id="mgr"
			name="mgr"> <br>  
			<label for="sal">SAL:</label> <input type="number" id="sal" name="sal">
		<br> <label for="comm">COMM:</label> <input type="number"
			id="comm" name="comm"> <br> <label for="deptno">DEPTNO:</label>
		<input type="number" id="deptno" name="deptno"> <br>
		
		<input type ="submit" value="생성">
		
	</form>


</body>
</html>