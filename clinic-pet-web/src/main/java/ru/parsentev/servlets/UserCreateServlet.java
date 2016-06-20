package ru.parsentev.servlets;

import ru.parsentev.models.User;
import ru.parsentev.store.UserCashe;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by art on 25.05.16.
 */
public class UserCreateServlet extends HttpServlet {

    final AtomicInteger id = new AtomicInteger();

    private final UserCashe USER_CACHE = UserCashe.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        USER_CACHE.add(new User(this.id.incrementAndGet(),req.getParameter("login"),req.getParameter("email")));
        resp.sendRedirect(String.format("%s%s",req.getContextPath(),"/user/view"));
    }
}
