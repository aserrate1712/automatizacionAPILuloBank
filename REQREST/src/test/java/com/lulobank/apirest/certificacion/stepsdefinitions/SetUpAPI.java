package com.lulobank.apirest.certificacion.stepsdefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static com.lulobank.apirest.certificacion.util.LeerArchivoProperties.leerarchivoproperties;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class SetUpAPI {

    @Before
    public void setUp() {
        String restAPIURL = leerarchivoproperties("reqrest.properties").conParametro("ruta.API");
        setTheStage(new OnlineCast());
        theActorCalled("Alejandro");
        theActorInTheSpotlight().whoCan(CallAnApi.at(restAPIURL));
    }
}
