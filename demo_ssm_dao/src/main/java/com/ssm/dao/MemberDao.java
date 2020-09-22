package com.ssm.dao;

import com.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface MemberDao {
    // 根据会员的id查询会员信息
    @Select("select * from member where id=#{memberId}")
    Member findById(int memberId);
}
