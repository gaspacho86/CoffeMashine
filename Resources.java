package CoffeeMachine;

enum Resources {
    WATER(400),
    MILK(540),
    COFFEE_BEANS(120),
    DISPOSABLE_CUPS(9),
    MONEY(550);

    private int remainder;

    Resources(int remainder) {
        this.remainder = remainder;
    }

    int getRemainder() {
        return this.remainder;
    }

    void subtractFromRemainder(int number) {
        this.remainder -= number;
    }

    void addToRemainder(int number) {
        this.remainder += number;
    }
}
