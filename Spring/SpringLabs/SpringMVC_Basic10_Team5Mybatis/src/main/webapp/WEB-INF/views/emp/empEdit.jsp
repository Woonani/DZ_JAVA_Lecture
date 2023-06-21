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
				<h3>emp 수정페이지</h3>
				<form id="content-searchform" class="article-search-form" action="" method="post">
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
							<dd class="article-detail-data">
								<input type="text" name="ename" value="${emp.ename}" />
							</dd>
						</dl>
						<dl class="article-detail-row">
							<dt class="article-detail-title">직종</dt>
							<dd class="article-detail-data">
								<input type="text" name="job" value="${emp.job}" />
							</dd>
						</dl>
						<dl class="article-detail-row">
							<dt class="article-detail-title">연봉</dt>
							<dd class="article-detail-data">
								<input type="text" name="sal" value="${emp.sal}" />
							</dd>
						</dl>
						<dl class="article-detail-row">
							<dt class="article-detail-title">성과급</dt>
							<dd class="article-detail-data">
								<input type="text" name="comm" value="${emp.comm}" />
							</dd>
						</dl>
						<dl class="article-detail-row">
							<dt class="article-detail-title">매니저번호</dt>
							<dd class="article-detail-data">${emp.mgr}</dd>
						</dl>
						
						
						
					</div>
						
					<p > <button class="btn-save button" type="submit"  value="저장하기" ></button>
<!-- 						<a class="btn-save button"><input type="submit" value="저장하기" /></a> -->
						<a class="btn-cancel button" href="empDetail.do?empno=${emp.empno}"></a>
					</p>
				</form>
			</div>
			
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/inc/footer.jsp" />
</body>
</html>
