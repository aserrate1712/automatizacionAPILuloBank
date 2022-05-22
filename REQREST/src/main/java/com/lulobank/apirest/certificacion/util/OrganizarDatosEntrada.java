package com.lulobank.apirest.certificacion.util;

import com.lulobank.apirest.certificacion.model.DataUsers;

import java.util.ArrayList;
import java.util.List;

public class OrganizarDatosEntrada {
    private OrganizarDatosEntrada() {
        throw new IllegalStateException("Utility class");
    }

    public static List<String> paravalidarcreciondeusuarios(List<DataUsers> datainicial)
    {
        List<String> listadatosesp = new ArrayList<String>();
        listadatosesp.add(datainicial.get(0).getName());
        listadatosesp.add(datainicial.get(0).getJob());
        return listadatosesp;
    }

    public static List<String> paravalidarusuariosexistentes(List<DataUsers> datainicial)
    {
        List<String> listadatosesp = new ArrayList<String>();
        listadatosesp.add(datainicial.get(0).getId());
        listadatosesp.add(datainicial.get(0).getEmail());
        listadatosesp.add(datainicial.get(0).getFirst_name());
        listadatosesp.add(datainicial.get(0).getLast_name());
        listadatosesp.add(datainicial.get(0).getAvatar());
        return listadatosesp;
    }
}
