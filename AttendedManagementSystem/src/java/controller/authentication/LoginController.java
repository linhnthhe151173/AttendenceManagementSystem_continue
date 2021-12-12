package controller.authentication;

import dal.AccountDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author Linh
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("view/authentication/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");

        AccountDBContext db = new AccountDBContext();
        Account account = Account.builder()
                .username(username)
                .password(password).build();
        
        Account loggedAccount = db.getOne(account);
        if (loggedAccount != null) {
            request.getSession().setAttribute("account", loggedAccount);
            if (remember != null) {
                Cookie user = new Cookie("username", loggedAccount.getUsername());
                Cookie pass = new Cookie("password", loggedAccount.getPassword());
                user.setMaxAge(3600 * 24 * 30);
                pass.setMaxAge(3600 * 24 * 30);
                response.addCookie(pass);
                response.addCookie(user);
            }
            //response.getWriter().println("login successful!");
            //response.sendRedirect("teacher/today_schedule");
            if(loggedAccount.getRoleID().getRoleID() == 2){
                response.sendRedirect("teacher/today_schedule");
            } else if(loggedAccount.getRoleID().getRoleID() == 1){
                response.sendRedirect("home");
            } else if(loggedAccount.getRoleID().getRoleID() == 3){
                response.sendRedirect("student/home_student");
            }
        } else {
            response.sendRedirect("login");
            //response.getWriter().println("login failed!");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
