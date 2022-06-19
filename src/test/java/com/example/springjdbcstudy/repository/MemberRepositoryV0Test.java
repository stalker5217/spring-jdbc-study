package com.example.springjdbcstudy.repository;

import static org.assertj.core.api.Assertions.*;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springjdbcstudy.domain.Member;

@SpringBootTest
class MemberRepositoryV0Test {
	MemberRepositoryV0 repository = new MemberRepositoryV0();

	@Test
	void crud() throws SQLException {
		Member member = new Member("memberV0", 10000);
		repository.save(member);

		Member findMember = repository.findById(member.getMemberId());
		assertThat(findMember).isEqualTo(member);

		repository.update(member.getMemberId(), 20000);
		Member updateMember = repository.findById(member.getMemberId());
		assertThat(updateMember.getMoney()).isEqualTo(20000);

		repository.delete(member.getMemberId());
		assertThatThrownBy(() -> {
			repository.findById(member.getMemberId());
		}).isInstanceOf(NoSuchElementException.class);
	}
}