<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


			<c:forEach  var="n" items="${emp}">
							<tr>
								<td class="empno">${n.empno}</a></td>
								<td class="ename">${n.ename}</td>
								<td class="job">${n.job}</td>
								<td class="mgr">${n.mgr}</td>
								<td class="hiredate">${n.hiredate}</td>
								<td class="sal">${n.sal}</td>
								<td class="comm">${n.comm}</td>
								<td class="deptno">${n.deptno}</td>
							</tr>
				</c:forEach>



	<form action="/updateEmployee" method="post">
		<label for="empno">EMPNO:</label> <input type="text" id="empno"
			name="empno" readonly><br>
		<br> <label for="ename">ENAME:</label> <input type="text"
			id="ename" name="ename"><br>
		<br> <label for="job">JOB:</label> <input type="text" id="job"
			name="job"><br>
		<br> <label for="mgr">MGR:</label> <input type="text" id="mgr"
			name="mgr"><br>
		<br> <label for="hiredate">HIREDATE:</label> <input type="text"
			id="hiredate" name="hiredate" readonly><br>
		<br> <label for="sal">SAL:</label> <input type="text" id="sal"
			name="sal"><br>
		<br> <label for="comm">COMM:</label> <input type="text" id="comm"
			name="comm"><br>
		<br> <label for="deptno">DEPTNO:</label> <input type="text"
			id="deptno" name="deptno"><br>
		<br> <input type="submit" value="수정">
	</form>
</body>
</html>