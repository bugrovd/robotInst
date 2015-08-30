package client.servlets;

import client.page.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by home on 30.08.2015.
 */
public class MainServlet extends HttpServlet {
    private String greeting="Hello World";
    public MainServlet(String greeting)
    {
        this.greeting=greeting;
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        Map<String, Object> pageSource = new HashMap<String, Object>();
        pageSource.put("string","Hello");
        response.getWriter().println(PageGenerator.getPage("index.ftl", pageSource));
        response.getWriter().println("session=" + request.getSession(true).getId());
    }
}
