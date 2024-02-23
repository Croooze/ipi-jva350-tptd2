package com.ipi.jva350.model;

import com.ipi.jva350.exception.SalarieException;
import com.ipi.jva350.repository.SalarieAideADomicileRepository;
import com.ipi.jva350.service.SalarieAideADomicileService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.LinkedHashSet;

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

    @ParameterizedTest
    @CsvSource ({"'2020-01-01','2021-01-01','305'",
            "'2020-01-01','2020-02-01','27'"

    })
    public void testCalculeJoursDeCongeDecomptesPourPlage(String dateDebut, String dateFin, int exceptedNb) {
        // GIVEN :
        SalarieAideADomicile monSalarie = new SalarieAideADomicile("Paul", LocalDate.of(2023, 6, 20), LocalDate.now(), 20, 5, 120, 15, 8);
        // WHEN :
        LinkedHashSet<LocalDate> res = monSalarie.calculeJoursDeCongeDecomptesPourPlage(
                LocalDate.parse(dateDebut),
                LocalDate.parse(dateFin));
        // THEN :
        Assertions.assertEquals(exceptedNb, res.size());
    }

    @Mock
    private SalarieAideADomicileRepository salarieAideADomicileRepository;
    @InjectMocks
    private SalarieAideADomicileService salarieService = new SalarieAideADomicileService();
    @Test
    public void testAjouteConge() throws SalarieException {
        // Given :
        SalarieAideADomicile monSalarie = new SalarieAideADomicile("Paul",
                LocalDate.of(2022, 6, 28), LocalDate.of(2023, 11, 1),
                9, 2.5,
                80, 20, 8);
        // When :
        salarieService.ajouteConge(monSalarie, LocalDate.of(2024, 12, 17),
                LocalDate.of(2024, 12, 18));
        // Then :
        ArgumentCaptor<SalarieAideADomicile> salarieAideADomicileCaptor = ArgumentCaptor.forClass(SalarieAideADomicile.class);
        Mockito.verify(salarieAideADomicileRepository, Mockito.times(1)).save(salarieAideADomicileCaptor.capture());
        Assertions.assertEquals(1L, salarieAideADomicileCaptor.getValue().getCongesPayesPrisAnneeNMoins1());
    }


}


