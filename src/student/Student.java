
package student;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Student {
    private final SimpleIntegerProperty sNO;
    private final SimpleStringProperty regNo;
    private final SimpleStringProperty name;
    private final SimpleStringProperty fName;
    private final SimpleStringProperty dob;
    private final SimpleStringProperty gender;
    private final SimpleStringProperty cnic;
    private final SimpleStringProperty batch;
    private final SimpleStringProperty session;
    private final SimpleStringProperty degreeProg;
    private final SimpleStringProperty degreeYear;
    private final SimpleStringProperty date;
    private final SimpleStringProperty contact;
    private final SimpleStringProperty Father_contact;
    private final SimpleStringProperty email;
    private final SimpleStringProperty domicile;
    private final SimpleStringProperty cur_Address;
    private final SimpleStringProperty per_Address;

    public Student(Integer ssNO, String sregNo, String sname, String sfName, String sdob, 
            String sgender, String scnic, String sbatch, String ssession, String sdegreeProg, 
            String sdegreeYear, String sdate, String scontact, String sFather_contact, 
            String semail, String sdomicile, String scur_Address, String sper_Address) {
        
        this.sNO = new SimpleIntegerProperty(ssNO);
        this.regNo = new SimpleStringProperty(sregNo);
        this.name = new SimpleStringProperty(sname);
        this.fName = new SimpleStringProperty(sfName);
        this.dob = new SimpleStringProperty(sdob);
        this.gender = new SimpleStringProperty(sgender);
        this.cnic = new SimpleStringProperty(scnic);
        this.batch = new SimpleStringProperty(sbatch);
        this.session = new SimpleStringProperty(ssession);
        this.degreeProg = new SimpleStringProperty(sdegreeProg);
        this.degreeYear = new SimpleStringProperty(sdegreeYear);
        this.date = new SimpleStringProperty(sdate);
        this.contact = new SimpleStringProperty(scontact);
        this.Father_contact = new SimpleStringProperty(sFather_contact);
        this.email = new SimpleStringProperty(semail);
        this.domicile = new SimpleStringProperty(sdomicile);
        this.cur_Address = new SimpleStringProperty(scur_Address);
        this.per_Address = new SimpleStringProperty(sper_Address);
    }

    public int getSNO() {
        return sNO.get();
    }

    public void setSNO(int sNO) {
        this.sNO.set(sNO);
    }

    public String getRegNo() {
        return regNo.get();
    }

    public void setRegNo(String regNo) {
        this.regNo.set("regNo");
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set("name");
    }

    public String getFName() {
        return fName.get();
    }

    public void setFName(String fName) {
        this.fName.set("fName");
    }

    public String getDob() {
        return dob.get();
    }

    public void setDob(String dob) {
        this.dob.set("dob");
    }

    public String getGender() {
        return gender.get();
    }

    public void setGender(String gender) {
        this.gender.set("gender");
    }

    public String getCnic() {
        return cnic.get();
    }

    public void setCnic(String cnic) {
        this.cnic.set("cnic");
    }

    public String getBatch() {
        return batch.get();
    }

    public void setBatch(String batch) {
        this.batch.set("batch");
    }

    public String getSession() {
        return session.get();
    }

    public void setSession(String session) {
        this.session.set("session");
    }

    public String getDegreeProg() {
        return degreeProg.get();
    }

    public void setDegreeProg(String degreeProg) {
        this.degreeProg.set("degreeProg");
    }

    public String getDegreeYear() {
        return degreeYear.get();
    }

    public void setDegreeYear(String degreeYear) {
        this.degreeYear.set("degreeYear");
    }

    public String getDate() {
        return date.get();
    }

    public void setDate(String date) {
        this.date.set("date");
    }

    public String getContact() {
        return contact.get();
    }

    public void setContact(String contact) {
        this.contact.set("contact");
    }

    public String getFather_contact() {
        return Father_contact.get();
    }

    public void setFather_contact(String Father_contact) {
        this.Father_contact.set("Father_contact");
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set("email");
    }

    public String getDomicile() {
        return domicile.get();
    }

    public void setDomicile(String domicile) {
        this.domicile.set("domicile");
    }

    public String getCur_Address() {
        return cur_Address.get();
    }

    public void setCur_Address(String cur_Address) {
        this.cur_Address.set("cur_Address");
    }

    public String getPer_Address() {
        return per_Address.get();
    }

    public void setPer_Address(String per_Address) {
        this.per_Address.set("per_Address");
    }
    
    
}
