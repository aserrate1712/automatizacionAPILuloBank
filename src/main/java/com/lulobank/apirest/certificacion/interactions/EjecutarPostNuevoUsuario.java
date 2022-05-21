package com.lulobank.apirest.certificacion.interactions;

import com.lulobank.apirest.certificacion.model.DataUsers;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.List;

public class EjecutarPostNuevoUsuario implements Interaction {

    private String endpoint;

    public EjecutarPostNuevoUsuario(String endpoint)
    {
        this.endpoint=endpoint;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String hola="hola";
        String body= actor.recall("bodynuevousuario");
        actor.attemptsTo(
                Post.to(endpoint.trim()).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(body)
                )
        );
        //realizar la conversion a una lista sencilla en este apartado

    }

    public static EjecutarPostNuevoUsuario conendpoint(String endpoint)
    {
        return Tasks.instrumented(EjecutarPostNuevoUsuario.class,endpoint);
    }

}
