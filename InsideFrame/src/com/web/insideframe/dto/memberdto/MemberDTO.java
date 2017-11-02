package com.web.insideframe.dto.memberdto;

public class MemberDTO {
	private String email;
	private String pw;
	private String name;
	private String mType;
	private int admin=0;
	private String mimage="";
	private String birth;
	private String height;
	private String weight;
	private String phone;
	private String sex;
	
	public MemberDTO(){}
	
	public MemberDTO(String email, String pw, String name, String mType, String birth, String height, String weight,
			String phone,String sex) {
		super();
		this.email = email;
		this.pw = pw;
		this.name = name;
		this.mType = mType;
		this.birth = birth;
		this.height = height;
		this.weight = weight;
		this.phone = phone;
		this.sex=sex;
	}
	
	public MemberDTO(String email, String pw, String name, String mType, String mimage, String birth, String height,
			String weight, String phone,String sex) {
		super();
		this.email = email;
		this.pw = pw;
		this.name = name;
		this.mType = mType;
		this.mimage = mimage;
		this.birth = birth;
		this.height = height;
		this.weight = weight;
		this.phone = phone;
		this.sex=sex;
	}
	
	public MemberDTO(String email, String pw, String name, String mType, int admin, String mimage, String birth,
			String height, String weight, String phone,String sex) {
		super();
		this.email = email;
		this.pw = pw;
		this.name = name;
		this.mType = mType;
		this.admin = admin;
		this.mimage = mimage;
		this.birth = birth;
		this.height = height;
		this.weight = weight;
		this.phone = phone;
		this.sex=sex;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getmType() {
		return mType;
	}
	public void setmType(String mType) {
		this.mType = mType;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	public String getMimage() {
		return mimage;
	}
	public void setMimage(String mimage) {
		this.mimage = mimage;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "MemberDTO [email=" + email + ", pw=" + pw + ", name=" + name + ", mType=" + mType + ", admin=" + admin
				+ ", mimage=" + mimage + ", birth=" + birth + ", height=" + height + ", weight=" + weight + ", phone="
				+ phone + ", sex=" + sex + "]";
	}
	
}