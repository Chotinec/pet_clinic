package ru.parsentev.clinicServlets;

import ru.lesson.lessions.Client;
import ru.lesson.lessions.Clinic;
import ru.parsentev.store.ClinicCashe;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Clinic view swrvlet
 * Created by art on 26.05.16.
 */
public class ClinicViewServlet extends HttpServlet {

    /** String const */
    private static final String CLINIC_VIEW = "/views/clinic/ClinicView.jsp";
    private static final String ADD_CLIENT = "/views/clinic/CreateClient.jsp";

    private final ClinicCashe CLINIC = ClinicCashe.getInstance();

    private final Collection<Client> clientsToShow = new CopyOnWriteArrayList<Client>();



    /**
     * Get query
     * @param req request
     * @param resp response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        process(req,resp);
    }

    /**
     * Post query
     * @param req request
     * @param resp response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        setFilters(req);
        doGet(req, resp);
    }

    /**
     * Get query handling
     * @param req request
     * @param resp response
     * @throws ServletException
     * @throws IOException
     */
    private void process(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (req.getParameter("addClient") != null) {
            forwardTo(req, resp, ADD_CLIENT);
        }
        else {
            //clientsToShow.clear();
            //clientsToShow.addAll(CLINIC.getClients());
            req.setAttribute("clients",clientsToShow);
            forwardTo(req, resp, CLINIC_VIEW);
        }
    }

    /**
     * Redirect to specified page
     * @param req request
     * @param resp response
     * @param path adress
     * @throws ServletException
     * @throws IOException
     */
    private void forwardTo(HttpServletRequest req, HttpServletResponse resp, String path)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher(path);
        dispatcher.forward(req, resp);
    }

    /**
     * Set filters
     * @param req request
     */
    private void setFilters(HttpServletRequest req){

        if (req.getParameter("search") != null) {
            clientsToShow.clear();
            clientsToShow.addAll(CLINIC.getClients());

            if (!"".equals(req.getParameter("searchParametr")) && req.getParameter("searchType") != null) {
                List<Client> find = CLINIC.findClients(req.getParameter("searchType"), req.getParameter("searchParametr"));
                clientsToShow.clear();
                clientsToShow.addAll(find);
            }
        }
    }


}
