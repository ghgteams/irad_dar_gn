package com.irad.dar.pdf;

public class InjuredLegalRepresentatives {

	private String name;
	private String age;
	private String relation;
	private String gender;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "InjuredLegalRepresentatives [name=" + name + ", age=" + age + ", relation=" + relation + ", gender="
				+ gender + "]";
	}
	public InjuredLegalRepresentatives(String name, String age, String relation, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.relation = relation;
		this.gender = gender;
	}
	public InjuredLegalRepresentatives() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
