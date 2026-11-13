package com.dufuna.berlin.jesutofunmiogundare.service;

import com.dufuna.berlin.jesutofunmiogundare.model.LekkiProperty;

public interface LekkiPropertyService {

    void saveProperty(LekkiProperty property);

    LekkiProperty getProperty(String propertyId);
}
