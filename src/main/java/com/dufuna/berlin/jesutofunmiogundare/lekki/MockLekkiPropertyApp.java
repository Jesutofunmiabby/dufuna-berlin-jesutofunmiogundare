package com.dufuna.berlin.jesutofunmiogundare.lekki;

import com.dufuna.berlin.jesutofunmiogundare.model.LekkiProperty;
import com.dufuna.berlin.jesutofunmiogundare.service.LekkiPropertyService;
import com.dufuna.berlin.jesutofunmiogundare.service.MockLekkiPropertyService;

import java.time.LocalDate;

public class MockLekkiPropertyApp {

    public static void main(String[] args) {
        LekkiProperty property = new LekkiProperty();
        property.setPropertyId("LK-001");
        property.setAddress("12 Admiralty Way, Lekki Phase 1, Lagos");
        property.setType("Duplex");
        property.setNumberOfBedrooms(4);
        property.setNumberOfSittingRooms(2);
        property.setNumberOfKitchens(1);
        property.setNumberOfBathrooms(4);
        property.setNumberOfToilets(5);
        property.setOwner("Jesutofunmi Ogundare");
        property.setDescription("Fully detached duplex with BQ");
        property.setValidFrom(LocalDate.of(2026, 1, 1));
        property.setValidTo(LocalDate.of(2026, 12, 31));

        LekkiPropertyService service = new MockLekkiPropertyService();
        service.saveProperty(property);
        service.getProperty(property.getPropertyId());
    }
}
