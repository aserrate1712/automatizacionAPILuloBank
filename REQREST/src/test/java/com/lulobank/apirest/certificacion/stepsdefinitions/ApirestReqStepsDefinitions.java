package com.lulobank.apirest.certificacion.stepsdefinitions;

import com.lulobank.apirest.certificacion.model.DataUsers;
import com.lulobank.apirest.certificacion.questions.VerificaLaCreacionDelUsuario;
import com.lulobank.apirest.certificacion.questions.VerificaLaExistenciaDeUnUsuario;
import com.lulobank.apirest.certificacion.questions.VerificaLaExistenciaDeUsuarios;
import com.lulobank.apirest.certificacion.tasks.*;
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
                entry.get("job"),
                entry.get("id"),
                entry.get("email"),
                entry.get("first_name"),
                entry.get("last_name"),
                entry.get("avatar")
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

    @Dado("que el usuario desea consultar la existencia de un usuario previamente creado con datos")
    public void queElUsuarioDeseaConsultarLaExistenciaDeUnUsuarioPreviamenteCreadoConDatos(List<DataUsers> data) {
        theActorInTheSpotlight().remember("datosexistentes",data);
    }

    @Dado("que se desea eliminar un usuario previamente creado con (.*)$")
    public void queSeDeseaEliminarUnUsuarioPreviamenteCreadoCon(String id) {
        theActorInTheSpotlight().remember("idexistente",id);
    }

    @Cuando("el usuario realice una peticion de tipo POST sobre el endpoint (.*)$")
    public void elUsuarioRealiceUnaPeticionDeTipoPOSTSobreElEndpoint(String endpoint) {
        theActorInTheSpotlight().attemptsTo(PostNuevoUsuario.conendpoint(endpoint));
    }

    @Cuando("el usuario realice una peticion de tipo GET sobre el endpoint (.*)$")
    public void elUsuarioRealiceUnaPeticionDeTipoGETSobreElEndpointApiUsersPage(String endpoint) {
        theActorInTheSpotlight().attemptsTo(GetUsuariosExistentes.conendpoint(endpoint));
    }

    @Cuando("el usuario realice una peticion de tipo GET sobre un usuario usando el endpoint (.*)$")
    public void elUsuarioRealiceUnaPeticionDeTipoGETSobreUnUsuarioUsandoElEndpointApiUsers(String endpoint) {
        theActorInTheSpotlight().attemptsTo(GetUsuarioExistente.conendpoint(endpoint));
    }

    @Cuando("el usuario realice una peticion de tipo DELETE sobre un usuario usando el endpoint (.*)$")
    public void elUsuarioRealiceUnaPeticionDeTipoDELETESobreUnUsuarioUsandoElEndpointApiUsers(String endpoint) {
        theActorInTheSpotlight().attemptsTo(DeleteUsuarioExistente.conendpoint(endpoint));
    }

    @Entonces("verifica la creacion de usuario por medio de una respuesta {int} y con la informacion inicial")
    public void verificaLaCreacionDeUsuarioPorMedioDeUnaRespuestaYConLaInformacionInicial(Integer responsecode) {
        List<String> datosesperados =theActorInTheSpotlight().recall("listadatosesp");
        theActorInTheSpotlight().should(seeThat("la respuesta del servicio fue:",VerificaLaCreacionDelUsuario.response(),equalTo(responsecode)),
                                        seeThat("la respuesta de los datos del servicio fue:",VerificaLaCreacionDelUsuario.dataresponse(),equalTo(datosesperados)));
    }

    @Entonces("verifica la existencia de los usuarios por medio de una respuesta {int} y con la informacion inicial")
    public void verificaLaExistenciaDeLosUsuariosPorMedioDeUnaRespuestaYConLaInformacionInicial(Integer responsecode) {
        List<String> datosactuales = theActorInTheSpotlight().recall("listadatosexistentes");
        theActorInTheSpotlight().should(seeThat("la respuesta del servicio fue:", VerificaLaExistenciaDeUsuarios.response(),equalTo(responsecode)),
                seeThat("la respuesta de los datos del servicio fue:",VerificaLaExistenciaDeUsuarios.dataresponse(),equalTo(datosactuales)));
    }

    @Entonces("verifica la existencia del usuario por medio de una respuesta {int} y con la informacion inicial")
    public void verificaLaExistenciaDelUsuarioPorMedioDeUnaRespuestaYConLaInformacionInicial(Integer responsecode) {
        List<String> datosactuales = theActorInTheSpotlight().recall("listadatosexistentes");
        theActorInTheSpotlight().should(seeThat("la respuesta del servicio fue:", VerificaLaExistenciaDeUnUsuario.response(),equalTo(responsecode)),
                seeThat("la respuesta de los datos del servicio fue:",VerificaLaExistenciaDeUnUsuario.dataresponse(),equalTo(datosactuales)));
    }

    @Entonces("verifica la existencia del usuario por medio de una respuesta {int}")
    public void verificaLaExistenciaDelUsuarioPorMedioDeUnaRespuesta(Integer responsecode) {
        theActorInTheSpotlight().should(seeThat("la respuesta del servicio fue:", VerificaLaExistenciaDeUnUsuario.response(),equalTo(responsecode)));
    }
}
