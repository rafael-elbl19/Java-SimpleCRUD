package util;

import services.TaxService;

public class OtherCountriesTaxes implements TaxService {
    private static final double OTAX = 1.10; // Exemplo de outra taxa

    @Override
    public double getTaxes() {
        return OTAX;
    }
    public double afterTaxes(double days, double valuePerDay, double taxes) {
        return days * valuePerDay * taxes;
    }
}
