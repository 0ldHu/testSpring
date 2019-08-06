package com.example.demo.mapper;

import com.example.demo.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface QuestionMapper {
    @Insert("insert into question (title, description, gmt_create,gmt_modified,creator,tag,avatar_url)" +
            "values (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag}),#{avatarUrl}")
    public void create(Question question);
}
