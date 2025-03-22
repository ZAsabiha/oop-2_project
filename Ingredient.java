class Ingredient {
    private String name;
    private int quantity;
    private String healthBenefits;

    public Ingredient(String name, int quantity, String healthBenefits) {
        this.name = name;
        this.quantity = quantity;
        this.healthBenefits = healthBenefits;
    }

    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public String getHealthBenefits() { return healthBenefits; }

    @Override
    public String toString() {
        return name + " (Quantity: " + quantity + ") - Benefits: " + healthBenefits;
    }
}

