package com.villagevista.villagevista.dispatcher;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.rmi.ServerException;
import java.util.logging.Level;

import com.villagevista.villagevista.services.logservice.LogService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "Dispatcher", urlPatterns = {"/Dispatcher"})
public class Dispatcher extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {

            String controllerAction = request.getParameter("controllerAction");

            if (controllerAction == null) controllerAction = "HomeManagement.view";

            String[] splittedAction = controllerAction.split("\\.");
            Class<?> controllerClass = Class.forName("com.villagevista.villagevista.controller." + splittedAction[0]);
            Method controllerMethod = controllerClass.getMethod(splittedAction[1], HttpServletRequest.class, HttpServletResponse.class);

            // Registra l'azione solo dopo l'invocazione del metodo con successo
            controllerMethod.invoke(null, request, response);
            LogService.getApplicationLogger().log(Level.INFO, splittedAction[0] + " " + splittedAction[1]);

            // Controlla se la pagina JSP è stata impostata come attributo
            String viewUrl = (String) request.getAttribute("viewUrl");

            // Se la pagina JSP è stata impostata, inoltra la richiesta
            if (viewUrl != null) {
                RequestDispatcher view = request.getRequestDispatcher("jsp/" + viewUrl + ".jsp");
                view.forward(request, response);
            } else {
                // Se la pagina JSP non è stata impostata, gestisci l'errore
                throw new ServletException("Impossibile trovare la pagina JSP: " + viewUrl);
            }

        } catch (IOException e) {
            // Cattura l'eccezione IOException e gestiscila in modo appropriato
            // (ad esempio, registrare l'errore, inviare un messaggio di errore all'utente)
            throw new ServletException("Errore di I/O: " + e.getMessage(), e);

        } catch (ServletException e) {
            // Cattura l'eccezione ServletException e gestiscila in modo appropriato
            // (ad esempio, registrare l'errore, inviare un messaggio di errore all'utente)
            throw e;

        } catch (Exception e) {
            // Cattura qualsiasi altra eccezione non gestita e gestiscila in modo appropriato
            // (ad esempio, registrare l'errore, inviare un messaggio di errore generico all'utente)
            throw new ServletException("Errore imprevisto: " + e.getMessage(), e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
