package ru.parsentev.servlets;

import org.junit.Test;
import org.mockito.Mockito;
import ru.parsentev.store.UserCashe;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by art on 28.05.16.
 */
public class UserCreateServletTest extends Mockito {

    final UserCashe USER_CASHE = UserCashe.getInstance();

    @Test
    public void createUser()throws ServletException, IOException{
       /* HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("login")).thenReturn("test");
        when(request.getParameter("email")).thenReturn("test");

        assertTrue(USER_CASHE.values().isEmpty());

        new UserCreateServlet().doPost(request,response);

        verify(request,atLeast(1)).getParameter("login");
        verify(request,atLeast(1)).getParameter("email");
        assertFalse(USER_CASHE.values().isEmpty());

        USER_CASHE.delete(USER_CASHE.findByLogin(request.getParameter("login")).getId());
*/
    }

}