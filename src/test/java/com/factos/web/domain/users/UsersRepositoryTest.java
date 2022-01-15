package com.factos.web.domain.users;

import com.factos.domain.users.F_Users;
import com.factos.domain.users.F_Users_Repository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersRepositoryTest {

    @Autowired
    F_Users_Repository f_users_repository;

    @After
    public void cleanup() {
        f_users_repository.deleteAll();
    }

    @Test
    public void load_userData() {
        String userName = "choi";
        String userId = "choi";

        f_users_repository.save(F_Users.builder()
                .userName("choi")
                .userId("choi")
                .userEmail("choi@naver.com")
                .userAccess("")
                .userJoinDate("")
                .userNickname("")
                .userPassword("")
                .userPhone("")
                .userSeq("")
                .userMarketingAgree("")
                .userStatus("")
                .userSecessionDate("")
                .build());

        List<F_Users> f_usersList = f_users_repository.findAll();

        F_Users f_users = f_usersList.get(0);
        assertThat(f_users.getUserName()).isEqualTo(userName);
        assertThat(f_users.getUserId()).isEqualTo(userId);

    }
}
