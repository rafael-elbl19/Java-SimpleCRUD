package util;

import services.TaxService;

public class BrazilianTaxes implements TaxService {
    @Override
    public Double afterTaxes() {
        return 0.0;
    }
}
