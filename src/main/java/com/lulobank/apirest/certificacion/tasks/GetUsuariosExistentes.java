package com.lulobank.apirest.certificacion.tasks;

import com.lulobank.apirest.certificacion.interactions.EjecutarGetUsuariosExistentes;
import com.lulobank.apirest.certificacion.interactions.EjecutarPostNuevoUsuario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class GetUsuariosExistentes implements Task {

    private String endpoint;

    GetUsuariosExistentes(String endpoint)
    {
        this.endpoint=endpoint;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(EjecutarGetUsuariosExistentes.conendpoint(endpoint));
    }

    public static GetUsuariosExistentes conendpoint(String endpoint)
    {
        return Tasks.instrumented(GetUsuariosExistentes.class,endpoint);
    }
}
