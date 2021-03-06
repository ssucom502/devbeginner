package com.blogcode.posting.repository;

import com.blogcode.posting.domain.Posting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jojoldu@gmail.com on 2016-12-13
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */
@Repository
public interface PostingRepository extends JpaRepository<Posting, Long>{
}
