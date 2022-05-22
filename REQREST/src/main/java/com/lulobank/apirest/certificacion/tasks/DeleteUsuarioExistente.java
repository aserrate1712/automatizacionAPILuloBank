package com.lulobank.apirest.certificacion.tasks;

import com.lulobank.apirest.certificacion.interactions.EjecutarDeleteUsuarioExistente;
import com.lulobank.apirest.certificacion.interactions.EjecutarGetUsuarioExistente;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class DeleteUsuarioExistente implements Task {

    private String endpoint;

    DeleteUsuarioExistente(String endpoint)
    {
        this.endpoint=endpoint;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(EjecutarDeleteUsuarioExistente.conendpoint(endpoint));
    }

    public static DeleteUsuarioExistente conendpoint(String endpoint)
    {
        return Tasks.instrumented(DeleteUsuarioExistente.class,endpoint);
    }
}
