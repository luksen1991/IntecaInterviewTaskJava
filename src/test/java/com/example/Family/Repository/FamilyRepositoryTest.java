package com.example.Family.Repository;

import com.example.Family.Entities.Child;
import com.example.Family.Entities.Family;
import com.example.Family.Entities.Father;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = FamilyRepository.class)
public class FamilyRepositoryTest {

    @Autowired
    FamilyRepository familyRepository;

    @Test
    public void addFamily() {

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

		System.out.println("IDF: "+family.getId()+"FamREPGET: "+familyRepository.findAllFamilies().get(family.getId()-1));
		assertEquals(familyRepository.findAllFamilies().get(family.getId()-1).getId(),family.getId());
    }

    @Test
    public void findAllFamilies() {
        int expectedValue = 18;
        List<Family> familyList = familyRepository.findAllFamilies();
        assertEquals(expectedValue,familyList.size());
    }

    @Test
    public void getFamilyByBirthDateChild() {
    }

    @Test
    public void getFamilyByPeselChild() {
    }

    @Test
    public void getFamilyBySexChild() {
    }

    @Test
    public void getFamilyByNameChild() {
    }

    @Test
    public void getFamilyBySecondNameChild() {
    }
}