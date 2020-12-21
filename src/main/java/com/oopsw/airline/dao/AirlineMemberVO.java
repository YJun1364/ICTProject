package com.oopsw.airline.dao;

public class AirlineMemberVO {
	private String id;
	private String pw;
	private String lastNameEng;
	private String firstNameEng;
	private String lastNameKor;
	private String firstNameKor;
	private String birth;
	private String gender;
	private String phoneNumber;
	private String email;
	private String nationality;
	private int clean;
	private int sleep;
	private int active;
	
	
	public AirlineMemberVO() {}


	public AirlineMemberVO(String id, String pw, String lastNameEng, String firstNameEng, String lastNameKor,
			String firstNameKor, String birth, String gender, String phoneNumber, String email, String nationality,
			int clean, int sleep, int active) {
		this.id = id;
		this.pw = pw;
		this.lastNameEng = lastNameEng;
		this.firstNameEng = firstNameEng;
		this.lastNameKor = lastNameKor;
		this.firstNameKor = firstNameKor;
		this.birth = birth;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.nationality = nationality;
		this.clean = clean;
		this.sleep = sleep;
		this.active = active;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getLastNameEng() {
		return lastNameEng;
	}


	public void setLastNameEng(String lastNameEng) {
		this.lastNameEng = lastNameEng;
	}


	public String getFirstNameEng() {
		return firstNameEng;
	}


	public void setFirstNameEng(String firstNameEng) {
		this.firstNameEng = firstNameEng;
	}


	public String getLastNameKor() {
		return lastNameKor;
	}


	public void setLastNameKor(String lastNameKor) {
		this.lastNameKor = lastNameKor;
	}


	public String getFirstNameKor() {
		return firstNameKor;
	}


	public void setFirstNameKor(String firstNameKor) {
		this.firstNameKor = firstNameKor;
	}


	public String getBirth() {
		return birth;
	}


	public void setBirth(String birth) {
		this.birth = birth;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getNationality() {
		return nationality;
	}


	public void setNationality(String nationality) {
		this.nationality = nationality;
	}


	public int getClean() {
		return clean;
	}


	public void setClean(int clean) {
		this.clean = clean;
	}


	public int getSleep() {
		return sleep;
	}


	public void setSleep(int sleep) {
		this.sleep = sleep;
	}


	public int getActive() {
		return active;
	}


	public void setActive(int active) {
		this.active = active;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + active;
		result = prime * result + ((birth == null) ? 0 : birth.hashCode());
		result = prime * result + clean;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstNameEng == null) ? 0 : firstNameEng.hashCode());
		result = prime * result + ((firstNameKor == null) ? 0 : firstNameKor.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastNameEng == null) ? 0 : lastNameEng.hashCode());
		result = prime * result + ((lastNameKor == null) ? 0 : lastNameKor.hashCode());
		result = prime * result + ((nationality == null) ? 0 : nationality.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((pw == null) ? 0 : pw.hashCode());
		result = prime * result + sleep;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AirlineMemberVO other = (AirlineMemberVO) obj;
		if (active != other.active)
			return false;
		if (birth == null) {
			if (other.birth != null)
				return false;
		} else if (!birth.equals(other.birth))
			return false;
		if (clean != other.clean)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstNameEng == null) {
			if (other.firstNameEng != null)
				return false;
		} else if (!firstNameEng.equals(other.firstNameEng))
			return false;
		if (firstNameKor == null) {
			if (other.firstNameKor != null)
				return false;
		} else if (!firstNameKor.equals(other.firstNameKor))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastNameEng == null) {
			if (other.lastNameEng != null)
				return false;
		} else if (!lastNameEng.equals(other.lastNameEng))
			return false;
		if (lastNameKor == null) {
			if (other.lastNameKor != null)
				return false;
		} else if (!lastNameKor.equals(other.lastNameKor))
			return false;
		if (nationality == null) {
			if (other.nationality != null)
				return false;
		} else if (!nationality.equals(other.nationality))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (pw == null) {
			if (other.pw != null)
				return false;
		} else if (!pw.equals(other.pw))
			return false;
		if (sleep != other.sleep)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "AirlineMemberVO [id=" + id + ", pw=" + pw + ", lastNameEng=" + lastNameEng + ", firstNameEng="
				+ firstNameEng + ", lastNameKor=" + lastNameKor + ", firstNameKor=" + firstNameKor + ", birth=" + birth
				+ ", gender=" + gender + ", phoneNumber=" + phoneNumber + ", email=" + email + ", nationality="
				+ nationality + ", clean=" + clean + ", sleep=" + sleep + ", active=" + active + ", getId()=" + getId()
				+ ", getPw()=" + getPw() + ", getLastNameEng()=" + getLastNameEng() + ", getFirstNameEng()="
				+ getFirstNameEng() + ", getLastNameKor()=" + getLastNameKor() + ", getFirstNameKor()="
				+ getFirstNameKor() + ", getBirth()=" + getBirth() + ", getGender()=" + getGender()
				+ ", getPhoneNumber()=" + getPhoneNumber() + ", getEmail()=" + getEmail() + ", getNationality()="
				+ getNationality() + ", getClean()=" + getClean() + ", getSleep()=" + getSleep() + ", getActive()="
				+ getActive() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass()+"]";
	}
	
	

	
}
