package com.lulobank.apirest.certificacion.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

public class VerificaLaEliminacionDeUnUsuario {

    public static Question<Integer> response() {
        Integer response = SerenityRest.lastResponse().statusCode();
        return actor ->  response;
    }
}
