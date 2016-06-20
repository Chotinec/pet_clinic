package ru.parsentev.clinicServlets;

import org.junit.Test;
import org.mockito.Mockito;
import ru.parsentev.servlets.UserDeleteServlet;
import ru.parsentev.store.UserCashe;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by art on 29.05.16.
 */
public class ClinicDeleteServletTest extends Mockito{

    /*final UserCashe USER_CACHE = UserCashe.getInstance();

    @Test
    public void delete() throws IOException, ServletException{
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("login")).thenReturn("test");
        when(request.getParameter("email")).thenReturn("test");

        assertTrue(USER_CACHE.values().isEmpty());

        //new UserDeleteServlet()

        verify(request,atLeast(1)).getParameter("login");
        verify(request,atLeast(1)).getParameter("email");


    }*/

}