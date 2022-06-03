package com.lulobank.apirest.certificacion.tasks;

import com.lulobank.apirest.certificacion.interactions.EjecutarGetUsuarioExistente;
import com.lulobank.apirest.certificacion.model.DataUsers;
import com.lulobank.apirest.certificacion.util.OrganizarDatosEntrada;
import net.serenitybdd.markers.IsSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class OrganizacionDatos implements Performable, IsSilent {

    @Override
    public <T extends Actor> void performAs(T actor) {}

    public static OrganizacionDatos parausuariosexistentes(List<DataUsers> datosiniciales)
    {
        List<String>listadatosexistentes= OrganizarDatosEntrada.paravalidarusuariosexistentes(datosiniciales);
        theActorInTheSpotlight().remember("listadatosexistentes",listadatosexistentes);
        return Tasks.instrumented(OrganizacionDatos.class,datosiniciales);
    }

    public static OrganizacionDatos paranuevosusuarios(List<DataUsers> datosiniciales)
    {
        List<String>listadatosesp = OrganizarDatosEntrada.paravalidarcreciondeusuarios(datosiniciales);
        theActorInTheSpotlight().remember("listadatosesp",listadatosesp);
        return Tasks.instrumented(OrganizacionDatos.class,datosiniciales);
    }

}
