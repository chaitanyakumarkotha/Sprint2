package com.cg;




import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.GreatOutdoor.dao.IProductDao;
import com.cg.GreatOutdoor.dao.IUserDao;
import com.cg.GreatOutdoor.dao.UserDaoImpl;
import com.cg.GreatOutdoor.entity.Address;
import com.cg.GreatOutdoor.entity.Product;
import com.cg.GreatOutdoor.entity.WishlistProduct;
import com.cg.GreatOutdoor.entity.User;

@SpringBootApplication
public class GreatOutdoorsSprint2Application  {
  
	public static void main(String[] args)  {
		SpringApplication.run(GreatOutdoorsSprint2Application.class, args);

	}

	
}

