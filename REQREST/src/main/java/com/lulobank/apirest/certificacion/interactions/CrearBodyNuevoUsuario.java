package com.lulobank.apirest.certificacion.interactions;

import com.lulobank.apirest.certificacion.model.DataUsers;
import com.lulobank.apirest.certificacion.util.OrganizarDatosEntrada;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CrearBodyNuevoUsuario implements Interaction {

    private static final Logger LOGGER = Logger.getLogger(CrearBodyNuevoUsuario.class.getName());
    private List<DataUsers> datosiniciales;


    public CrearBodyNuevoUsuario(List<DataUsers> datosiniciales)
    {
        this.datosiniciales=datosiniciales;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        List<String> listadatosesp = new ArrayList<String>();
        String registerinforeqres ="{\n"+
                "\t\"name\":\""+datosiniciales.get(0).getName()+"\",\n" +
                "\"job\":\""+datosiniciales.get(0).getJob()+",\"\n" +
                "}";
        LOGGER.info(registerinforeqres);
        listadatosesp = OrganizarDatosEntrada.paravalidarcreciondeusuarios(datosiniciales);
        actor.remember("listadatosesp",listadatosesp);
        actor.remember("bodynuevousuario",registerinforeqres);
    }
    public static CrearBodyNuevoUsuario coninformacion(List<DataUsers> datosiniciales)
    {
        return Tasks.instrumented(CrearBodyNuevoUsuario.class,datosiniciales);
    }
}
