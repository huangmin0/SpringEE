package com.xxx.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xxx.controller.valueobject.RequsetObject;
import com.xxx.controller.valueobject.ResultObject;
import com.xxx.model.Content;
import com.xxx.service.IContentService;

@Controller
@RequestMapping("/content")
public class ContentController2
{

	@Autowired
	private IContentService iContentService;
	//添加，更新试题方法
	@RequestMapping(value="/addOrMod" ,method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody ResultObject modContent(HttpServletRequest request,HttpServletResponse response,
			@RequestBody Content content){
		ResultObject ro=new ResultObject();
		if(null==content||null==content.getTest()){
			return ro;
		}
		if(content.getId()==null){
			iContentService.insert(content);
		}else{
			iContentService.update(content);
		}
		ro.setResult("ok");
		return ro;
	}
	//删除试题方法
	@RequestMapping(value="/del",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody ResultObject delContentById(HttpServletRequest request,HttpServletResponse response,
			@RequestBody RequsetObject requsetObject){
		ResultObject resultObject=new ResultObject();
		String[] ids=requsetObject.getIds().split(",");
		//将string数组转换成list
		if(null !=ids){
			List<Integer> list=new ArrayList<Integer>();
			for(int i=0;i<ids.length;i++){
				list.add(Integer.parseInt(ids[i]));
			}
			iContentService.delete(list);
		}
		resultObject.setResult("删除数据成功");
		return resultObject;
	}
	//获取试题的方法
	@RequestMapping(value="/getOne/{id}",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView getContentById(HttpServletRequest request,HttpServletResponse response,
			@PathVariable Integer id){
		Content content=iContentService.selectContent(id);
		ModelAndView mv=new ModelAndView();
		mv.addObject("cot",content);
		mv.setViewName("content/contentUpdate");
		return mv;
	}
	//获取所有试题的方法
	@RequestMapping(value="/getAll",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public List<Content> getAllContent(HttpServletRequest request,HttpServletResponse response){
		List<Content> list=iContentService.selectAllContent();
		return list;
	}
	private ModelAndView toStudentHomePage(){
		ModelAndView mv=new ModelAndView();
		List<Content> list=iContentService.selectAllContent();
		mv.addObject("list",list);
		mv.setViewName("content/contentMain");
		return mv;
		
	}
}