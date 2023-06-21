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
					<a class="btn-list button" href="empReg.do">emp 등록</a>
					<form id="content-searchform" class="article-search-form" action="" method="post">
						<fieldset>
							<legend class="hidden">
								목록 검색 폼
							</legend>
							<input type="hidden" name="pg" value="" />
							<label for="f"
							class="hidden">검색필드</label>
							<select name="f">
								<option value="TITLE">이름</option>
								<option value="CONTENT">사번</option>
							</select>
							<label class="hidden" for="q">검색어</label>
							<input type="text"
							name="qname" value="" />
							<input type="submit" value="검색" />
						</fieldset>
					</form>
					
					<table class="article-list margin-small">
						<caption class="hidden">
							공지사항
						</caption>
						<thead>
							<tr>
								<th class="empno">사번</th>
								<th class="ename">이름</th>
								<th class="job">직업</th>
								<th class="mgr">매니저번호</th>
								<th class="hiredate">입사일</th>
								<th class="sal">연봉</th>
								<th class="comm">커미션</th>
								<th class="deptno">부서번호</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach  var="n" items="${list}" >
							<tr>
								<td class=""><a href="empDetail.do?empno=${n.empno}">${n.empno}</a></td>
								<td class="">${n.ename}</td>
								<td class="">${n.job}</td>
								<td class="">${n.mgr}</td>
								<td class="">${n.hiredate}</td>
								<td class="">${n.sal}</td>
								<td class="">${n.comm}</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
					
				</div>
			</div>
		</div>
	</body>
</html>
