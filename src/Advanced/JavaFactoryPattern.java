package Advanced;

import java.util.Scanner;

/**
 * According to Wikipedia, a factory is simply an object that returns another
 * object from some other method call, which is assumed to be "new".
 * 
 * In this problem, you are given an interface Food. There are two classes Pizza
 * and Cake which implement the Food interface, and they both contain a method
 * getType().
 * 
 * The main function in the Main class creates an instance of the FoodFactory
 * class. The FoodFactory class contains a method getFood(String) that returns a
 * new instance of Pizza or Cake according to its parameter.
 * 
 * You are given the partially completed code in the editor. Please complete the
 * FoodFactory class.
 * 
 * Sample Input 1
 * 
 * cake
 * 
 * Sample Output 1
 * 
 * The factory returned class Cake
 * Someone ordered a Dessert!
 * 
 * Sample Input 2
 * 
 * pizza
 * 
 * Sample Output 2
 * 
 * The factory returned class Pizza
 * Someone ordered Fast Food!
 */

public class JavaFactoryPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FoodFactory ff = new FoodFactory();
        Food f = ff.getFood(sc.nextLine());
        f.getType();
        sc.close();
    }
}

interface Food {
    public void getType();
}

class Pizza implements Food {
    @Override
    public void getType() {
        System.out.println("The factory returned class " + this.getClass().getSimpleName());
        System.out.println("Someone ordered a Fast Food!");
    }
}

class Cake implements Food {
    @Override
    public void getType() {
        System.out.println("The factory returned class " + this.getClass().getSimpleName());
        System.out.println("Someone ordered a Dessert!");
    }
}

class FoodFactory {
    public Food getFood(String s) {
        Food f = null;
        switch (s) {
            case "cake":
                f = new Cake();
                break;
            case "pizza":
                f = new Pizza();
                break;
        }
        return f;
    }
}
