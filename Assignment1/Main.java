package Assignment1;

// Main.java
public class Main {
    public static void main(String[] args) {
        Bag<Integer> myBag = new Bag<>();

        // Adding elements
        myBag.add(1);
        myBag.add(2);
        myBag.add(3);
        System.out.println("After adding: " + myBag.toString());

        // Checking contains
        System.out.println("Contains 2? " + myBag.contains(2));

        // Grabbing a random element
        System.out.println("Grabbing a random element: " + myBag.grab());

        // Checking if the bag is empty
        System.out.println("Is the bag empty? " + myBag.isEmpty());

        // Removing an element
        myBag.remove(2);
        System.out.println("After removing 2: " + myBag.toString());

        // Checking the size
        System.out.println("Size: " + myBag.size());

        // Clearing the bag
        myBag.clear();
        System.out.println("After clearing: " + myBag.toString());

        // Converting to an array
        Object[] array = myBag.toArray();
        System.out.println("Array length after clearing: " + array.length);
    }
}

