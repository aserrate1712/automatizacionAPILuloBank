package com.lulobank.apirest.certificacion.tasks;

import com.lulobank.apirest.certificacion.interactions.EjecutarPostNuevoUsuario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;


public class PostNuevoUsuario implements Task {

    private String endpoint;

    PostNuevoUsuario(String endpoint)
    {
        this.endpoint=endpoint;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(EjecutarPostNuevoUsuario.conendpoint(endpoint));
    }

    public static PostNuevoUsuario conendpoint(String endpoint)
    {
        return Tasks.instrumented(PostNuevoUsuario.class,endpoint);
    }

}
