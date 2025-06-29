package com.villagevista.villagevista.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Map;

public class HomeManagement {
    private HomeManagement(){
    }
    public static void view(HttpServletRequest request, HttpServletResponse response) {

        Map sessionFactoryParameters=new HashMap<String,Object>();
        sessionFactoryParameters.put("request",request);
        sessionFactoryParameters.put("response",response);

        request.setAttribute("viewUrl","homeManagement/view");

    }
    public static void goToBackoffice(HttpServletRequest request, HttpServletResponse response) {
        // Reindirizza alla pagina di login del backoffice
        request.setAttribute("viewUrl", "backofficeLogin/backofficeLogin");
    }

    public static void goToLoginCliente(HttpServletRequest request, HttpServletResponse response){
        //reindirizza alla pagina di login per il cliente
        request.setAttribute("viewUrl","loginCliente/loginCliente");
    }

    public static void goToGallery(HttpServletRequest request, HttpServletResponse response){
        //reindirizza alla pagina galley
        request.setAttribute("viewUrl","galleryView/galleryView");
    }
    public static void goToCamere(HttpServletRequest request, HttpServletResponse response){
        //reindirizza alla pagina delle camere
        request.setAttribute("viewUrl","camere/camere");
    }
    public static void goToBungalow(HttpServletRequest request, HttpServletResponse response){
        //reindirizza alla pagina delle camere
        request.setAttribute("viewUrl","bungalow/bungalow");
    }


}
