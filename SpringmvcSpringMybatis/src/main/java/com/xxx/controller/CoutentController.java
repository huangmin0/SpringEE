package com.xxx.controller;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xxx.model.Content;
import com.xxx.service.IContentService;

@Controller
@RequestMapping("/content")
public class CoutentController
{
	//自动注入需要的Service组件
	@Autowired
	private IContentService contentService;
	
	//添加试题方法
	@RequestMapping(value="/add",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView addContent(HttpServletRequest request,HttpServletResponse response,Content content){
		System.out.println("in add....");
		contentService.insert(content);
		ModelAndView mv=toContentHomePage();
		return mv;
	}
	//更新试题方法
	@RequestMapping(value="/update/{id}",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView updateContent(HttpServletRequest request,HttpServletResponse response,@PathVariable Integer id ){
		Content content=contentService.selectContent(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("cot", content);
		mv.setViewName("content/contentUpdate");
		return mv;
	}
	//更新试题方法
	@RequestMapping(value="/updateAll" ,method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView updateContext(HttpServletRequest request,HttpServletResponse response,Content content){
		contentService.update(content);
		return toContentHomePage();
	}
	//删除试题方法
	@RequestMapping(value="/delete/{id}",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView delContent(HttpServletRequest request,HttpServletResponse response,@PathVariable Integer id){
		System.out.println("in delete....");
		List<Integer> ids=new ArrayList<Integer>();
		ids.add(id);
		contentService.delete(ids);
		return toContentHomePage();
	}
	//删除试题的方法
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView delStudentByIds(HttpServletRequest request, HttpServletResponse response) {
		String[] ids=request.getParameterValues("ids");//获取选中的Id
		System.out.println("in del... ids=" + ids);
		//将string的数组转换成list
		if(null != ids){
			List<Integer> list=new ArrayList<Integer>();
			for(int i=0;i<ids.length;i++){
				list.add(Integer.parseInt(ids[i]));
			}
			contentService.delete(list);
		}
		return toContentHomePage();
	}
	//获取单个试题方法
	@RequestMapping(value="/select/{id}",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView selectContent(HttpServletRequest request,HttpServletResponse response,@PathVariable Integer id){
		System.out.println("in select....");
		System.out.println("in getone:请求数据的ID=" + id);
		Content content = contentService.selectContent(id);
		
		System.out.println(content.getA());
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("cot", content);
		mv.setViewName("content/contentUpdate");
		return mv;
	}
	//获取所有试题方法
	@RequestMapping(value="/selectall",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView selectAllContent(HttpServletRequest request,HttpServletResponse response){
		System.out.println("in selectall....");
	
		return toContentHomePage();
	}
	private ModelAndView toContentHomePage() {
		ModelAndView mv =new ModelAndView();
		List<Content> list= contentService.selectAllContent();
		for (Content c1 : list)
		{
			System.out.println(c1);
		}
		mv.addObject("list", list);
		mv.setViewName("content/contentMain");
		return mv;
	}
	
}
