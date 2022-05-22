package com.lulobank.apirest.certificacion.interactions;

import com.lulobank.apirest.certificacion.model.DataUsers;
import com.lulobank.apirest.certificacion.util.OrganizarDatosEntrada;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.util.List;

public class EjecutarGetUsuariosExistentes implements Interaction {

    private String endpoint;

    public EjecutarGetUsuariosExistentes(String endpoint)
    {
        this.endpoint=endpoint;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<DataUsers> listadatos= actor.recall("datosexistentes");
        List<String>listadatosexistentes= OrganizarDatosEntrada.paravalidarusuariosexistentes(listadatos);
        actor.remember("listadatosexistentes",listadatosexistentes);
        actor.attemptsTo(
                Get.resource(endpoint).with(
                        requestSpecification -> requestSpecification
                ));
    }

    public static EjecutarGetUsuariosExistentes conendpoint(String endpoint)
    {
        return Tasks.instrumented(EjecutarGetUsuariosExistentes.class,endpoint);
    }
}
