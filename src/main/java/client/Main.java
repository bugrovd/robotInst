package client;

import client.servlets.MainServlet;
import client.setting.Account;
import client.setting.ConfigReader;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.Servlet;
import javax.xml.transform.TransformerException;

public class Main {

    public static void main(String[] args) throws Exception {
        Server server = new Server(80);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder((Servlet) new MainServlet("123")), "/");
        server.setHandler(context);

        server.start();
        server.join();
    }
}
