public class CoffeeStore {

    private CoffeeFactoryConditional coffeeFactoryConditional;

    public CoffeeStore(){
        CoffeeFactoryConditional coffeeFactoryConditional = new CoffeeFactoryConditional();
    }

    private Coffee createCoffee(String typeOfCoffee){
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

    public Coffee orderCoffee(String typeOfCoffee){
        Coffee coffee;
        coffee = createCoffee(typeOfCoffee);

        coffee.prepare();
        coffee.getCoffeeCup();
        coffee.pourCoffee();
        coffee.serve();

        return coffee;
    }

    public static void main(String[] args){
        CoffeeStore coffeeStore = new CoffeeStore();
        Coffee coffee = coffeeStore.orderCoffee(CoffeeType.mocha);
        System.out.println(coffee.getName());
    }

}
