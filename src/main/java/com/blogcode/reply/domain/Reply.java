package com.blogcode.reply.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by jojoldu@gmail.com on 2016-12-12.
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */

@Entity
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idx;

    @Column
    private long postingIdx;

    @Column
    private long memberIdx;

    @Column
    private String content;

    @Column
    private LocalDateTime updateDate;

    public Reply() {
    }

    public Reply(long postingIdx, long memberIdx, String content) {
        this.postingIdx = postingIdx;
        this.memberIdx = memberIdx;
        this.content = content;
        this.updateDate = LocalDateTime.now();
    }

    public long getIdx() {
        return idx;
    }

    public long getPostingIdx() {
        return postingIdx;
    }

    public long getMemberIdx() {
        return memberIdx;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }
}
