package com.lulobank.apirest.certificacion.stepsdefinitions;

import com.lulobank.apirest.certificacion.model.DataUsers;
import com.lulobank.apirest.certificacion.questions.VerificaLaCreacionDelUsuario;
import com.lulobank.apirest.certificacion.tasks.CrearPeticionConInformacion;
import com.lulobank.apirest.certificacion.tasks.PostNuevoUsuario;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.*;

public class ApirestReqStepsDefinitions {


    @DataTableType(replaceWithEmptyString = "[blank]")
    public DataUsers convert(Map<String, String> entry){
        return new DataUsers(
                entry.get("name"),
                entry.get("job")
        );
    }

    @Before
    public void setUp() {
        String restAPIURL="https://reqres.in";
        setTheStage(new OnlineCast());
        theActorCalled("Alejandro");
        theActorInTheSpotlight().whoCan(CallAnApi.at(restAPIURL));
    }

    @Dado("que el usuario crea una peticion con la informacion inicial$")
    public void queElUsuarioCreaUnaPeticionConLaInformacionInicial(List<DataUsers> data) {
        theActorInTheSpotlight().attemptsTo(CrearPeticionConInformacion.inicial(data));
    }

    @Cuando("el usuario realice una peticion de tipo POST sobre el endpoint (.*)$")
    public void elUsuarioRealiceUnaPeticionDeTipoPOSTSobreElEndpoint(String endpoint) {
        theActorInTheSpotlight().attemptsTo(PostNuevoUsuario.conendpoint(endpoint));
    }

    //@Entonces("verifica la creacion de usuario por medio de una peticion GET y una respuesta {int}")
    //public void verificaLaCreacionDeUsuarioPorMedioDeUnaPeticionGETYUnaRespuesta(int responsecode) {
        //theActorInTheSpotlight().should(seeThat(VerificaLaCreacionDelUsuario.enReqREST(responsecode), is(true)));
    //}

    @Entonces("verifica la creacion de usuario por medio de una respuesta {int} y con la informacion inicial")
    public void verificaLaCreacionDeUsuarioPorMedioDeUnaRespuestaYConLaInformacionInicial(Integer responsecode) {
        List<String> datosesperados =theActorInTheSpotlight().recall("listadatosesp");
        theActorInTheSpotlight().should(seeThat("la respuesta del servicio fue:",VerificaLaCreacionDelUsuario.response(),equalTo(responsecode)));
        theActorInTheSpotlight().should(seeThat("la respuesta de los datos del servicio fue:",VerificaLaCreacionDelUsuario.dataresponse(),equalTo(datosesperados)));
    }
}
