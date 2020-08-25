
package course;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Courses {
    private final SimpleIntegerProperty sNo;
    private final SimpleStringProperty code;
    private final SimpleStringProperty name;
    private final SimpleStringProperty creditHrs;

    public Courses(Integer ssNo, String ccode, String nname, String ccreditHrs) {
        this.sNo = new SimpleIntegerProperty(ssNo);
        this.code = new SimpleStringProperty(ccode);
        this.name = new SimpleStringProperty(nname);
        this.creditHrs = new SimpleStringProperty(ccreditHrs);
    }

    public int getSNo() {
        return sNo.get();
    }

    public void setSNo(int sNo) {
        this.sNo.set(sNo);
    }
    
    public String getCode() {
        return code.get();
    }

    public void setCode(String code) {
        this.code.set(code);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getCreditHrs() {
        return creditHrs.get();
    }

    public void setCreditHrs(String creditHrs) {
        this.creditHrs.set(creditHrs);
    }
}
