package ru.parsentev.clinicServlets;


import ru.lesson.lessions.Client;
import ru.parsentev.store.ClinicCashe;;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet of the client add page
 * Created by art on 26.05.16.
 */
public class ClinicCreateServlet extends HttpServlet {

    private static final String CLINIC_VIEW = "/clinic/view";
    private static final String ADD_CLIENT = "/views/clinic/CreateClient.jsp";
    private static final String ERROR_MESSAGE = "Enter correct id!";
    private static final String INPUT_ID = "Enter ID!";

    private final ClinicCashe CLINIC = ClinicCashe.getInstance();

    /**
     * Get query handling
     * @param req request
     * @param resp response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        forwardToCreate(req,resp,ADD_CLIENT);
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
        processAddClient(req,resp);
    }

    /**
     * Post query handling
     * @param req request
     * @param resp response
     * @throws ServletException
     * @throws IOException
     */
    private void processAddClient(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("clientId");
        if (!CLINIC.checkId(id) && !"".equals(id)){
            addClient(req,resp);
            forwardToView(req,resp,CLINIC_VIEW);
        }else{
            askCorrectId(req,resp);
        }
    }

    /**
     * Add client to the clinic
     * @param req request
     * @param resp response
     * @throws ServletException
     * @throws IOException
     */
    private void addClient(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String id = req.getParameter("clientId");
        String name = req.getParameter("clientName");
        CLINIC.addClient(new Client(
                req.getParameter("clientId"),
                req.getParameter("clientName"),
                null));
    }

    /**
     * Redirect to View page
     * @param req request
     * @param resp response
     * @param path adress
     * @throws ServletException
     * @throws IOException
     */
    private void forwardToView(HttpServletRequest req, HttpServletResponse resp, String path)
            throws ServletException, IOException {
        resp.sendRedirect(String.format("%s%s",req.getContextPath(),path));
    }

    /**
     * Redirect to Create page
     * @param req request
     * @param resp response
     * @param path
     * @throws ServletException
     * @throws IOException
     */
    private void forwardToCreate(HttpServletRequest req, HttpServletResponse resp, String path)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher(ADD_CLIENT);
        dispatcher.forward(req, resp);
    }


    /**
     * Ask korrect ID
     * @param req request
     * @param resp response
     * @throws ServletException
     * @throws IOException
     */
    private void askCorrectId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("errorValue",getErrorMessage(req));
        forwardToCreate(req,resp,ADD_CLIENT);
    }

    /**
     * Get error mesage
     * @param req request
     * @return
     */
    private String getErrorMessage(HttpServletRequest req){
        String message;
        if ("".equals(req.getParameter("clientId"))){
            message = INPUT_ID;
        }else{
            message = ERROR_MESSAGE;
        }
        return message;
    }

}
