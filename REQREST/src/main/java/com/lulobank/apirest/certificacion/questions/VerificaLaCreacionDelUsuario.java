package com.lulobank.apirest.certificacion.questions;

import com.lulobank.apirest.certificacion.model.DataNewUsers;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;
import java.util.ArrayList;
import java.util.List;



public class VerificaLaCreacionDelUsuario {

    public static Question<Integer> response() {
        Integer response = SerenityRest.lastResponse().statusCode();
        return actor ->  response;
    }

    public static Question<List<String>> dataresponse()
    {
        DataNewUsers datanuevousuario = SerenityRest.lastResponse()
                .jsonPath()
                .getObject("", DataNewUsers.class);
        List<String>listadatosresponse = new ArrayList<String>();
        listadatosresponse.add(datanuevousuario.getName());
        listadatosresponse.add(datanuevousuario.getJob().replace(",",""));
        return actor -> listadatosresponse;
    }







}
