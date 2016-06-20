package ru.parsentev.clinicServlets;

import ru.lesson.lessions.Client;
import ru.parsentev.store.ClinicCashe;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by art on 01.06.16.
 */
public class PetDeleteServlet extends HttpServlet {

    private static final String EDIT_CLIENT_PATH = "/clinic/edit";

    private final ClinicCashe CLINIC = ClinicCashe.getInstance();

    /**
     * Get query
     * @param req request
     * @param resp response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Client client = this.CLINIC.getCurrentClient();
        client.removePetByName((req.getParameter("name")));
        this.CLINIC.editClient(client);
        //this.CLINIC.setCurrentClient(client);
        refreshPage(req,resp);
    }


    /**
     * Refresh Page
     * @param req request
     * @param resp response
     * @throws IOException
     */
    private void refreshPage(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setAttribute("client", CLINIC.getCurrentClient());
        String id = "?id=" + CLINIC.getCurrentClient().getId();
        resp.sendRedirect(String.format("%s%s%s", req.getContextPath(), EDIT_CLIENT_PATH, id ));
        //resp.sendRedirect(String.format("%s%s",req.getContextPath(),"/clinic/view"));
    }
}
