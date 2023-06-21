<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>Form Example</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  </head>
</head>
<body>
	<div class="container">
		<div class="row text-center">
			<h2>사원 정보 입력</h2>
		</div>
		<div class="row justify-content-center">
			<div class="col-8">
				<form:form modelAttribute="formVO" method="post">
			        <table class="table">
			            <tr>
			                <td  class="col-4"><label for="empId">사원번호:</label></td>
			                <td  class="col-4"><form:input path="empId" id="empId"/></td>
			                <td  class="col-4"><form:errors path="empId" class="text-danger"/></td>
			            </tr>
			            <tr>
			                <td><label for="empName">이름:</label></td>
			                <td><form:input path="empName" id="empName" /></td>
			                <td><form:errors path="empName" class="text-danger"/></td>
			            </tr>
			            <tr>
			                <td><label for="phoneNumber">전화번호:</label></td>
			                <td><form:input path="phoneNumber" id="phoneNumber" /></td>
			                <td><form:errors path="phoneNumber" class="text-danger"/></td>
			            </tr>
			            <tr>
			                <td colspan="3"><input type="submit" value="저장" /></td>
			            </tr>
			        </table>
			    </form:form>
			</div>
		
		</div>
	</div>
    
    
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
