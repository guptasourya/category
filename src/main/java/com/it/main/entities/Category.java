package com.it.main.entities;


import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
@SQLDelete(sql = "UPDATE category SET deleted=true WHERE category_id=?")
@Where(clause = "deleted=false")
public class Category {

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private int id;
	
	@Column(length = 60)
	 private String name;
	
	private boolean deleted=false;  //fALSE=nOT DELETED,TRUE=DELETED
	
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	@ManyToOne
	@JoinColumn(name = "parent_id")
    private Category parent;
   
	
	
//	@OneToMany(mappedBy = "parent",cascade = CascadeType.ALL)
//    private Set<Category> children=new HashSet<>();
	
	public Category(String name ,Category parent) {
		this.parent=parent;
		this.name = name;

	}
	public Category(String name) {
	
		this.name = name;
	}

	public Category() {
		super();
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

//	public Set<Category> getChildren() {
//		return children;
//	}
//
//	public void setChildren(Set<Category> children) {
//		this.children = children;
//	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", parent=" + parent +  "]";
	}

	

	

	 

}

