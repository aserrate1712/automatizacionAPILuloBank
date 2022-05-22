package com.lulobank.apirest.certificacion.interactions;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;


public class EjecutarPostNuevoUsuario implements Interaction {

    private String endpoint;

    public EjecutarPostNuevoUsuario(String endpoint)
    {
        this.endpoint=endpoint;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String body= actor.recall("bodynuevousuario");
        actor.attemptsTo(
                Post.to(endpoint.trim()).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(body)
                )
        );
    }

    public static EjecutarPostNuevoUsuario conendpoint(String endpoint)
    {
        return Tasks.instrumented(EjecutarPostNuevoUsuario.class,endpoint);
    }

}
