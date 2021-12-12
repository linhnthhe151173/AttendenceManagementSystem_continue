package controller.admin;

import dal.ScheduleDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Schedule;

/**
 *
 * @author Linh
 */
public class ScheduleController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Schedule> list = new ArrayList<>();
        list = new ScheduleDBContext().getAll();

        request.setAttribute("list", list);
        request.getRequestDispatcher("view/admin/schedule_detail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String search = request.getParameter("search");
        if (search == null) {
            ArrayList<Schedule> list = new ArrayList<>();
            list = new ScheduleDBContext().getAll();

            request.setAttribute("list", list);

        } else {
            ArrayList<Schedule> list_search = new ArrayList<>();
            list_search = new ScheduleDBContext().search(Date.valueOf(request.getParameter("search")));

            request.setAttribute("list_search", list_search);
        }
        request.setAttribute("search", search);
        request.getRequestDispatcher("view/admin/schedule_detail.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
