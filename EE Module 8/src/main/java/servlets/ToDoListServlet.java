package servlets;

import objects.Task;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class ToDoListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("taskName");
        String category = req.getParameter("taskCategory");
        List<Task> allTasks = (List<Task>) req.getSession().getAttribute("allTasks");
        if (allTasks==null) {
            allTasks = new ArrayList<>();
        }
        if (!name.equals("")) {
            allTasks.add(new Task(name,category,false));
        }
        req.getSession().setAttribute("allTasks",allTasks);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        req.getRequestDispatcher("/index.jsp");
    }
}
