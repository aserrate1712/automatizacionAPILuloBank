package com.lulobank.apirest.certificacion.questions;

import com.lulobank.apirest.certificacion.model.DataUsersExist;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;


import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class VerificaLaExistenciaDeUsuarios {

    private static final Logger LOGGER = Logger.getLogger(VerificaLaExistenciaDeUsuarios.class.getName());

    public static Question<Integer> response() {
        Integer response = SerenityRest.lastResponse().statusCode();
        return actor ->  response;
    }

    public static Question<List<String>> dataresponse()
    {
        List<String> datosactuales = theActorInTheSpotlight().recall("listadatosexistentes");
        List<String>listadatosresponse = new ArrayList<String>();
        boolean found=false;
        int contador=0;
        try {
            do {
                DataUsersExist datausuarioexist = SerenityRest.lastResponse()
                        .jsonPath()
                        .getObject("data[" + contador + "]", DataUsersExist.class);
                if (datausuarioexist.getId() == Integer.parseInt(datosactuales.get(0))) {
                    listadatosresponse.add(String.valueOf(datausuarioexist.getId()));
                    listadatosresponse.add(datausuarioexist.getEmail());
                    listadatosresponse.add(datausuarioexist.getFirst_name());
                    listadatosresponse.add(datausuarioexist.getLast_name());
                    listadatosresponse.add(datausuarioexist.getAvatar());
                    found = true;
                } else {
                    contador++;
                }
            }
            while (!found);
        }
        catch (Exception e)
        {
           LOGGER.log(Level.WARNING,e.toString());
        }
        return actor -> listadatosresponse;
    }
}
