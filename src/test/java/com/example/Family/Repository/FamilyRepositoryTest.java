package com.example.Family.Repository;

import com.example.Family.Entities.Child;
import com.example.Family.Entities.Family;
import com.example.Family.Entities.Father;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = FamilyRepository.class)
//@DataJpaTest
public class FamilyRepositoryTest {

    @Autowired
    private FamilyRepository familyRepository;

//    @Autowired
//    private TestEntityManager testEntityManager;

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
        int expectedValue = 4;
        List<Family> familyList = familyRepository.findAllFamilies();
        assertEquals(expectedValue,familyList.size());
    }

    @Test
    public void getFamilyByBirthDateChild() throws ParseException {
        int expectedValue=4;
        String date = "22-09-2018";
        List<Family> familyList = familyRepository.getFamilyByBirthDateChild(date);
        assertEquals(expectedValue,familyList.size());
    }

    @Test
    public void getFamilyByPeselChild() {
        int expectedValue=2;
        String pesel = "12345678910";
        List<Family> familyList = familyRepository.getFamilyByPeselChild(pesel);
        assertEquals(expectedValue,familyList.size());
    }

    @Test
    public void getFamilyBySexChildMale() {
        int expectedValue = 4;
        String sex = "male";
        List<Family> familyList = familyRepository.getFamilyBySexChild(sex);
        assertEquals(expectedValue,familyList.size());
    }

    @Test
    public void getFamilyBySexChildFemale() {
        int expectedValue = 0;
        String sex = "female";
        List<Family> familyList = familyRepository.getFamilyBySexChild(sex);
        assertEquals(expectedValue,familyList.size());
    }

    @Test
    public void getFamilyByNameChild() {
        int expectedValue = 4;
        String firstName = "Jan";
        List<Family> familyList = familyRepository.getFamilyByNameChild(firstName);
        assertEquals(expectedValue,familyList.size());
    }
    @Test
    public void getFamilyByNameChildWhichNotExist() {
        int expectedValue = 0;
        String firstName = "Tomasz";
        List<Family> familyList = familyRepository.getFamilyByNameChild(firstName);
        assertEquals(expectedValue,familyList.size());
    }

    @Test
    public void getFamilyBySecondNameChild() {
        int expectedValue = 4;
        String secondName = "Gwardian";
        List<Family> familyList = familyRepository.getFamilyBySecondNameChild(secondName);
        assertEquals(expectedValue,familyList.size());
    }

    @Test
    public void getFamilyBySecondNameChildWhichNotExist() {
        int expectedValue = 0;
        String secondName = "Gward";
        List<Family> familyList = familyRepository.getFamilyByNameChild(secondName);
        assertEquals(expectedValue,familyList.size());
    }
}