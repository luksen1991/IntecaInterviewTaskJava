package com.example.Family.Repository;

import com.example.Family.Entities.Child;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ChildRepository.class)
public class ChildRepositoryTest {

    @Autowired
    ChildRepository childRepository;

    @Test
    public void testFindAllChildren(){
        int expectedValue =1;
        List<Child> listChild = childRepository.findAllChild();
        System.out.println("Val: "+listChild.size());
        assertEquals(expectedValue,listChild.size());
    }
}