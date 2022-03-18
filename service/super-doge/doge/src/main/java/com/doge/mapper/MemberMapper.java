package com.doge.mapper;

import com.doge.models.Member;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MemberMapper {

    @Select("SELECT * FROM member")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "points", column = "points"),
            @Result(property = "address", column = "address"),
            @Result(property = "phoneNumber", column = "phone_number")
    })
    List<Member> getMembers();

    @Update("UPDATE member SET points=#{points} WHERE id =#{mid}")
    void updateMemberPoint(Integer mid, Integer points);

}
