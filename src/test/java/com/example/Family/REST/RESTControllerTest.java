package com.example.Family.REST;

import com.example.Family.Entities.Child;
import com.example.Family.Entities.Family;
import com.example.Family.Entities.Father;
import com.example.Family.FamilyApplication;
import com.example.Family.Repository.ChildRepository;
import com.example.Family.Repository.FamilyRepository;
import com.example.Family.Repository.FatherRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class RESTControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private ChildRepository childRepository;

    @MockBean
    private FatherRepository fatherRepository;

    @MockBean
    private FamilyRepository familyRepository;

    //It's a good way to make a test byt I have a problem when I have e.g 25 records in database.
    @Test
    public void getAllChildren() throws JSONException {
        String responseFromGetAllChildren = testRestTemplate.getForObject("/api/getChildren",String.class);
        System.out.println(responseFromGetAllChildren);
        JSONAssert.assertEquals("[{id:1},{id:2},{id:3},{id:4}]",responseFromGetAllChildren,false);
    }


    @Test
    public void getAllFathers() throws JSONException {
        String responseForGetAllFathers = testRestTemplate.getForObject("/api/getFathers",String.class);
        System.out.println(responseForGetAllFathers);
        JSONAssert.assertEquals("[{id:1},{id:2},{id:3},{id:4}]",responseForGetAllFathers,false);

    }
    @Test
    public void getAllChildrenTest2() throws Exception {

        when(childRepository.findAllChild()).thenReturn(Collections.emptyList());

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/api/getChildren")
                        .accept(MediaType.APPLICATION_JSON)
        ).andReturn();

        System.out.println(mvcResult.getResponse());
        Mockito.verify(childRepository).findAllChild();
    }

    @Test
    public void getAllFathersTest2() throws Exception {

        when(fatherRepository.findAllFathers()).thenReturn(Collections.emptyList());

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/api/getFathers")
                        .accept(MediaType.APPLICATION_JSON)
        ).andReturn();

        System.out.println(mvcResult.getResponse());
        Mockito.verify(fatherRepository).findAllFathers();
    }


    @Test
    public void getFamilyByBirthDateChild() throws Exception {

        String dateToFind = "22-09-2018";

        when(familyRepository.getFamilyByBirthDateChild(dateToFind)).thenReturn(Collections.emptyList());

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/api/getFamilyByBirthDateChild/22-09-2018", Family.class)
                .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andReturn();

        System.out.println(mvcResult.getResponse().toString());

        Mockito.verify(familyRepository).getFamilyByBirthDateChild(dateToFind);
    }

    @Test
    public void getFamilyByPeselChild() throws Exception {

        String peselChildToFind = "12345678910";

        when(familyRepository.getFamilyByPeselChild(peselChildToFind)).thenReturn(Collections.emptyList());

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/api/getFamilyByPeselChild/12345678910", Family.class)
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andReturn();

        System.out.println(mvcResult.getResponse().toString());

        Mockito.verify(familyRepository).getFamilyByPeselChild(peselChildToFind);
    }

    @Test
    public void getFamilyBySexChild() throws Exception {
        String sexChildToFind = "male";

        when(familyRepository.getFamilyBySexChild(sexChildToFind)).thenReturn(Collections.emptyList());

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/api/getFamilyBySexChild/male", Family.class)
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andReturn();

        System.out.println(mvcResult.getResponse().toString());

        Mockito.verify(familyRepository).getFamilyBySexChild(sexChildToFind);

    }

    @Test
    public void getFamilyByFirstNameChild() throws Exception {
        String firstNameToFind = "Jan";

        when(familyRepository.getFamilyByNameChild(firstNameToFind)).thenReturn(Collections.emptyList());

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/api/getFamilyByFirstNameChild/Jan", Family.class)
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andReturn();

        System.out.println(mvcResult.getResponse().toString());

        Mockito.verify(familyRepository).getFamilyByNameChild(firstNameToFind);
    }

    @Test
    public void getFamilyBySecondNameChild() throws Exception {
        String secondNameToFind = "Gwardian";

        when(familyRepository.getFamilyBySecondNameChild(secondNameToFind)).thenReturn(Collections.emptyList());

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/api/getFamilyBySecondNameChild/Gwardian", Family.class)
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andReturn();

        System.out.println(mvcResult.getResponse().toString());

        Mockito.verify(familyRepository).getFamilyBySecondNameChild(secondNameToFind);
    }

    @Test
    public void getAllFamilies() throws Exception {
        when(familyRepository.findAllFamilies()).thenReturn(Collections.emptyList());

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/api/getFamilies", Family.class)
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andReturn();

        System.out.println(mvcResult.getResponse().toString());

        Mockito.verify(familyRepository).findAllFamilies();
    }

    @Test
    public void addFamily() throws Exception {
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

        given(familyRepository.addFamily(family)).willReturn(family);

        mockMvc.perform(post("/api/addFamily")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(status().isCreated());

    }
}