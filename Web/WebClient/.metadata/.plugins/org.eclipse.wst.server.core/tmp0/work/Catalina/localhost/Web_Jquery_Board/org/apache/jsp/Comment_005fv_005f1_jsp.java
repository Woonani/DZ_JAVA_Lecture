/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.74
 * Generated at: 2023-06-05 07:09:50 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.jquery.ajax.comment.CommentDAO;
import com.jquery.ajax.comment.CommentVO;
import java.util.List;

public final class Comment_005fv_005f1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.jquery.ajax.comment.CommentDAO");
    _jspx_imports_classes.add("com.jquery.ajax.comment.CommentVO");
    _jspx_imports_classes.add("java.util.List");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	//글번호 
	int bbsSeq = 1;
	CommentDAO dao = CommentDAO.getInstance();
	List<CommentVO> commentlist = dao.getCommentList(bbsSeq);

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("	<title>CommentLIST</title>\r\n");
      out.write("	<script src=\"//code.jquery.com/jquery-1.11.0.min.js\"></script>\r\n");
      out.write("	<script type=\"text/javascript\">\r\n");
      out.write("		$(function(){\r\n");
      out.write("			$('#addBtn').on(\"click\",function(){\r\n");
      out.write("				if($.trim($('#comment').val()) == \"\")\r\n");
      out.write("				{\r\n");
      out.write("					alert(\"덧글을 입력하세여\");\r\n");
      out.write("					$('#comment').focus();\r\n");
      out.write("					return false;\r\n");
      out.write("				}\r\n");
      out.write("				\r\n");
      out.write("				//1. 조합문자열\r\n");
      out.write("				//bbs.jsp?name=kglim&age=10\r\n");
      out.write("				var data = \"bbsSeq=");
      out.print(bbsSeq);
      out.write("\";\r\n");
      out.write("				data += \"&comment=\" + $.trim($('#comment').val());\r\n");
      out.write("				//bbsSeq=1&comment=안녕하세요\r\n");
      out.write("				\r\n");
      out.write("				//2. javaScript 객체형태로\r\n");
      out.write("				//{bbSeq : 1 , comment:'안녕하세요'}\r\n");
      out.write("				var data2 = {\r\n");
      out.write("						      bbsSeq  : \"");
      out.print( bbsSeq );
      out.write("\" ,\r\n");
      out.write("						      comment : $.trim($('#comment').val())  \r\n");
      out.write("						\r\n");
      out.write("				            };\r\n");
      out.write("				//url  : 요청할 주소(insertboard.do , insert.action , insert.jsp)\r\n");
      out.write("				//type : 전송방식(GET ,POST)\r\n");
      out.write("				//data : 서버로 전송할 데이터 (조합 문자열 또는 javaScript 객체 형태)\r\n");
      out.write("				//dataType : 서버로 부터 받을 TYPE(XML , HTML , JSON , SCRIPT, TEXT)\r\n");
      out.write("				//timeout : 요청의 시간의 제한\r\n");
      out.write("				//async : 비동기 , 동기 (default : true > 비동기)\r\n");
      out.write("				//beforeSend : 요청이 전송되기전에 앞서 호출될 수 있는 함수 구현\r\n");
      out.write("				//success : 응답 성공시 호출될 함수 (데이터 받아서 처리) > $.each(data,function(){}) ....\r\n");
      out.write("				//error : 응답 에러시 호출된 함수\r\n");
      out.write("				//complete : seccess , error 처리가 끝난수 마지막에 호출되는 함수\r\n");
      out.write("				$.ajax(\r\n");
      out.write("						{\r\n");
      out.write("							url : \"CommentAdd_v_1.jsp\",  //페이지 주소 수정 _1\r\n");
      out.write("							dataType : \"JSON\",           //dataType 수정_2\r\n");
      out.write("							async : true ,\r\n");
      out.write("							type : \"POST\",\r\n");
      out.write("							data : data2 ,\r\n");
      out.write("							success : function(data)\r\n");
      out.write("							{\r\n");
      out.write("							    //위 에서 만약 success : function() { this.seq ....  }	\r\n");
      out.write("								//selector 를 사용하여 연습하기\r\n");
      out.write("								$('#container').find(\"table tr\").not(\":first\").remove();\r\n");
      out.write("								\r\n");
      out.write("								$.each(data, function(){\r\n");
      out.write("									//console.log(this);\r\n");
      out.write("									$('#container').find(\"table tr:last\").after(\r\n");
      out.write("										\"<tr>\"\r\n");
      out.write("										+ \" <td>\" + this.seq + \"</td>\"\r\n");
      out.write("										+ \" <td>\" + this.comment + \"</td>\"\r\n");
      out.write("										+ \" <td>삭제</td>\"\r\n");
      out.write("										+ \"</tr>\"\r\n");
      out.write("									);\r\n");
      out.write("								});\r\n");
      out.write("								$('#comment').val();\r\n");
      out.write("								/*  \r\n");
      out.write("									$.each(data,function(index,entry){\r\n");
      out.write("									  $('#tbllist').append(\r\n");
      out.write("										\"<tr><td>\" + entry.seq + \"</td><td>\" + entry.comment+ \"</td></tr>\"\r\n");
      out.write("									  );\r\n");
      out.write("									  \r\n");
      out.write("								    });\r\n");
      out.write("								*/\r\n");
      out.write("							}\r\n");
      out.write("						}	\r\n");
      out.write("				      );\r\n");
      out.write("\r\n");
      out.write("			});\r\n");
      out.write("			\r\n");
      out.write("		});\r\n");
      out.write("	\r\n");
      out.write("	</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<table width=\"700px\" border=\"1\">\r\n");
      out.write("		<tr>\r\n");
      out.write("			<th width=\"200px\">번호</th>	\r\n");
      out.write("			<td>");
      out.print(bbsSeq);
      out.write("</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		<tr>\r\n");
      out.write("			<th width=\"200px\">제목</th>	\r\n");
      out.write("			<td>Jquery 넘 재미있어요</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		<tr>\r\n");
      out.write("			<th width=\"200px\">내용</th>	\r\n");
      out.write("			<td>당황하지 않고 Jquery 보면...</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("	</table>\r\n");
      out.write("	<br>\r\n");
      out.write("	<!-- 덧글 입력  -->\r\n");
      out.write("	<div>\r\n");
      out.write("		<input type=\"text\" name=\"comment\" id=\"comment\" style=\"width: 600px;\" placeholder=\"덧글을 입력하세요\"> \r\n");
      out.write("		<button id=\"addBtn\">덧글등록</button>\r\n");
      out.write("		<br>\r\n");
      out.write("		<div id=\"container\">\r\n");
      out.write("			<table border=\"1\">\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>순번</td>\r\n");
      out.write("					<td>내용</td>\r\n");
      out.write("					<td>삭제</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				");

					for(int k = 0 ; k < commentlist.size() ; k++){
						CommentVO vo = commentlist.get(k);
				
      out.write("		\r\n");
      out.write("						<tr>\r\n");
      out.write("							<td>");
      out.print( vo.getSeq() );
      out.write("</td>\r\n");
      out.write("							<td>");
      out.print( vo.getComment() );
      out.write("</td>\r\n");
      out.write("							<td></td>\r\n");
      out.write("						</tr>		\r\n");
      out.write("				");
		
					}				
				
      out.write("\r\n");
      out.write("			</table>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	<hr>\r\n");
      out.write("	<table id=\"tbllist\" border=\"1\">\r\n");
      out.write("	</table>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}