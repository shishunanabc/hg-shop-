/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.4.20.v20190813
 * Generated at: 2020-04-28 09:30:16 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view.spec;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class add_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(6);
    _jspx_dependants.put("file:/D:/tool/repository/jstl/jstl/1.2/jstl-1.2.jar", Long.valueOf(1582098661643L));
    _jspx_dependants.put("jar:file:/D:/tool/repository/org/apache/taglibs/taglibs-standard-impl/1.2.5/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425949870000L));
    _jspx_dependants.put("file:/D:/tool/repository/org/apache/taglibs/taglibs-standard-impl/1.2.5/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1582288913181L));
    _jspx_dependants.put("jar:file:/D:/tool/repository/jstl/jstl/1.2/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153356282000L));
    _jspx_dependants.put("file:/D:/tool/repository/org/springframework/spring-webmvc/5.1.5.RELEASE/spring-webmvc-5.1.5.RELEASE.jar", Long.valueOf(1582286236413L));
    _jspx_dependants.put("jar:file:/D:/tool/repository/org/springframework/spring-webmvc/5.1.5.RELEASE/spring-webmvc-5.1.5.RELEASE.jar!/META-INF/spring-form.tld", Long.valueOf(1550007212000L));
  }

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

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
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
      out.write("    \r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t");
String path=request.getContextPath();
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<script type=\"text/javascript\"  src=\"");
      out.print(request.getContextPath() );
      out.write("/js/jquery-3.2.1.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"href=\"/bootstrap-4.4.1-dist/css/bootstrap.min.css\" />\r\n");
      out.write("<script type=\"text/javascript\"src=\"/bootstrap-4.4.1-dist/js/bootstrap.min.js\"></script> \r\n");
      out.write("<script type=\"text/javascript\"  src=\"");
      out.print(request.getContextPath() );
      out.write("/My97DatePicker/WdatePicker.js\"></script> \r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<form id=\"specForm\"> \t\t\t\r\n");
      out.write("\t  <div class=\"form-group row\">\r\n");
      out.write("\t    <label for=\"specName\" class=\"col-sm-2 col-form-label\">规格名称</label>\r\n");
      out.write("\t    <div class=\"col-sm-10\">\r\n");
      out.write("\t      <input type=\"text\" id=\"specName\" name=\"specName\" value=\"\">\r\n");
      out.write("\t      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t      <input type=\"button\" name=\"\" class=\"btn btn-success\" value=\"增加属性值\" onclick=\"addLin()\">\r\n");
      out.write("\t    </div>\r\n");
      out.write("\t  </div>\r\n");
      out.write("\t  <div class=\"form-group row\">\r\n");
      out.write("\t    \t<table class=\"table\" id=\"optionTable\">\r\n");
      out.write("\t    \t\t<tr>\r\n");
      out.write("\t    \t\t\t<th>属性值</th>\r\n");
      out.write("\t    \t\t\t<th>排序</th>\r\n");
      out.write("\t    \t\t\t<th>操作</th>\r\n");
      out.write("\t    \t\t</tr>\r\n");
      out.write("\t    \t\t<tr>\r\n");
      out.write("\t    \t\t\t<td>\r\n");
      out.write("\t    \t\t\t\t<input type=\"text\" name=\"specOption[0].optionName\">\r\n");
      out.write("\t    \t\t\t</td>\r\n");
      out.write("\t    \t\t\t<td>\r\n");
      out.write("\t    \t\t\t\t<input type=\"number\" name=\"specOption[0].orders\">\r\n");
      out.write("\t    \t\t\t</td>\r\n");
      out.write("\t    \t\t\t<td>\r\n");
      out.write("\t    \t\t\t\t<input type=\"button\" name=\"\" class=\"btn btn-success\" onclick=\"delLin($(this))\" value=\"删除\">\r\n");
      out.write("\t    \t\t\t</td>\r\n");
      out.write("\t    \t\t</tr>\r\n");
      out.write("\t    \t</table>\r\n");
      out.write("\t  </div>\r\n");
      out.write("\t  <div class=\"form-group row\">\r\n");
      out.write("\t  \t<div class=\"col-sm-10\">  \r\n");
      out.write("\t        <input type=\"button\" name=\"\" class=\"btn btn-success\" value=\"提交数据\" onclick=\"commitData()\">\r\n");
      out.write("\t    </div>\r\n");
      out.write("\t  </div>\r\n");
      out.write("\t</form>   \r\n");
      out.write("\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t//删除自己的行\r\n");
      out.write("\t\tfunction delLin(jObj){\r\n");
      out.write("\t\t\tjObj.parent().parent().remove();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar linIndex=0;\r\n");
      out.write("\t\t// 添加行\r\n");
      out.write("\t\tfunction addLin(){\r\n");
      out.write("\t\t\t$(\"#optionTable\").append('<tr>' +\r\n");
      out.write("\t    \t\t\t'<td><input type=\"text\" name=\"specOption['+linIndex+'].optionName\"></td> ' +\r\n");
      out.write("\t    \t\t\t'<td><input type=\"number\" name=\"specOption['+linIndex+'].orders\"></td> ' +\r\n");
      out.write("\t    \t\t\t'<td><input type=\"button\" name=\"\" class=\"btn btn-success\" onclick=\"delLin($(this))\" value=\"删除\"></td> ' +\r\n");
      out.write("\t    \t\t'</tr>')\r\n");
      out.write("\t    \t\tlinIndex++;\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t/**\r\n");
      out.write("\t\t\t提交数据\r\n");
      out.write("\t\t*/\r\n");
      out.write("\t\tfunction commitData(){\r\n");
      out.write("\t\t\tvar formData = new FormData($(\"#specForm\")[0])\r\n");
      out.write("\t\t\t$.ajax({url:'/spec/add',\r\n");
      out.write("\t\t\t\t\tdata:formData,\r\n");
      out.write("\t\t\t\t\ttype:\"post\",\r\n");
      out.write("\t\t\t\t\tprocessData:false,\r\n");
      out.write("\t\t\t\t\tcontentType:false,\r\n");
      out.write("\t\t\t\t\tsuccess:function(data){\r\n");
      out.write("\t\t\t\t\t\tif(data==true){\r\n");
      out.write("\t\t\t\t\t\t\talert('添加成功')\r\n");
      out.write("\t\t\t\t\t\t\t//跳转到列表页面\r\n");
      out.write("\t\t\t\t\t\t\tvar url=\"/spec/list\";\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#workArea\").load(url)\r\n");
      out.write("\t\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t\talert('添加失败')\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
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
