package com.pvobrien.socialJump;

import com.pvobrien.socialJump.controller.LocationController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class SocialJumpApplicationTests {

	@Autowired
	private LocationController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull(); // just confirms that the (LocationController above) controller is active.
	}

}
