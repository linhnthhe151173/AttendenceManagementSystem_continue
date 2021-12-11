package controller.authentication;

import dal.AccountDBContext;
import java.io.IOException;
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
public abstract class BasedAuthentication extends HttpServlet {

    private boolean isAuthenticated(HttpServletRequest request) {
        Account account = (Account) request.getSession().getAttribute("account");
        if (account != null) {
            return true;
        } else {
            String user = null;
            String pass = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cooky : cookies) {
                    if (cooky.getName().equals("username")) {
                        user = cooky.getValue();
                    } else if (cooky.getName().equals("password")) {
                        pass = cooky.getValue();
                    }
                }
                if (user == null || pass == null) {
                    return false;
                } else {
                    AccountDBContext db = new AccountDBContext();
                    account = Account.builder().username(user)
                            .password(pass).build();
                    Account loggedAccount = db.getOne(account);
                    if (loggedAccount != null) {
                        request.getSession().setAttribute("account", loggedAccount);
                        return true;
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (isAuthenticated(request)) {
            processGet(request, response);
        } else {
            response.sendRedirect("login");
            //response.getWriter().println("access denied!");
        }
    }

    protected abstract void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    protected abstract void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (isAuthenticated(request)) {
            processPost(request, response);
        } else {
            response.sendRedirect("login");
            //response.getWriter().println("access denied!");
        }
    }
}
