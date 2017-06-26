package com.hm.hibernate.domain;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="person_inf")
public class Person {
	@Id
	@Column(name = "person_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//标识属性
	private Integer id;
	private String name;
	private int age;
	//集合属性保留该对象关联的属性
	@ElementCollection(targetClass=String.class)
	//映射保存集合属性的表
	@CollectionTable(name="school_inf",//指定表名school_inf
	joinColumns=@JoinColumn(name="person_id",nullable=false))
	//指定保存集合元素的列为school_name
	@Column(name="school_name")
	//映射集合元素
	@OrderColumn(name="list_order")
	private List<String> schools = new ArrayList<String>();
}
