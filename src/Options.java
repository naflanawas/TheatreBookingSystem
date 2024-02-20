import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Options {
    static int[] row1 = new int[12];
    static int[] row2 = new int[16];
    static int[] row3 = new int[20];
    public static final int total_row = 3; //final-immutable,public-can access from anywhere//cancel_ticket
    public static final int[] seats_per_row = {12, 16, 20};//used in buy_ticket and cancel_ticket
    public static final int discount=20;




    public static void buy_ticket(ArrayList<Ticket> tickets) {  //parameter passed to access Ticket objects in the list
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the required row number (1-3): ");
        int row_Num = input.nextInt();
        if (row_Num < 1 || row_Num > 3) {
            System.out.println("Invalid row number! Enter a number between 1 and 3:");
            while (row_Num < 1 || row_Num > 3) {
                System.out.print("Enter the required row number (1-3): ");
                row_Num = input.nextInt();
            }
        }
        System.out.print("Enter the required seat number (1-" + seats_per_row[row_Num - 1] + "): ");
        int seat_Num = input.nextInt();
        if (seat_Num < 1 || seat_Num > seats_per_row[row_Num - 1]) {
            System.out.println("Invalid seat number! Enter a number between 1 and " + seats_per_row[row_Num - 1] + ":");
            while (seat_Num < 1 || seat_Num > seats_per_row[row_Num - 1]) {
                System.out.print("Enter the required seat number (1-" + seats_per_row[row_Num - 1] + "): ");
                seat_Num = input.nextInt();
            }
        }
        int[] row_select = row_Num == 1 ? row1 : (row_Num == 2 ? row2 : row3);//Ternary operator//w3schools//
        if (row_select[seat_Num - 1] == 1) {
            System.out.println("Seat " + seat_Num + " in row " + row_Num + " is already booked.");
            try {
                while ((row_select[seat_Num - 1] == 1)) {
                    System.out.print("Enter the required seat number (1-" + seats_per_row[row_Num - 1] + "): ");
                    seat_Num = input.nextInt();
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid seat number!" +
                        "\nEnter the required seat number (1-" + seats_per_row[row_Num - 1] + "): ");
                seat_Num = input.nextInt();
            }
        }
        row_select[seat_Num - 1] = 1;
        System.out.print("Enter your name: ");
        String name = input.next();
        System.out.print("Enter your surname: ");
        String surname = input.next();
        System.out.print("Enter your Email address: ");
        String email = input.next();

        System.out.print("Enter your price(numbers should be entered)): ");
        double price = Double.parseDouble(input.next()); //method call that takes a String input from the user  and converts it to a double value.
        double newprice=price*(discount/100);
        System.out.println("new price:"+newprice);
        Person person = new Person(name, surname, email);
        Ticket ticket = new Ticket(row_Num, seat_Num, person, price);
        tickets.add(ticket);
        System.out.println("Seat " + seat_Num + " in row " + row_Num + " has been booked." + "\n------------------------------------------------------");
    }

    public static void print_seating_area(int[] rowarray) {

        for (int i = 0; i < rowarray.length; i++) {

            if (i == rowarray.length / 2) {
                System.out.print("  ");
            }
            if (rowarray[i] == 1) {
                System.out.print("X ");
            } else {
                System.out.print("O ");
            }
        }
        System.out.println();
    }

    public static void cancel_ticket(ArrayList<Ticket> tickets) {
        Scanner input = new Scanner(System.in);
        int row_number;
        int seat_number;
        while (true) {
            System.out.print("Insert your row number (1-" + total_row + "): ");
            row_number = input.nextInt();
            if (row_number < 1 || row_number > total_row) {
                System.out.println("Invalid row number!");
                continue; //skip the current iteration and move to the next iteration
            }
            System.out.print("Insert your seat number (1-" + seats_per_row[row_number - 1] + "): ");
            seat_number = input.nextInt();
            if (seat_number < 1 || seat_number > seats_per_row[row_number - 1]) {
                System.out.println("Invalid seat number!");
                continue;
            }
            break;
        }
        int[] row = switch (row_number) {
            case 1 -> row1;
            case 2 -> row2;
            case 3 -> row3;
            default -> null;
        };
        if (row[seat_number - 1] == 0) {
            System.out.println("This seat is not occupied.");
        } else {
            row[seat_number - 1] = 0;
            ArrayList<Ticket> ticketsToRemove = new ArrayList<>();  // Create a new ArrayList to store the tickets to remove

            // Iterating over the tickets ArrayList and add any matching tickets to the ticketsToRemove ArrayList
            for (Ticket ticket : tickets) {
                if (ticket.getRow() == row_number && ticket.getSeat() == seat_number) {
                    ticketsToRemove.add(ticket);
                    System.out.println("Your row number " + row_number + " seat number " + seat_number + " ticket has been successfully cancelled.");
                    System.out.println("Cancelled Ticket Details:" + "\n_______________________________" + "\n" + ticket.print()); // print the cancelled ticket details
                }
            }
            tickets.removeAll(ticketsToRemove); // Remove the tickets from the original tickets ArrayList//
            System.out.println();
        }
    }
    public static void show_available() {
        for (int r = 1; r <= 3; r++) {
            int[] row = r == 1 ? row1 : r == 2 ? row2 : row3;
            /*int[] row = null;
            if (r == 0) {
                row = row1;*/
            System.out.print("\n seats available in " + r + "=");
            for (int s = 0; s < row.length; s++) {
                if (row[s] == 0) {
                    System.out.print((s + 1) + ",");
                }
            }
            System.out.println();
        }
    }
    public static void save() {
        try {
            File file = new File("text.txt"); //creating a textfile
            boolean file_created = file.createNewFile();
            System.out.println("File" + " " + file.getName() + " " + "created successfully");
            FileWriter writer = new FileWriter(file);
            writer.write("\n Row 1=");
            for (int j : row1) {
                if (j == 1) {
                    writer.write("1 ");
                } else {
                    writer.write("0 ");
                }
            }
            writer.write(" \n Row 2=");
            for (int j : row2) {
                if (j == 1) {
                    writer.write("1 ");
                } else {
                    writer.write("0 ");
                }
            }
            writer.write(" \n Row 3=");
            for (int j : row3) {
                if (j == 1) {
                    writer.write("1 ");
                } else {
                    writer.write("0 ");
                }
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error while creating the file");
        }
    }
    public static void load() {
        try {
            File file = new File("text.txt");
            Scanner file_reader = new Scanner(file);
            while (file_reader.hasNextLine()) {
                String text = file_reader.nextLine();
                System.out.println(text);
            }
            file_reader.close();
            System.out.println("File loaded successfully");
        } catch (IOException e) {
            System.out.println("Error while reading a file.");
            e.printStackTrace();
        }
    }

    public static void show_tickets_info(ArrayList<Ticket> tickets) {
        System.out.println("Ticket information:");
        double total_price = 0;
        for (Ticket ticket : tickets) {
            double price = ticket.getPrice();
            total_price += price;
            System.out.println(ticket.print());
        }
        System.out.println("_______________________________" + "\nThe total price you have to pay is: $" + total_price);
    }
    public static ArrayList<Ticket> sort_tickets(ArrayList<Ticket> tickets) {
        for (int i = 0; i < tickets.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < tickets.size(); j++) {
                if (tickets.get(j).getPrice() < tickets.get(minIndex).getPrice()) {
                    minIndex = j;
                }
            }
            Ticket temp = tickets.get(i);
            tickets.set(i, tickets.get(minIndex));
            tickets.set(minIndex, temp);
        }
        // Print sorted tickets information
        System.out.println();
        return tickets;
    }
}

