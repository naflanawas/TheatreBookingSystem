public class Person {
    private String name;
    private String surname;
    private String email;

    public Person(String name,String surname,String email){   //constructor used to create and initialize objects//
        this.name=name;                                        //constructors are not static because they are associated with an instance of the class,not the class itself//
        this.surname=surname;
        this.email=email;

    }
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }
}
