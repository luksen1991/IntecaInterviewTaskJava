package com.example.Family.Repository;

import com.example.Family.Entities.Father;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = FatherRepository.class)
public class FatherRepositoryTest {

    @Autowired
    private FatherRepository fatherRepository;

    @Test
    public void findAllFathers(){
        int expectedValue = 1;
        List<Father> fatherList = fatherRepository.findAllFathers();
        assertEquals(expectedValue,fatherList.size());

    }

}