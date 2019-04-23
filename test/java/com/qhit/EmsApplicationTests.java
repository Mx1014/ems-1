package com.qhit;

import com.qhit.baseUser.pojo.BaseUser;
import com.qhit.utils.RedisManger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static javax.swing.UIManager.get;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmsApplicationTests {
	@Resource
	RedisManger redisManger;
	@Test
	public void contextLoads() {
		redisManger.set("baseUser","abc");
		String result = redisManger.get("baseUser");
		System.out.println(result);
	}

}
