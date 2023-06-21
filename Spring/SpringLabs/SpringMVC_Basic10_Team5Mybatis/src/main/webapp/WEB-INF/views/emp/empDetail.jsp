<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>index</title>
<link href="../css/customer.css" type="text/css" rel="stylesheet" />
</head>
<body>
	
	<div id="main">
		<div class="top-wrapper clear">
			<div id="content">
				<h3>emp상세페이지</h3>
				<div id="notice-article-detail" class="article-detail margin-large">
					<dl class="article-detail-row">
						<dt class="article-detail-title">사번</dt>
						<dd class="article-detail-data">${emp.empno}</dd>
					</dl>
					<dl class="article-detail-row">
						<dt class="article-detail-title">입사일</dt>
						<dd class="article-detail-data">${emp.hiredate}</dd>
					</dl>
					<dl class="article-detail-row">
						<dt class="article-detail-title">사원</dt>
						<dd class="article-detail-data">${emp.ename}</dd>
					</dl>
					<dl class="article-detail-row">
						<dt class="article-detail-title">직종</dt>
						<dd class="article-detail-data">${emp.job}</dd>
					</dl>
					<dl class="article-detail-row">
						<dt class="article-detail-title">연봉</dt>
						<dd class="article-detail-data">${emp.sal}</dd>
					</dl>
					<dl class="article-detail-row">
						<dt class="article-detail-title">성과급</dt>
						<dd class="article-detail-data">${emp.comm}</dd>
					</dl>
					<dl class="article-detail-row">
						<dt class="article-detail-title">매니저번호</dt>
						<dd class="article-detail-data">${emp.mgr}</dd>
					</dl>
					
					
					
				</div>
				<p class="article-comment margin-small">
					<a class="btn-list button" href="list.do?pg">목록</a> 
					<a class="btn-edit button" href="empEdit.do?empno=${emp.empno}">수정</a>
					<a class="btn-del button" href="empDel.do?empno=${emp.empno}">삭제</a>
				</p>
				
			</div>
			
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/inc/footer.jsp" />
</body>
</html>
