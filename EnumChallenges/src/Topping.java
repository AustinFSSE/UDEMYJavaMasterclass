public enum Topping {
    MUSTARD, PICKLES, BACON, CHEDDAR, TOMATO;

    public double getaPrice() {
        return switch (this) {
            case BACON -> 1.5;
            case CHEDDAR -> 2.0;
            case MUSTARD -> 3.0;
            case PICKLES -> 4.0;
            case TOMATO -> 5.0;
        };
    }
}
