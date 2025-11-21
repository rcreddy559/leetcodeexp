package com.dp.creational;

public class FluentBuilder {

}

class Pizza {
    private String size;
    private boolean cheese;
    private boolean pepperoni;
    private boolean mushrooms;

    private Pizza() {
        // Private constructor to force the use of the builder
    }

    public static class PizzaBuilder {
        private Pizza pizza;

        public PizzaBuilder() {
            pizza = new Pizza();
        }

        public PizzaBuilder withSize(String size) {
            pizza.size = size;
            return this;
        }

        public PizzaBuilder withCheese(boolean cheese) {
            pizza.cheese = cheese;
            return this;
        }

        public PizzaBuilder withPepperoni(boolean pepperoni) {
            pizza.pepperoni = pepperoni;
            return this;
        }

        public PizzaBuilder withMushrooms(boolean mushrooms) {
            pizza.mushrooms = mushrooms;
            return this;
        }

        public Pizza build() {
            return pizza;
        }
    }

    public static void main(String[] args) {
        Pizza pizza = new PizzaBuilder()
                .withSize("Large")
                .withCheese(true)
                .withPepperoni(true)
                .withMushrooms(true)
                .build();

        System.out.println(pizza);
    }

    @Override
    public String toString() {
        return "Pizza [size=" + size + ", cheese=" + cheese + ", pepperoni=" + pepperoni + ", mushrooms=" + mushrooms
                + "]";
    }

}