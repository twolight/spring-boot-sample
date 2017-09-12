package com.twolight.server;

import com.twolight.server.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired(required = true)
    private UserRepository userRepository;

    @Test
    public void testUserRepository() throws Exception {
        Assert.assertEquals(4, userRepository.findAll().size());
    }

    public void testSave(){
//        userRepository.save(new User("tom",12));
//        userRepository.save(new User("a",23));
//        userRepository.save(new User("b",40));
//        userRepository.save(new User("c",60));
    }

    public void testFind(){
//        User tom = userRepository.findByName("tom");
//        Assert.assertEquals(new Integer(12), tom.getAge());
    }
}
