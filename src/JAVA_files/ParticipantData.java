/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JAVA_files;

/**
 *
 * @author LENOVO
 */
public class ParticipantData {
    private Integer ID;
    private String FirstName;
    private String LastName;
    private Integer PhoneNumber;
    private String Address;
    private String Email;
    private String University_school;
    private Boolean Fees;
    
     public ParticipantData(Integer ID, String FirstName, String LastName, 
                            Integer PhoneNumber, String Address, String Email,
                            String University_school, Boolean Fees) {
        this.ID = ID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.PhoneNumber = PhoneNumber;
        this.Address = Address;
        this.Email = Email;
        this.University_school = University_school;
        this.Fees = Fees;
    }
       public Integer getID() {
        return ID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public Integer getPhoneNumber() {
        return PhoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public String getEmail() {
        return Email;
    }

    public String getUniversity_school() {
        return University_school;
    }

    public Boolean getFees() {
        return Fees;
    }
}
