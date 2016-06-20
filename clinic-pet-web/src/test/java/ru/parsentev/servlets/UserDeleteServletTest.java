package ru.parsentev.servlets;

import org.junit.Test;
import org.mockito.Mockito;
import ru.parsentev.models.User;
import ru.parsentev.store.UserCashe;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by art on 29.05.16.
 */
public class UserDeleteServletTest extends Mockito{

   /* final UserCashe USER_CACHE = UserCashe.getInstance();

    @Test
    public void deleteUser() throws IOException, ServletException {
        /*User user = new User(1,"h","j");
        USER_CACHE.add(user);
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("id")).thenReturn("1");
        //when(request.getParameter("email")).thenReturn("j");

        assertTrue(USER_CACHE.values().contains(user));

       // new UserCreateServlet().doPost(request,response);
        new UserDeleteServlet().doGet(request,response);

        verify(request,atLeast(1)).getParameter("id");
        //verify(request,atLeast(1)).getParameter("email");


        assertFalse(USER_CACHE.values().contains(user));

        //USER_CACHE.delete(USER_CACHE.findByLogin(request.getParameter("login")).getId());
    }*/
}