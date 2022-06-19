package donshin.basicjdbc.repository;

import donshin.basicjdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.NoSuchElementException;

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
        Member findMember = memberRepositoryV0.findById(member.getMemberId());
        log.info("member find={}", findMember);
        Assertions.assertThat(findMember.getMemberId()).isEqualTo(member.getMemberId());
        Assertions.assertThat(findMember.getMoney()).isEqualTo(member.getMoney());

        //update
        memberRepositoryV0.update(member.getMemberId(), 20000);
        Member updateMember = memberRepositoryV0.findById(member.getMemberId());
        Assertions.assertThat(updateMember.getMoney()).isEqualTo(20000);

        //delete
        memberRepositoryV0.delete(member.getMemberId());
        Assertions.assertThatThrownBy(() -> memberRepositoryV0.findById(member.getMemberId()))
                .isInstanceOf(NoSuchElementException.class);
    }

}