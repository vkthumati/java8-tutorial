package com.thumati.corejava.oops;

import java.util.List;

/** 
 * Department class contains list of student Objects. It is associated with student class through its Object(s). 
*/
public class Department{ 
    private String name; 
    private List<Student> students; 
    
    public Department(String name, List<Student> students){ 
        this.name = name; 
        this.students = students; 
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	} 
} 