package com.lulobank.apirest.certificacion.tasks;

import com.lulobank.apirest.certificacion.interactions.EjecutarGetUsuarioExistente;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class GetUsuarioExistente implements Task {

    private String endpoint;

    GetUsuarioExistente(String endpoint)
    {
        this.endpoint=endpoint;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(EjecutarGetUsuarioExistente.conendpoint(endpoint));
    }

    public static GetUsuarioExistente conendpoint(String endpoint)
    {
        return Tasks.instrumented(GetUsuarioExistente.class,endpoint);
    }
}
