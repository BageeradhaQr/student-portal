/**
 * 
 */
package com.student.portal.vo;

/**
 * @author Bageeradha
 *
 */
public class StudentLoginResponseVO extends ResponseVO {
	
	private String firstName;
	
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
