import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<String>();
        addInOrder(linkedList, "Togo");
        addInOrder(linkedList, "Ghana");
        addInOrder(linkedList, "Mali");
        addInOrder(linkedList, "USA");
        addInOrder(linkedList, "UK");
        addInOrder(linkedList, "Rusia");
        printList(linkedList);
        visit(linkedList);

        // printList(linkedList);

        // ArrayList<String> list = new ArrayList<String>();
        // list.add("man");
        // System.out.println(list.isEmpty());
        // String man = "";
        // System.out.println(man.isEmpty());

    }

    public static void printList(LinkedList<String> linkedList){
        Iterator<String> list = linkedList.iterator();
        while (list.hasNext()) {
            System.out.println("am visiting " + list.next());
        }
        System.out.println("===============");
    }

    public static boolean addInOrder(LinkedList<String> linkedList, String name){
        ListIterator<String> stringListIterator = linkedList.listIterator();
        while (stringListIterator.hasNext()) {
            int comparision = stringListIterator.next().compareTo(name);
            if (comparision == 0) {
                // they are equall
                System.out.println(name + " is already included");
            } else if(comparision > 0) {
                //new name should appear before this one
                stringListIterator.previous();
                stringListIterator.add(name);
                return true;
            } else {
                // move on to next city
            }
        }
       stringListIterator.add(name);
       return true;
    }

    public static void visit(LinkedList cities){
        Scanner scanner = new Scanner(System.in);
        boolean quite = false ;
        ListIterator<String> listIterator = cities.listIterator();

        if (cities.isEmpty()) {
            System.out.println("No cities in the itemerary");
            scanner.close();
            return;
        } 
        else {
            printMenu();
            System.out.println("Now visiting " + listIterator.next());
        }
        while(!quite) {
            boolean goingForward = true;
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Holiday (Vacation) over");
                    quite = true;
                    break;
                case 1:
                    // checking if we went back before trying to go forwaard now 
                    // if yes then we will have to call listIterator.next() twice before we can move 
                    // forward
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                             listIterator.next();
                        }
                        goingForward = true;
                    }

                    if (listIterator.hasNext()) {
                        System.out.println("Now visiting " + listIterator.next());
                    } else {
                        System.out.println("Reached the end of the list");
                        goingForward = false;
                    }
                    break;
                case 2:
                    // checking if we went forward before trying to go backward now 
                    // if yes then we will have to call listIterator.previous() twice before we can move 
                    // backward
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }

                    if (listIterator.hasPrevious()) {
                        System.out.println("Now visiting " + listIterator.previous());
                    } else {
                        System.out.println("We are at the start of the list");
                        goingForward = true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }
        scanner.close();
    }

    public static void printMenu(){
        System.out.println("Avaliable action \n press");
        System.out.println("0 - to quite \n" +
                            "1 - go to next city \n" +
                            "2 - go to previous city \n" +
                            "3 - print menu option");
    }

}
