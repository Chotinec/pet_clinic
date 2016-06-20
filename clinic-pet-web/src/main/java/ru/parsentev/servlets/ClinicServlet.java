package ru.parsentev.servlets;



import ru.lesson.lessions.Animals.Pet;
import ru.lesson.lessions.Client;
import ru.lesson.lessions.PetCreator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * TODO: comment
 * @author parsentev
 * @since 16.04.2015
 */
public class ClinicServlet extends HttpServlet {

    final List<Client> clients = new CopyOnWriteArrayList<Client>();
    private String searh = "";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.append(
                "<!DOCTYPE html>" +
                        "<html>" +
                        "<head>" +
                        "     <title>Clinic Pets</title>" +
                        "</head>" +
                        "<body>" +
                        "     <form action='"+req.getContextPath()+"/' method='post'>" +
                        "         Client name : <input type='text' name='clientName'>"+
                        "         Pet type : <input type='text' name='petType'>"+
                        "         Pet name : <input type='text' name='petName'>"+
                        "         <input type='submit' value='Submit'>"+
                        "     <form>"+
                        this.viewPets() +
                        "     <br><form action='"+req.getContextPath()+"/' method='post'>" +
                        "         Search : <input type='text' name='search'>"+
                        "         <input type='submit' value='Submit'>"+
                        "     <form>"+
                        "</body>" +
                        "</html>"
        );
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        searh = req.getParameter("search");
        if ("".equals(searh)) {
            Pet pet = PetCreator.createPet(req.getParameter("petType"), req.getParameter("petName"));
            Client client = new Client("0",req.getParameter("clientName"),null);
            client.addPet(pet);
            this.clients.add(client);
        }
        doGet(req, resp);
    }

    private String viewPets() {
        StringBuilder sb = new StringBuilder();
        sb.append("<p>Pets</p>");
        sb.append("<table style='border : 1px solid black'>");
        sb.append("<tr>");
        sb.append("<td style='border : 1px solid black'>").append("Pet</td>");
        sb.append("<td style='border : 1px solid black'>").append("Pet name</td>");
        sb.append("<td style='border : 1px solid black'>").append("Client name</td>");
        sb.append("</tr>");

        for (Client client : this.clients) {
            for (Pet pet :client.getPets()) {
                if (pet != null) {
                    if (pet.getName().contains(searh)) {
                        sb.append("<tr>");
                        sb.append("<td style='border : 1px solid black'>").append(pet.getType()).append("</td>");
                        sb.append("<td style='border : 1px solid black'>").append(pet.getName()).append("</td>");
                        sb.append("<td style='border : 1px solid black'>").append(client.getName()).append("</td>");
                        sb.append("</tr>");
                    }
                }
            }
        }
        sb.append("</table>");
        return sb.toString();
    }
}