package com.lulobank.apirest.certificacion.questions;

import com.lulobank.apirest.certificacion.model.DataUsersExist;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class VerificaLaExistenciaDeUnUsuario {

    private static final Logger LOGGER = Logger.getLogger(VerificaLaExistenciaDeUnUsuario.class.getName());

    public static Question<Integer> response() {
        Integer response = SerenityRest.lastResponse().statusCode();
        return actor ->  response;
    }

    public static Question<List<String>> dataresponse()
    {
        List<String>listadatosresponse = new ArrayList<String>();
        DataUsersExist datausuarioexist = SerenityRest.lastResponse()
                        .jsonPath()
                        .getObject("data", DataUsersExist.class);
                    listadatosresponse.add(String.valueOf(datausuarioexist.getId()));
                    listadatosresponse.add(datausuarioexist.getEmail());
                    listadatosresponse.add(datausuarioexist.getFirst_name());
                    listadatosresponse.add(datausuarioexist.getLast_name());
                    listadatosresponse.add(datausuarioexist.getAvatar());

        return actor -> listadatosresponse;
    }
}
