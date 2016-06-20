package ru.parsentev.servlets;

import ru.parsentev.store.UserCashe;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by art on 25.05.16.
 */
public class UserViewServlet extends HttpServlet {

    private final UserCashe USER_CACHE = UserCashe.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users",USER_CACHE.values());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/user/UserView.jsp");
        dispatcher.forward(req,resp);
    }
}
