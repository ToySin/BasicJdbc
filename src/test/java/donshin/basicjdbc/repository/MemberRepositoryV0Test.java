package donshin.basicjdbc.repository;

import donshin.basicjdbc.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryV0Test {

    MemberRepositoryV0 memberRepositoryV0 = new MemberRepositoryV0();

    @AfterEach
    void afterEach() {
        String sql = "delete from member";


    }

    @Test
    void crud() throws SQLException {
        //save
        Member member = new Member("memberA", 10000);
        memberRepositoryV0.save(member);

        //find
        Member findMember = memberRepositoryV0.findById("memberA");
        Assertions.assertThat(findMember.getMemberId()).isEqualTo(member.getMemberId());
        Assertions.assertThat(findMember.getMoney()).isEqualTo(member.getMoney());
    }

}