package com.ipi.jva350.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class SalarieAideADomicileTest {

    @Test
    public void testALegalementDroitADesCongesPayesNominal() {
        // GIVEN :
        SalarieAideADomicile monSalarie = new SalarieAideADomicile("Paul", LocalDate.of(2023, 6, 20), LocalDate.now(), 20, 5, 120, 15, 8);
        // WHEN :
        boolean res = monSalarie.aLegalementDroitADesCongesPayes();
        // THEN :
        Assertions.assertTrue(res);
    }

    @Test
    public void testALegalementDroitADesCongesPayesDefaultValue() {
        // GIVEN :
        SalarieAideADomicile monSalarie = new SalarieAideADomicile("Paul", LocalDate.of(2023, 6, 20), LocalDate.now(), 20, 5, 120, 15, 8);
        // WHEN :
        boolean res = monSalarie.aLegalementDroitADesCongesPayes();
        // THEN :
        Assertions.assertTrue(res);
    }
    @Test
    public void testALegalementDroitADesCongesPayesTrue() {
        // GIVEN :
        SalarieAideADomicile monSalarie = new SalarieAideADomicile("Paul", LocalDate.of(2023, 6, 20), LocalDate.now(), 20, 5, 120, 15, 8);
        // WHEN :
        boolean res = monSalarie.aLegalementDroitADesCongesPayes();
        // THEN :
        Assertions.assertTrue(res);
    }

    @Test
    public void testALegalementDroitADesCongesPayesFalse() {
        // GIVEN :
        SalarieAideADomicile monSalarie = new SalarieAideADomicile("Paul", LocalDate.of(2023, 6, 20),
                LocalDate.now(), 20, 5, 9, 15, 8);
        // WHEN :
        boolean res = monSalarie.aLegalementDroitADesCongesPayes();
        // THEN :
        Assertions.assertFalse(res, "avec 4 jours travaillés en N-1, le résultat doit être faux");
    }

    @Test
    public void testEstHabituellementTravailleTrue() {
        // GIVEN :
        SalarieAideADomicile jourTravaille = new SalarieAideADomicile();
        // WHEN :
        boolean res = jourTravaille.estHabituellementTravaille(LocalDate.now());
        // THEN :
       Assertions.assertTrue(res);
    }

    @Test
    public void testEstHabituellementTravailleFasle() {
        // GIVEN :
        SalarieAideADomicile jourTravaille = new SalarieAideADomicile();
        // WHEN :
        boolean res = jourTravaille.estHabituellementTravaille(LocalDate.now( ));
        // THEN :
        Assertions.assertFalse(res, "si le jour est un jour de fin de semaine, le résultat doit être faux");
    }

}
