package com.example.Family;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.Family.Entities.Child;
import com.example.Family.Entities.Family;
import com.example.Family.Entities.Father;
import com.example.Family.Repository.FamilyRepository;

@SpringBootApplication
@ComponentScan
public class FamilyApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(FamilyApplication.class, args);
	}

	 @Autowired
	 FamilyRepository familyRepository;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Father father = new Father();
		Child child1 = new Child();
		Family family = new Family();

		child1.setFirstName("Jan");
		child1.setSecondName("Gwardian");
		child1.setPesel("12345678910");
		child1.setBirthDate(new Date());
		child1.setSex("male");
		child1.setFamily(family);

		father.setFirstName("Jan");
		father.setSecondName("Szpyt");
		father.setBirthDate(new Date());
		father.setPesel("9999");
		father.setFamily(family);

		List<Child> listChild = new ArrayList<Child>();
		listChild.add(child1);

		family.setFather(father);
		family.setChildList(listChild);
		familyRepository.addFamily(family);
		
		
	}
}
