package pl.pjatk.rental_service;

public enum Standard {
    NORMAL(400.0),
    YOUNGTIMER(550.0),
    PREMIUM(700.0);

    private double value;

    Standard(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
