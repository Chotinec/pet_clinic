package ru.parsentev.clinicServlets;

import ru.lesson.lessions.Animals.Cat;
import ru.lesson.lessions.Animals.PetType;
import ru.lesson.lessions.Client;
import ru.lesson.lessions.Clinic;
import ru.lesson.lessions.PetCreator;
import ru.parsentev.store.ClinicCashe;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Clinic edit servlet
 * Created by art on 26.05.16.
 */
public class ClinicEditServlet extends HttpServlet {

    private static final String CLINIC_VIEW = "/clinic/view";
    private static final String EDIT_CLIENT = "/views/clinic/EditClient.jsp";

    private final ClinicCashe CLINIC= ClinicCashe.getInstance();

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
        getClient(req,resp);
        forwardToEditView(req,resp);
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
        processEdit(req,resp);
        //forwardToEditView(req,resp);
    }

    /**
     * Redirect to edit view
     * @param req request
     * @param resp response
     * @throws ServletException
     * @throws IOException
     */
    private void forwardToEditView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("client", CLINIC.getCurrentClient());
        RequestDispatcher dispatcher = req.getRequestDispatcher(EDIT_CLIENT);
        dispatcher.forward(req,resp);
    }

    /**
     * Reirect to clinic view
     * @param req request
     * @param resp response
     * @throws ServletException
     * @throws IOException
     */
    private void forwardToClinicView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(String.format("%s%s",req.getContextPath(),CLINIC_VIEW));
    }

    /**
     * Get client to edit
     * @param req request
     * @param response response
     */
    private void getClient(HttpServletRequest req, HttpServletResponse response){
        CLINIC.setCurrentClient(CLINIC.getClient(req.getParameter("id")));
        req.setAttribute("client",CLINIC.getCurrentClient());
    }

    /**
     * Process edit client
     * @param req request
     * @param resp response
     * @throws ServletException
     * @throws IOException
     */
    private void processEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        editClient(req,resp);
        addPet(req,resp);
    }

    /**
     * Edit client
     * @param req request
     * @throws ServletException
     * @throws IOException
     */
    private void editClient(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("update") != null){
            CLINIC.editClient(new Client(
                    req.getParameter("id"),
                    req.getParameter("clientName"),
                    CLINIC.getCurrentClient().getPets()));
            forwardToClinicView(req,resp);
        }
    }

    /**
     * Add pet
     * @param req request
     * @param resp response
     * @throws ServletException
     * @throws IOException
     */
    private void addPet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("addPet") != null){
            if (!"".equals(req.getParameter("petName"))) {
                CLINIC.getCurrentClient().addPet(
                        PetCreator.createPetByType(
                                PetType.getType(req.getParameter("petType")),
                                req.getParameter("petName")
                        ));
                CLINIC.editClient(CLINIC.getCurrentClient());
                forwardToEditView(req, resp);
            }
        }
    }

}
