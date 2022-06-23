package banking;

import java.util.Objects;

/**
 * The concrete Account holder of Person type.
 */
public class Person extends AccountHolder {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName, int idNumber) {
        super(idNumber);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Person otherPerson = (Person) other;
        return this.firstName.equals(otherPerson.firstName)
                && this.lastName.equals(otherPerson.lastName)
                && this.getIdNumber() == otherPerson.getIdNumber();
    }
}
