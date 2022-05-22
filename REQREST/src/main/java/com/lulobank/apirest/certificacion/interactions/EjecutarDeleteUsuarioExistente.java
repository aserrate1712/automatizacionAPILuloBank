package com.lulobank.apirest.certificacion.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;


public class EjecutarDeleteUsuarioExistente implements Interaction {

    private String endpoint;

    public EjecutarDeleteUsuarioExistente(String endpoint)
    {
        this.endpoint=endpoint;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String id= actor.recall("idexistente");
        actor.attemptsTo(
                Delete.from(endpoint+id).with(
                        requestSpecification -> requestSpecification
                ));
    }

    public static EjecutarDeleteUsuarioExistente conendpoint(String endpoint)
    {
        return Tasks.instrumented(EjecutarDeleteUsuarioExistente.class,endpoint);
    }
}
