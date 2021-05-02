package SubClasses;

public abstract class Person {
    private String firstName, lastName, phoneNumber;

    public Person(String firstName, String lastName, String phoneNumber) {
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.matches("[A-Z][A-z]*"))
            this.firstName = firstName;
        else
            throw new IllegalArgumentException("First Name cannot be black");
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.matches("[A-Z][A-z]*"))
            this.lastName = lastName;
        else
            throw new IllegalArgumentException("last name must include at least 2 letters");
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    /**
     * This will validate that the phone number matches the north american dialing plan
     * and set the instance variable
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.matches("\\(?[2-9]\\d{2}\\)?[-\\s]?[2-9]\\d{2}[-\\s]?\\d{4}"))
            this.phoneNumber = phoneNumber;
        else
            throw new IllegalArgumentException("phone # must match North American dialling plan");
    }

    /**
     * This method defines whether or not a person needs both a coffee
     * and a break
     */
    public abstract boolean needsCoffee();
}
