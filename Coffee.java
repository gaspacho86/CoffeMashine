package CoffeeMachine;

enum Coffee {
    ESPRESSO(250, 0, 16, 1, 4),
    LATTE(350, 75, 20, 1, 7),
    CAPPUCCINO(200, 100, 12, 1, 6);

    private final int COST;
    private final int[] requiredSupplies;

    Coffee(int WATER, int MILK, int COFFEE_BEAN, int CUP, int COST) {
        this.COST = COST;
        this.requiredSupplies = new int[]{WATER, MILK, COFFEE_BEAN, CUP};
    }

    String getMissingSupplies() {
        for (int i = 0; i < requiredSupplies.length; i++) {
            if (requiredSupplies[i] > Resources.values()[i].getRemainder()) {
                return Resources.values()[i].name().toLowerCase().replace('_', ' ');
            }
        }
        return "";
    }

    void makePortion() {
        for (int i = 0; i < requiredSupplies.length; i++) {
                Resources.values()[i].subtractFromRemainder(requiredSupplies[i]);
        }
        Resources.MONEY.addToRemainder(COST);
    }
}

