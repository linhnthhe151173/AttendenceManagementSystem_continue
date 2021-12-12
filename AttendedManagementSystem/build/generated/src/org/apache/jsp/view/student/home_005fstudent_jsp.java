package org.apache.jsp.view.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_005fstudent_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("\n");
      out.write("        <!-- Bootstrap CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n");
      out.write("        <title>home_student</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!-- header -->\n");
      out.write("        <nav class=\"navbar navbar-expand-md sticky-top\" style=\"background-color: #EF7F1B;\">\n");
      out.write("            <a class=\"navbar-brand\" href=\"#\" style=\"color: white;\">Attendence Management</a>\n");
      out.write("            <button class=\"navbar-toggler navbar-toggler-right\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navb\" aria-expanded=\"true\">\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("            </button>\n");
      out.write("            <div id=\"navb\" class=\"navbar-collapse collapse hide\">\n");
      out.write("                <ul class=\"nav navbar-nav ml-auto\">\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" href=\"profile_student.jsp\" style=\"color: white;\"><span class=\"fas fa-user\">Welcome: </span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.account.getDisplayName()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" href=\"../logout\" style=\"color: white;\"><span class=\"fas fa-sign-in-alt\"></span>| Logout</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div style=\"margin-top: 20px;\">\n");
      out.write("                <h5>Your Semester: 5</h5>\n");
      out.write("                <h5 style=\"color: #EF7F1B;\">Check your attended schedule with:</h5>\n");
      out.write("                <div>\n");
      out.write("                    <ul>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"attended_schedule_detail.jsp\" style=\"color: black;\">PRJ(Java Web Application)</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"attended_schedule_detail.jsp\" style=\"color: black;\">PRJ(Java Web Application)</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"attended_schedule_detail.jsp\" style=\"color: black;\">PRJ(Java Web Application)</a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <hr>\n");
      out.write("            <h5 style=\"color: #EF7F1B;\">Or check another your semester:</h5>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-2\">\n");
      out.write("                    <table class=\"table table-hover\">\n");
      out.write("                        <thead>\n");
      out.write("                        <th>Semester</th>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Semester 1</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Semester 2</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Semester 3</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Semester 4</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Semester 5</td>\n");
      out.write("                            </tr>\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-3\" style=\"border-left: 1px solid black;\">\n");
      out.write("                    <table class=\"table table-hover\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th scope=\"col\">STT</th>\n");
      out.write("                                <th scope=\"col\">Subject's Name</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            <tr>\n");
      out.write("                                <th scope=\"row\">1</th>\n");
      out.write("                                <td><a>PRJ301(SE1511)</a></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <th scope=\"row\">2</th>\n");
      out.write("                                <td><a>PRJ301(SE1511)</a></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <th scope=\"row\">3</th>\n");
      out.write("                                <td><a>PRJ301(SE1511)</a></td>\n");
      out.write("                            </tr>\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-7\"  style=\"border-left: 1px solid black;\">\n");
      out.write("                    <h6>Lecture: LinhNTH</h6>\n");
      out.write("                    <table class=\"table table-hover\">\n");
      out.write("                        <thead>\n");
      out.write("                        <th>STT</th>\n");
      out.write("                        <th>Date</th>\n");
      out.write("                        <th>Time Slot</th>\n");
      out.write("                        <th>Room</th>\n");
      out.write("                        <th>Class Name</th>\n");
      out.write("                        <th>Attendance Status</th>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>1</td>\n");
      out.write("                                <td>02-08-2021</td>\n");
      out.write("                                <td>7:30-9:30</td>\n");
      out.write("                                <td>BE157</td>\n");
      out.write("                                <td>SE1511</td>\n");
      out.write("                                <td style=\"color: green;\">Present</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>2</td>\n");
      out.write("                                <td>02-08-2021</td>\n");
      out.write("                                <td>7:30-9:30</td>\n");
      out.write("                                <td>BE157</td>\n");
      out.write("                                <td>SE1511</td>\n");
      out.write("                                <td style=\"color: green;\">Present</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>3</td>\n");
      out.write("                                <td>02-08-2021</td>\n");
      out.write("                                <td>7:30-9:30</td>\n");
      out.write("                                <td>BE157</td>\n");
      out.write("                                <td>SE1511</td>\n");
      out.write("                                <td style=\"color: green;\">Present</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>4</td>\n");
      out.write("                                <td>02-08-2021</td>\n");
      out.write("                                <td>7:30-9:30</td>\n");
      out.write("                                <td>BE157</td>\n");
      out.write("                                <td>SE1511</td>\n");
      out.write("                                <td style=\"color: green;\">Present</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>5</td>\n");
      out.write("                                <td>02-08-2021</td>\n");
      out.write("                                <td>7:30-9:30</td>\n");
      out.write("                                <td>BE157</td>\n");
      out.write("                                <td>SE1511</td>\n");
      out.write("                                <td style=\"color: green;\">Present</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td colspan=\"6\" style=\"text-align: center;\"><h5>2 ABSENT ON 30 TOTAL</h5></td>\n");
      out.write("                            </tr>\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                    \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
