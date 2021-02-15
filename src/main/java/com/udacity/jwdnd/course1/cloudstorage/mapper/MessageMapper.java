package com.udacity.jwdnd.course1.cloudstorage.mapper;


import com.udacity.jwdnd.course1.cloudstorage.model.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageMapper {
    @Select("SELECT * FROM MESSAGES WHERE username = #{username}")
    List<Message> getMessage(String username);

    @Insert("INSERT INTO MESSAGES (username,text) VALUES(#{username}, #{text})")
    int insert(Message message);
}
