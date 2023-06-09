/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.74
 * Generated at: 2023-05-19 01:04:36 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Ex09_005fWebApp_005fRealPath_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!--\r\n");
      out.write("	URI (Universal Resource Identifier)\r\n");
      out.write("	- 인터넷상의 자원을 식별하기 위한 표기법 및 규약	\r\n");
      out.write("	- URL + URN = URI	\r\n");
      out.write("	- 인터넷 환경에서 URI는 대부분 URL을 의미, URN은 사용이 제한적	\r\n");
      out.write("	\r\n");
      out.write("	​ URL (Uniform Resource Locator)	\r\n");
      out.write("	- 물리적인 경로, 즉 자원의 위치 정보를 포함	\r\n");
      out.write("	- 프로토콜, 도메인, 아이피, 포트 등	\r\n");
      out.write("	- 컴퓨터로부터 접근 가능한 형태의 자원만 검색될 수 있어 제한적	\r\n");
      out.write("	- 우리가 흔히 보는 'http://test.com/test.jpg' 형태\r\n");
      out.write("	\r\n");
      out.write("	​ ​URN (Uniform Resource Name)	\r\n");
      out.write("	- 독립적인 이름을 제공하기 위해 존재	\r\n");
      out.write("	- 자원에 대해 영속적이고 유일	\r\n");
      out.write("	- 자원의 위치와는 무관	\r\n");
      out.write("	- 예를들어 우리나라에서는 주민등록번호가 대표적		​\r\n");
      out.write("	\r\n");
      out.write("	StringBuffer url = request.getRequestURL(); // URL : 전체주소 (프로토콜 + IP + 포트 + 상세경로)	\r\n");
      out.write("	String uri = request.getRequestURI(); // URI : 프로젝트 이하 경로 (CP + SP)	\r\n");
      out.write("	String cp = request.getContextPath(); // CP : 프로젝트 명	\r\n");
      out.write("	String sp = request.getServletPath(); // SP : 패키지 + 파일명		​\r\n");
      out.write("	\r\n");
      out.write("	System.out.println(\"URL : \" + url);	\r\n");
      out.write("	System.out.println(\"URI : \" + uri);	\r\n");
      out.write("	System.out.println(\"CP : \" + cp);	\r\n");
      out.write("	System.out.println(\"SP : \" + sp);	​\r\n");
      out.write("	\r\n");
      out.write("	​-----------------------------------------------------------------\r\n");
      out.write("	\r\n");
      out.write("	URL : http://192.168.0.12:8090/WebJSP/Ex11_WebApp_RealPath.jsp	\r\n");
      out.write("	URI : /WebJSP/Ex11_WebApp_RealPath.jsp	\r\n");
      out.write("	CP : /WebJSP	\r\n");
      out.write("	SP : /WebJSP/Member/Ex11_WebApp_RealPath.jsp\r\n");
      out.write("	\r\n");
      out.write("	이클립스 톰켓 내장\r\n");
      out.write("	실제 배포 경로 : 실제 서비스 되고 있는 소스는 아래 폴더 소스\r\n");
      out.write("	C:\\Douzone\\Web\\WebClient\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\WebJSP\r\n");
      out.write("--->\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("	<head>\r\n");
      out.write("		<meta charset=\"UTF-8\">\r\n");
      out.write("		<title>Insert title here</title>\r\n");
      out.write("	</head>\r\n");
      out.write("	<body>\r\n");
      out.write("		");

			String resourcepath = "/download/note.txt"; //http://192.168.0.30:8090/WebJSP/download/note.txt
			out.print(resourcepath + "<br>");
			
			String realcontextpath = application.getRealPath(request.getContextPath()); // CP : /WebJSP 가상경로
			out.print("getRealPath를 실제 경로 " + realcontextpath +"<br>");
			// 실 배포 경로
			// C:\Douzone\Web\WebClient\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\WebJSP\WebJSP
			
			String filepath = application.getRealPath(resourcepath); 
			out.print("file real path 실제 경로 " + filepath +"<br>");
			// 실 배포 경로
			// C:\Douzone\Web\WebClient\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\WebJSP\WebJSP
			
			// 개발 소스 경로 : Property에서 확인
			// C:\Douzone\Web\WebClient\WebJSP\src\main\webapp\Ex09_WebApp_RealPath.jsp
			
			
			
			StringBuffer url = request.getRequestURL(); // URL : 전체주소 (프로토콜 + IP + 포트 + 상세경로)	
			String uri = request.getRequestURI(); // URI : 프로젝트 이하 경로 (CP + SP)	
			String cp = request.getContextPath(); // CP : 프로젝트 명	
			String sp = request.getServletPath(); // SP : 패키지 + 파일명		​
			
			System.out.println("URL : " + url);	
			System.out.println("URI : " + uri);	
			System.out.println("CP : " + cp);	
			System.out.println("SP : " + sp);	
			
			/* 
				URL : http://192.168.0.30:8090/WebJSP/Ex09_WebApp_RealPath.jsp
				URI : /WebJSP/Ex09_WebApp_RealPath.jsp
				CP : /WebJSP
				SP : /Ex09_WebApp_RealPath.jsp
			*/
			
		
      out.write("\r\n");
      out.write("	</body>\r\n");
      out.write("</html>");
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
