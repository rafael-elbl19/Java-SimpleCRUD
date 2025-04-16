package services;


public interface TaxService {

    double getTaxes();

    default Double afterTaxes(Double days, Double valuePerDay) {
        return days * valuePerDay * getTaxes();
    }

}
