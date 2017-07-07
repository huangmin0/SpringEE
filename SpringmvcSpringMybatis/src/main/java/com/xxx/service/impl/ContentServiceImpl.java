package com.xxx.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.dao.ContentMapper;
import com.xxx.model.Content;
import com.xxx.service.IContentService;
@Service
public class ContentServiceImpl implements IContentService
{
	//注入Dao层
	@Autowired
	private ContentMapper contentMapper;

	@Override
	public boolean insert(Content content)
	{
		contentMapper.insert(content);
		return true;
	}

	@Override
	public boolean update(Content content)
	{
		contentMapper.updateByPrimaryKey(content);
		return false;
	}



	@Override
	public Content selectContent(Integer id)
	{
		 Content content=contentMapper.selectByPrimaryKey(id);
		return content;
	}

	@Override
	public List<Content> selectAllContent()
	{
		List<Content> list=contentMapper.selectall();
		return list;
	}

	@Override
	public boolean delete(List<Integer> ids)
	{
		contentMapper.deleteByIds(ids);
		return true;
	}
}
