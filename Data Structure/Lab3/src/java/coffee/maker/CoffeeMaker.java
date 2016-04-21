/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffee.maker;

/**
 *
 * @author The BigBang
 */
public class CoffeeMaker {
    private boolean state;
    private int water_amount;
    private int coffee_amount;
    private int cup_size;
    

    public CoffeeMaker() {
        fillWater(80);
        fillCoffee(40);

    }

    public void fillWater(int wateram) {
        this.water_amount = wateram;
    

    }

    public void fillCoffee(int coffeefill) {
        this.coffee_amount = coffeefill;
       

    }

    /**
     * @return the state
     */
    public boolean isState() {
        return state;
    }

    /**
     * @return the water_amount
     */
    public int getWater_amount() {
        if(this.water_amount==0){
            System.out.println("Please refill");
        }
        this.water_amount=this.water_amount-5;
        return this.water_amount;
    }

   
    public int getCoffee_amount() {
         if(this.coffee_amount==0){
            System.out.println("Please refill");
        }
        this.coffee_amount=this.coffee_amount-2;
        return this.coffee_amount;
    }

    public void coffeebrewing() {
        
        
        
        
       
        if (isState() == false) {
            System.out.println("Coffee machine is On...");
        } else {

        }
        if (getCoffee_amount() == 0) {
            System.out.println("Refill the Coffee");

        }
        if (getWater_amount() == 0) {
            System.out.println("Refill the Water");

        }

        System.out.println("The amount of Water in the machine: " + getWater_amount() + " ml" + "\nThe amount of Coffee in the machine: " + getCoffee_amount() + " gm" + "\n Select your Drink....");
        

    }
    
    
}
