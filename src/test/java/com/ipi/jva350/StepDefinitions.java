package com.ipi.jva350;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class StepDefinitions {

    @Given("un mois de référence {string}")
    public void un_mois_de_référence(String moisDeReference) {
        // Implémentez le code pour initialiser le mois de référence
    }

    @Given("un nombre de congés payés acquis l'année précédente de {int}")
    public void un_nombre_de_congés_payés_acquis_l_année_précédente_de(Integer congésAcquis) {
        // Implémentez le code pour initialiser le nombre de congés payés acquis l'année précédente
    }

    @Given("un mois de début de contrat {string}")
    public void un_mois_de_début_de_contrat(String moisDebutContrat) {
        // Implémentez le code pour initialiser le mois de début de contrat
    }

    @Given("un premier jour de congé {string}")
    public void un_premier_jour_de_congé(String premierJourCongé) {
        // Implémentez le code pour initialiser le premier jour de congé
    }

    @Given("un dernier jour de congé {string}")
    public void un_dernier_jour_de_congé(String dernierJourCongé) {
        // Implémentez le code pour initialiser le dernier jour de congé
    }

    @When("je calcule la limite de congés permis par l'entreprise")
    public void je_calcule_la_limite_de_congés_permis_par_l_entreprise() {
        // Implémentez le code pour effectuer le calcul de la limite de congés permis par l'entreprise
    }

    @Then("la limite de congés permis est {int}")
    public void la_limite_de_congés_permis_est(Integer limiteCongésPermises) {
        // Implémentez le code pour vérifier que la limite de congés permis correspond à la valeur attendue
    }
}

