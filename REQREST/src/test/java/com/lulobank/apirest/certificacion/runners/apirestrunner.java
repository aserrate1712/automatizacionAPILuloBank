package com.lulobank.apirest.certificacion.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/reqrestAPI/apirest.feature",
        glue = "com.lulobank.apirest.certificacion.stepsdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "")
public class apirestrunner {
}
