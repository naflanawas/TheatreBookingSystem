public class Ticket {
    private int row; //instance variables
    private int seat;
    private double price;
    private Person person;
    private double newprice;


    public Ticket(int row, int seat, Person person, double price) {     // Constructor
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }
    //getter methods
    public int getRow() { // //Defines a public method named getRow() that returns the value of the private variable row.

        return row;
    }
    public int getSeat() {

        return seat;
    }
    public double getPrice() {

        return this.price;
    }
    public Person getPerson() {

        return person;
    }



    public String print() {
        String name = person.getName();
        String surname = person.getSurname();
        String email = person.getEmail();

        return ("\nName:" + name + " " + "\nSurname:" + surname + " " + "\nemail:" + email + " " +
                "\nRow:" + row + " " + "\nSeat:" + seat + " " + "\nPrice:$" + price );


    }
}