
package course;

public class Course_CurSemester {
    private Integer sNo;
    private String code;
    private String name;
    private String creditHrs;

    public Course_CurSemester(Integer sNo, String code, String name, String creditHrs) {
        this.sNo = sNo;
        this.code = code;
        this.name = name;
        this.creditHrs = creditHrs;
    }

    public Integer getSNo() {
        return sNo;
    }

    public void setSNo(Integer sNo) {
        this.sNo = sNo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreditHrs() {
        return creditHrs;
    }

    public void setCreditHrs(String creditHrs) {
        this.creditHrs = creditHrs;
    }
    
}
