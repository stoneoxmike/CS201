import java.util.ArrayList;

// Array and ArrayList application
public class ArrayExample {
    public static void main(String[] args) {
        // Create REFERENCE to array of ints
        int[] heaps;

        // Allocate array of int OBJECT
        //     elements initialized to 0
        heaps = new int[6];
        System.out.println("heaps[0] = " + heaps[0]);

        // Indexed starting at 0 (like C)
        heaps[0] = 15;
        System.out.println("heaps[0] = " + heaps[0]);

        // Create REFERENCE to array of ints
        int[] a;
        //System.out.println("a[0] = " + a[0]);

        // Both references to same array object
        a = heaps;
        System.out.println("a[0] = " + a[0]);

        // Changing element in a also changes in heaps
        a[0] = 7;
        System.out.println("a[0] = " + a[0]);
        System.out.println("heaps[0] = " + heaps[0]);

        String[] words = new String[4];
        words[0] = "Arrays";
        words[1] = "know";
        words[2] = "their";
        words[3] = "length";

        // Don't need to pass length to methods (if using ENTIRE array)
        System.out.println(concat(words));

        // Create REFERENCE to array of Coins (elements initialized to null)
        Coins[] wallet = new Coins[2];
        //System.out.println(wallet[0].findCentsValue());

        // Allocate array OBJECTS
        wallet[0] = new Coins(0, 0, 0, 0);
        wallet[1] = new Coins(1, 1, 1, 1);

        // Call methods on array ELEMENTS (objects)
        for (int i = 0; i < wallet.length; i++) {
            System.out.println("Coins " + i + ": " + wallet[i].findCentsValue());
        }


        // Create (empty) ArrayList of Strings
        ArrayList<String> emailList = new ArrayList<>();

        // Add elements to ArrayList (dynamically)
        emailList.add("jane_smith@yahoo.com");
        emailList.add("sally.jones@gmail.com");
        emailList.add("ben456@evilhacker.com");

        // Get elements from ArrayList by index (note .size() method)
        for (int i = 0; i < emailList.size(); i++) {
            String email = emailList.get(i);
            System.out.println(email);
        }

        // Update element at an index using set
        System.out.println("\nUpdate Jane's email address");
        String oldEmail = "jane_smith@yahoo.com";
        String newEmail = "jane_smith@us.ibm.com";
        for (int i = 0; i < emailList.size(); i++) {
            String email = emailList.get(i);
            if (email.equals(oldEmail)) {
                emailList.set(i, newEmail);
            }
        }
        // Get elements from ArrayList by index (note .size() method)
        for (int i = 0; i < emailList.size(); i++) {
            String email = emailList.get(i);
            System.out.println(email);
        }

        // Find emails @evilhacker.com and store references in new ArrayList
        System.out.println("\nRemove @evilhacker.com emails");
        ArrayList<String> toRemove = new ArrayList<String>();
        for (int i = 0; i < emailList.size(); i++) {
            String email = emailList.get(i);
            if (email.endsWith("@evilhacker.com")) {
                // mark this address for removal
                toRemove.add(email);
            }
        }
        // SAFELY remove emails
        emailList.removeAll(toRemove);
        // Get elements from ArrayList by index (note .size() method)
        for (int i = 0; i < emailList.size(); i++) {
            String email = emailList.get(i);
            System.out.println(email);
        }


    }

	public static String concat(String[] arr) {
        String s = "";
        // Arrays know their (total) length
        for (int i = 0; i < arr.length; i++) {
            s += arr[i] + " ";
        }
        return s;
    }
}
