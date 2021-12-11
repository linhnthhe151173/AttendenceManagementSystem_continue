package filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author Linh
 */
@WebFilter(filterName = "SecurityFilter", servletNames = {"ClassDetailController", "HomeTController", "ClassDetailController",
"AttendenceController", "AddController", "AddStudentController", "StudentDetailController", 
"AddTeacherController", "TeacherDetailController", "AddScheduleController", "EditSubjectController", 
"EditStudentController", "EditScheduleController", "RemoveSubjectController", "RemoveClassController", "RemoveTeacherController",
"RemoveStudentController", "RemoveScheduleController", "EditAttendenceController", "AttendenceDetailController",
"ProfileController", "AccountDetailController"}, urlPatterns = {"/teacher/other_schedule","/class/add", "/class/edit", "/teacher/edit"})
public class SecurityFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        Account account = (Account) req.getSession().getAttribute("account");
        if(account == null){
            res.sendRedirect("../login");
        }else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
