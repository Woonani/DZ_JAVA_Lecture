/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.74
 * Generated at: 2023-06-05 06:43:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class CommentEdit_005fv_005f4_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = null;
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("	<title>Insert title here</title>\r\n");
      out.write("	<style type=\"text/css\">\r\n");
      out.write("		.over {cursor:pointer;}\r\n");
      out.write("	</style>\r\n");
      out.write("	<script src=\"//code.jquery.com/jquery-1.11.0.min.js\"></script>\r\n");
      out.write("	<script type=\"text/javascript\">\r\n");
      out.write("		$(function(){\r\n");
      out.write("			//순서를 보장하는 형태의 꽁수 ....\r\n");
      out.write("			//promise 패턴 사용 (권장) \r\n");
      out.write("			GetBoardList();\r\n");
      out.write("			RowUpdateBoard();\r\n");
      out.write("		});\r\n");
      out.write("	\r\n");
      out.write("		function RowUpdateBoard(){\r\n");
      out.write("			//https://www.w3schools.com/jquery/ajax_serialize.asp\r\n");
      out.write("			$('#updateForm').on(\"submit\",function(){\r\n");
      out.write("				var param = $(this).serialize();\r\n");
      out.write("				//console.log(param);\r\n");
      out.write("				//alert(\"submit\");\r\n");
      out.write("				$.ajax({\r\n");
      out.write("					url:\"CommentEditUpdate.jsp\",\r\n");
      out.write("					dataType:\"JSON\",\r\n");
      out.write("					type : \"POST\",\r\n");
      out.write("					data : param, //{\"seq\" :\"1\" ,\"title\" : \"A\" , \"content\":\"A\" , \"regdate\":\"11\" , \"hit\":\"1\"} ,\r\n");
      out.write("					success : function(returndata){\r\n");
      out.write("						    alert(returndata.result);\r\n");
      out.write("						 	if(returndata.result){\r\n");
      out.write("								alert(\"수정성공\");\r\n");
      out.write("								GetBoardList(); //데이터 갱신하기\r\n");
      out.write("							}else{\r\n");
      out.write("								alert(\"수정실패\");\r\n");
      out.write("							}  \r\n");
      out.write("						}\r\n");
      out.write("					\r\n");
      out.write("					});\r\n");
      out.write("				\r\n");
      out.write("			 	return false; //기본적인 submit 하지 말아라  (동기식 하지 말아라 ...)\r\n");
      out.write("			});\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		function GetBoardList(){\r\n");
      out.write("			alert(\"호출 : GetBoardList\");\r\n");
      out.write("			//데이터 만드는 작업 (비동기)\r\n");
      out.write("			$.ajax({\r\n");
      out.write("				url : \"CommentEditList.jsp\" ,\r\n");
      out.write("				dataType : \"JSON\",\r\n");
      out.write("				type : \"POST\" ,\r\n");
      out.write("				success : function(data){\r\n");
      out.write("					//[{\"content\":\"0 번째 내용\",\"hit\":0,\"regdate\":\"2017-11-12\",\"seq\":0,\"title\":\"0 번쨰 제목\"},{\"content\":\"1 번째 내용\",\"hit\":1,\"regdate\":\"2017-11-12\",\"seq\":1,\"title\":\"1 번쨰 제목\"},{\"content\":\"2 번째 내용\",\"hit\":2,\"regdate\":\"2017-11-12\",\"seq\":2,\"title\":\"2 번쨰 제목\"},{\"content\":\"3 번째 내용\",\"hit\":3,\"regdate\":\"2017-11-12\",\"seq\":3,\"title\":\"3 번쨰 제목\"},{\"content\":\"4 번째 내용\",\"hit\":4,\"regdate\":\"2017-11-12\",\"seq\":4,\"title\":\"4 번쨰 제목\"}]\r\n");
      out.write(" 				    //console.log(data);\r\n");
      out.write("					//https://www.w3schools.com/jquery/misc_data.asp\r\n");
      out.write("					$('#listView').empty();\r\n");
      out.write("					$('#listView').data(\"list\",data); //key \"data\" value Array객체\r\n");
      out.write("					\r\n");
      out.write("					//data -> [{},{},{},{}]\r\n");
      out.write("					//data -> json 형태의 ArrayObject\r\n");
      out.write("					//테이블 구성하기\r\n");
      out.write("					//$.each(data,function(index , obj){\r\n");
      out.write("						//obj.seq\r\n");
      out.write("					//});\r\n");
      out.write("					\r\n");
      out.write("					for(var k=0 ; k < data.length ; k++){\r\n");
      out.write("						var tr=\"\";\r\n");
      out.write("						tr += \"<tr index='\"+ (k) +\"'>\";\r\n");
      out.write("						tr += \"<td>\" + data[k].seq + \"</td>\";\r\n");
      out.write("						tr += \"<td>\" + data[k].title + \"</td>\";\r\n");
      out.write("						tr += \"<td>\" + data[k].content + \"</td>\";\r\n");
      out.write("						tr += \"<td>\" + data[k].regdate + \"</td>\";\r\n");
      out.write("						tr += \"<td>\" + data[k].hit + \"</td>\";\r\n");
      out.write("						tr += \"</tr>\";\r\n");
      out.write("						\r\n");
      out.write("						//<tr index=0><td>0</td><td>홍길동</td></tr>\r\n");
      out.write("						\r\n");
      out.write("						var trObj = $(tr); //trObj (json 객체로 만들기)\r\n");
      out.write("						console.log(trObj);\r\n");
      out.write("						\r\n");
      out.write("						trObj.addClass(\"over\").on(\"click\",function(){\r\n");
      out.write("							//tr > click 하면 상세  출력 \r\n");
      out.write("							//각각의 tr 을 클릭했을때  >  현재 선택한 tr 을 내용을 \r\n");
      out.write("							//수정가능한 아래 테이블에 내용 보여주기\r\n");
      out.write("							\r\n");
      out.write("								var index = $(this).attr(\"index\");\r\n");
      out.write("								//console.log(index);\r\n");
      out.write("								var data = $(\"#listView\").data(\"list\");\r\n");
      out.write("								console.log(\"데이터 : \" + data);\r\n");
      out.write("								var rowdata = data[index];  //[{},{},{}]\r\n");
      out.write("								//rowdata = {\"content\":\"0 번째 내용\",\"hit\":0,\"regdate\":\"2017-11-12\",\"seq\":0,\"title\":\"0 번쨰 제목\"}\r\n");
      out.write("								//console.log(data);\r\n");
      out.write("							    //rowdata {}객체 	\r\n");
      out.write("								\r\n");
      out.write("								//https://www.w3schools.com/jquery/tryit.asp?filename=tryjquery_html_prop_attr\r\n");
      out.write("								//각각의 input 태그에 value 값을 넣기\r\n");
      out.write("								$('#detailView').find(\":input\").each(function(){\r\n");
      out.write("									var name = $(this).prop(\"name\"); //속성의 이름만 가져오기\r\n");
      out.write("									//console.log(name);\r\n");
      out.write("									var value =rowdata[name];\r\n");
      out.write("									//console.log(value);\r\n");
      out.write("									if(value != undefined){\r\n");
      out.write("										$(this).val(value);\r\n");
      out.write("									}\r\n");
      out.write("								});\r\n");
      out.write("							\r\n");
      out.write("						});\r\n");
      out.write("						\r\n");
      out.write("						$('#listView').append(trObj);\r\n");
      out.write("					}\r\n");
      out.write("				}\r\n");
      out.write("			});\r\n");
      out.write("		}\r\n");
      out.write("	</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<div>\r\n");
      out.write("		<table border=\"1\">\r\n");
      out.write("			<thead>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<th>번호</th>\r\n");
      out.write("					<th>글제목</th>\r\n");
      out.write("					<th>글내용</th>\r\n");
      out.write("					<th>등록일</th>\r\n");
      out.write("					<th>조회수</th>				\r\n");
      out.write("				</tr>\r\n");
      out.write("			</thead>\r\n");
      out.write("			<tbody id=\"listView\">\r\n");
      out.write("			\r\n");
      out.write("			</tbody>\r\n");
      out.write("		</table>\r\n");
      out.write("	</div>\r\n");
      out.write("	<div id=\"detailView\">\r\n");
      out.write("		<form id=\"updateForm\">\r\n");
      out.write("			<table border=\"1\">\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>번호</td>\r\n");
      out.write("					<td><input type=\"text\" name=\"seq\" value=\"\" readonly></td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>글제목</td>\r\n");
      out.write("					<td><input type=\"text\" name=\"title\" value=\"\"></td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>글내용</td>\r\n");
      out.write("					<td><input type=\"text\" name=\"content\" value=\"\"></td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>등록일</td>\r\n");
      out.write("					<td><input type=\"text\" name=\"regdate\" value=\"\"></td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>조회수</td>\r\n");
      out.write("					<td><input type=\"text\" name=\"hit\" value=\"\"></td>\r\n");
      out.write("				</tr>\r\n");
      out.write("			</table>\r\n");
      out.write("			<input type=\"submit\" id=\"btnUpdate\" value=\"수정하기\">\r\n");
      out.write("		</form>	\r\n");
      out.write("	</div>\r\n");
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
