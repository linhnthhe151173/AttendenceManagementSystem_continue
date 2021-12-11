package controller.admin;

import dal.AccountDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author Linh
 */
public class AccountDetailController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Account> list_account_admin = new ArrayList<>();
        ArrayList<Account> list_account_teacher = new ArrayList<>();
        ArrayList<Account> list_account_student = new ArrayList<>();
        list_account_admin = new AccountDBContext().getAccountOfAdmin();
        list_account_teacher = new AccountDBContext().getAccountOfTeacher();
        list_account_student = new AccountDBContext().getAccountOfStudent();
                
        request.setAttribute("list_account_admin", list_account_admin);
        request.setAttribute("list_account_teacher", list_account_teacher);
        request.setAttribute("list_account_student", list_account_student);
        request.getRequestDispatcher("view/admin/account_detail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
