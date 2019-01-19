package com.example.entity;
//所有实体类的父类
public abstract class IdEntity {
	protected Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	

}
