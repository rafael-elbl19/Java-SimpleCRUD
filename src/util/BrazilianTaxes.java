package util;

import services.TaxService;

public class BrazilianTaxes implements TaxService {
    private static final double BTAX = 1.00;

    @Override
    public double getTaxes() {
        return BTAX;
    }
    public double afterTaxes(double days, double valuePerDay, double taxes) {
        return days * valuePerDay * taxes;
    }
}
