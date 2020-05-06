package com.cg.GreatOutdoor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.GreatOutdoor.entity.AllProducts;
import com.cg.GreatOutdoor.entity.User;
@Repository
@Transactional
public class UserDaoImpl implements IUserDao{
	@PersistenceContext
   private  EntityManager entityManager;
	
	
	
	/**********************************
     *Method:        create(User user)
     *description:   save the user in the database
     *parameter:     Take User object in parameter
     *created by:    Raman Pandey
     *created date:  26-APR-2020
      **********************************/
	@Override
	public void create(User user) {
		// TODO Auto-generated method stub
		System.out.println("INSIDE create user function");
		entityManager.persist(user);
		
	}
	
	
	
	/**********************************
     *Method:        retrive()
     *description:   it display all user
     *@returns       List of user
     *created by     Raman Pandey
     *created date   26-APR-2020
     **********************************/
	@Override
	public List reterive() {
		// TODO Auto-generated method stub
		String allUserQuery="SELECT allusers FROM User allusers";
		TypedQuery<User> query=entityManager.createQuery(allUserQuery,User.class);
		return query.getResultList();
		
	}
	
	
	
	   /**********************************
     *Method:        findById
     *description:   display the paticular record by id
     *productId:     fetches the details of that particular id
     *@returns:      user detail
     *created by:    Raman Pandey
     *created date:  26-APR-2020
**********************************/
	@Override
	public User findById(long userId) {
		// TODO Auto-generated method stub
		User user= entityManager.find(User.class, userId);
		System.out.println(user);
		return user;
	}

	
	   /**********************************
     *Method:        checkUserId(long userId)
     *description:   check the user exist or not
     *parameter:     accept userId as a parameter
     *@returns:      true if not exist otherwise false
     *created by:    Raman Pandey
     *created date:  26-APR-2020
**********************************/
	@Override
	public boolean checkUserId(long userId) {
		// TODO Auto-generated method stub
		System.out.println("IN USERDAO        UID= "+userId);
		if(entityManager.find(User.class, userId)!=null)
		{  System.out.println("true");
			return true;
		}
		else
		{
		return false;
		}
	}

   
}
