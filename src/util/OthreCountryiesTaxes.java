package util;

import services.TaxService;

public class OthreCountryiesTaxes implements TaxService {
    @Override
    public Double afterTaxes() {
        return 0.0;
    }
}
