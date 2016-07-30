package servlets;

import objects.Task;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UpdateListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Task> allTasks = (List<Task>) req.getSession().getAttribute("allTasks");
        String[] checksList = req.getParameterValues("done");
        if (checksList!=null) {
            List<String> checks = Arrays.asList(checksList);
            if (!checks.isEmpty()) {
                List<Task> updatedList = new ArrayList<>();
                for (Task task : allTasks) {
                    if (!checks.contains(task.getName())) {
                        updatedList.add(task);
                    }
                }
                req.getSession().setAttribute("allTasks", updatedList);

            }
        }
        req.getRequestDispatcher("/index.jsp").forward(req,resp);

    }
}
