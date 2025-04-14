package services;


public interface TaxService {

    double getTaxes();

    default Double afterTaxes(Double days, Double valuePerDay, double taxes) {
        return days * valuePerDay * getTaxes();
    }

}
