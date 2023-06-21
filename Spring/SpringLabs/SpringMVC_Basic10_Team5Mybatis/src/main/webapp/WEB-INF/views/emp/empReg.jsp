<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>index</title>
		<link href="notice.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<div id="main">
			<div class="top-wrapper clear">
				<div id="content">
					<h3><a href=${pageContext.request.contextPath}> 임시 main을 가기 </a></h3>
					<h3>emp 추가 페이지</h3>
					<form id="content-searchform" class="article-search-form" action="" method="post">
						<fieldset>
							<legend class="hidden"> emp 등록 폼 </legend>
							
							<label class="hidden" for="q">EMPNO</label>
							<input type="text" name="empno" value="" /> <br />
							<label class="hidden" for="q">ENAME</label>
							<input type="text" name="ename" value="" /> <br />
							<label class="hidden" for="q">JOB</label>
							<input type="text" name="job" value="" /> <br />
							<label class="hidden" for="q">MGR</label>
							<input type="text" name="mgr" value="" /> <br />
							<!-- <label class="hidden" for="q">HIREDATE</label>
							<input type="text" name="hiredate" value="" /> <br /> -->
							<label class="hidden" for="q">SAL</label>
							<input type="text" name="sal" value="" /> <br />
							<label class="hidden" for="q">COMM</label>
							<input type="text" name="comm" value="" /> <br />
							<label class="hidden" for="q">DEPTNO</label>
							<input type="text" name="deptno" value="" /> <br />
							<label class="hidden" for="q">FILENAME</label>
							<input type="text" name="filename" value="" /> <br />
							
							
							<input type="submit" value="등록" />
						</fieldset>
					</form>
					
					
					
				</div>
			</div>
		</div>
	</body>
</html>
