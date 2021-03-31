/**
 * 
 */
package com.student.portal.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.portal.model.User;

/**
 * @author Bageeradha
 *
 */
public interface UserRepository  extends JpaRepository<User, Long>{

}
