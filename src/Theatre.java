import java.util.*;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Theatre {
    static ArrayList<Ticket>tickets=new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("Welcome to the new Theatre!");
        //task2-menu
        Scanner input = new Scanner(System.in);
        int option = -1;
        while (option != 0) {
            System.out.println("""
                    Please select an option:
                    1) Buy a ticket
                    2) Print seating area
                    3) Cancel ticket
                    4) List available seats
                    5) Save to file
                    6) Load from file
                    7) Print ticket information and total price
                    8) Sort tickets by price
                    0) Quit
                    ------------------------------------------------------""");
            System.out.print("\nselect your option:");
            try {
                option = input.nextInt();
                try{
                    switch (option) {
                        case 1:
                            System.out.println("Option 1 selected: Buy a ticket");
                            Options.buy_ticket(tickets);

                            break;
                        case 2:
                            System.out.println("Option 2 selected: Print seating area");
                            System.out.println();
                            System.out.println("        " + "************************");
                            System.out.println("        " + "*" + "         " + "STAGE" + "        " + "*");
                            System.out.println("        " + "************************");

                            System.out.print("        ");
                            Options.print_seating_area(Options.row1);
                            System.out.print("    ");
                            Options.print_seating_area(Options.row2);
                            Options.print_seating_area(Options.row3);
                            System.out.println();

                            break;
                        case 3:
                            System.out.println("Option 3 selected: Cancel ticket");
                            Options.cancel_ticket(tickets);
                            break;
                        case 4:
                            System.out.println("Option 4 selected: List available seats");
                            Options.show_available();
                            break;
                        case 5:
                            System.out.println("Option 5 selected: Save to file");
                            Options.save();
                            break;
                        case 6:
                            System.out.println("Option 6 selected: Load from file");
                            Options.load();
                            break;
                        case 7:
                            System.out.println("Option 7 selected: Print ticket information and total price");
                            Options.show_tickets_info(tickets);
                            break;
                        case 8:
                            System.out.println("Option 8 selected: Sort tickets by price");
                            ArrayList<Ticket> sortedList = Options.sort_tickets(tickets); //Ticket-hold objects that are instances of the Ticket class.
                            Options.show_tickets_info(sortedList);
                            break;
                        case 0:
                            System.out.println("Option 0 selected: Quit");
                            break;
                        default:
                            System.out.println("Invalid option. Please select again.");
                            break;
                    }
                }
                catch (InputMismatchException e) {
                    System.out.println("Invalid value!");
                    //input.next(); // clear the input buffer
                    option = -1; // reset the option variable to force another iteration
                }
            }
            catch (InputMismatchException e){
                System.out.println("Invalid option!");
            }
        }
    }
}