package com.xxx.service;

import java.util.List;

import com.xxx.model.Content;

public interface IContentService
{
//新增试题的接口
boolean insert(Content content);

//更新试题
boolean update(Content content);
 
//删除试题
boolean delete(List<Integer> ids);

//使用id获取试题
Content selectContent(Integer id);

//获取所有试题
List<Content> selectAllContent();


 
}
