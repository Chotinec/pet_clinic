package ru.parsentev.clinicServlets;

import ru.lesson.lessions.Clinic;
import ru.parsentev.store.ClinicCashe;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by art on 26.05.16.
 */
public class ClinicDeleteServlet extends HttpServlet {

    private final ClinicCashe CLINIC = ClinicCashe.getInstance();

    /**
     * Do get query
     * @param req request
     * @param resp response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.CLINIC.deleteClient(req.getParameter("id"));
        resp.sendRedirect(String.format("%s%s",req.getContextPath(),"/clinic/view"));
    }

}
