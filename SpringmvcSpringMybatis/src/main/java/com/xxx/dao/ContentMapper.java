package com.xxx.dao;

import com.xxx.model.Content;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ContentMapper {
	int deleteByIds(@Param("ids") List<Integer> ids);

	int deleteByPrimaryKey(Integer id);

	int insert(Content record);

	Content selectByPrimaryKey(Integer id);

	List<Content> selectall();

	int updateByPrimaryKey(Content record);
}