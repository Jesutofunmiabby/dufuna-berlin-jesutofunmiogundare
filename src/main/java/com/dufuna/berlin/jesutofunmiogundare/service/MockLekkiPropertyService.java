package com.dufuna.berlin.jesutofunmiogundare.service;

import com.dufuna.berlin.jesutofunmiogundare.model.LekkiProperty;

public class MockLekkiPropertyService implements LekkiPropertyService {

    @Override
    public void saveProperty(LekkiProperty property) {
        System.out.println("MockLekkiPropertyService.saveProperty called");
    }

    @Override
    public LekkiProperty getProperty(String propertyId) {
        System.out.println("MockLekkiPropertyService.getProperty called");
        return null;
    }
}
