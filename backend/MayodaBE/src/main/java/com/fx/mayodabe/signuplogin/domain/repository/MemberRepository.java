package com.fx.mayodabe.signuplogin.domain.repository;

import com.fx.mayodabe.signuplogin.domain.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity,String> {
    Optional<MemberEntity> findByEmail(String userEmail);
}
