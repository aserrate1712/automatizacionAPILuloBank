package com.lulobank.apirest.certificacion.tasks;

import com.lulobank.apirest.certificacion.interactions.CrearBodyNuevoUsuario;
import com.lulobank.apirest.certificacion.model.DataUsers;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.List;

public class CrearPeticionConInformacion implements Task {

    private List<DataUsers> datosiniciales;

    public CrearPeticionConInformacion(List<DataUsers> datosiniciales)
    {
        this.datosiniciales=datosiniciales;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(CrearBodyNuevoUsuario.coninformacion(datosiniciales));
    }

    public static CrearPeticionConInformacion inicial(List<DataUsers> datosiniciales)
    {
        return Tasks.instrumented(CrearPeticionConInformacion.class,datosiniciales);
    }


}
