package donshin.basicjdbc.repository;

import donshin.basicjdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

@Slf4j
class MemberRepositoryV0Test {

    MemberRepositoryV0 memberRepositoryV0 = new MemberRepositoryV0();

    @AfterEach
    void afterEach() {

    }

    @Test
    void crud() throws SQLException {
        //save
        Member member = new Member("memberA", 10000);
        memberRepositoryV0.save(member);
        log.info("member save={}", member);

        //find
        Member findMember = memberRepositoryV0.findById("memberA");
        log.info("member find={}", findMember);
        Assertions.assertThat(findMember.getMemberId()).isEqualTo(member.getMemberId());
        Assertions.assertThat(findMember.getMoney()).isEqualTo(member.getMoney());
    }

}