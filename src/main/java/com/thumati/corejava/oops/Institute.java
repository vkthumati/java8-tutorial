package com.thumati.corejava.oops;

import java.util.List;

/** 
 * Institute class contains list of Department Objects. It is associated with Department class through its Object(s).
*/
public class Institute { 
    private String instituteName; 
    private List<Department> departments; 
      
    public Institute(String instituteName, List<Department> departments) { 
        this.instituteName = instituteName; 
        this.departments = departments; 
    } 
      
    // count total students of all departments in a given institute  
    public int getTotalStudentsInInstitute() { 
        int noOfStudents = 0; 
        List<Student> students;  
        for(Department dept : departments) { 
            students = dept.getStudents(); 
            for(Student s : students) { 
                noOfStudents++; 
            } 
        } 
        return noOfStudents; 
    }

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	} 
}  

