package util;

import services.TaxService;

public class OtherCountriesTaxes implements TaxService {
    private static final double OTAX = 1.10; // Exemplo de outra taxa

    @Override
    public double getTaxes() {
        return OTAX;
    }
}
