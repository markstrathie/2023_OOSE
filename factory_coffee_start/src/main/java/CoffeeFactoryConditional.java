public class CoffeeFactoryConditional {

    private Coffee CoffeeStore(String typeOfCoffee){
        Coffee coffee;

        if (typeOfCoffee == CoffeeType.americano) {
            coffee = new Americano();
        } else if (typeOfCoffee == CoffeeType.cappuccino) {
            coffee = new Cappuccino();
        } else if (typeOfCoffee == CoffeeType.espresso) {
            coffee = new Espresso();
        } else if (typeOfCoffee == CoffeeType.flatWhite) {
            coffee = new FlatWhite();
        } else if (typeOfCoffee == CoffeeType.mocha) {
            coffee = new Mocha();
        }
        else {
            coffee = new Americano();
        }
        return coffee;
    }
}
