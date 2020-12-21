package com.oopsw.airline.dao;

public class PassengerVO {
	private String ticketNum;
	private String lastNameEng;
	private String firstNameEng;
	private String lastNameKor;
	private String firstNameKor;
	private String gender;
	private String nationality;
	private String birth;
	private String phoneNumber;
	private String passport;
	private String checkIn;
	private int luggage;
	private int luggageFee;
	private int seatFee;
	private int passengerTotalPrice;
	private String seatNumber;
	private int clean;
	private int sleep;
	private int active;
	private int routeInfoNum;
	private String seatOrNot;

	public PassengerVO() {

	}

	public PassengerVO(String ticketNum, String lastNameEng, String firstNameEng, String lastNameKor,
			String firstNameKor, String gender, String nationality, String birth, String phoneNumber, String passport,
			String checkIn, int luggage, int luggageFee, int seatFee, int passengerTotalPrice, String seatNumber,
			int clean, int sleep, int active, int routeInfoNum, String seatOrNot) {
		super();
		this.ticketNum = ticketNum;
		this.lastNameEng = lastNameEng;
		this.firstNameEng = firstNameEng;
		this.lastNameKor = lastNameKor;
		this.firstNameKor = firstNameKor;
		this.gender = gender;
		this.nationality = nationality;
		this.birth = birth;
		this.phoneNumber = phoneNumber;
		this.passport = passport;
		this.checkIn = checkIn;
		this.luggage = luggage;
		this.luggageFee = luggageFee;
		this.seatFee = seatFee;
		this.passengerTotalPrice = passengerTotalPrice;
		this.seatNumber = seatNumber;
		this.clean = clean;
		this.sleep = sleep;
		this.active = active;
		this.routeInfoNum = routeInfoNum;
		this.seatOrNot = seatOrNot;
	}

	public String getTicketNum() {
		return ticketNum;
	}

	public void setTicketNum(String ticketNum) {
		this.ticketNum = ticketNum;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public int getLuggage() {
		return luggage;
	}

	public void setLuggage(int luggage) {
		this.luggage = luggage;
	}

	public int getLuggageFee() {
		return luggageFee;
	}

	public void setLuggageFee(int luggageFee) {
		this.luggageFee = luggageFee;
	}

	public int getSeatFee() {
		return seatFee;
	}

	public void setSeatFee(int seatFee) {
		this.seatFee = seatFee;
	}

	public int getPassengerTotalPrice() {
		return passengerTotalPrice;
	}

	public void setPassengerTotalPrice(int passengerTotalPrice) {
		this.passengerTotalPrice = passengerTotalPrice;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
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

	public int getRouteInfoNum() {
		return routeInfoNum;
	}

	public void setRouteInfoNum(int routeInfoNum) {
		this.routeInfoNum = routeInfoNum;
	}

	public String getSeatOrNot() {
		return seatOrNot;
	}

	public void setSeatOrNot(String seatOrNot) {
		this.seatOrNot = seatOrNot;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + active;
		result = prime * result + ((birth == null) ? 0 : birth.hashCode());
		result = prime * result + ((checkIn == null) ? 0 : checkIn.hashCode());
		result = prime * result + clean;
		result = prime * result + ((firstNameEng == null) ? 0 : firstNameEng.hashCode());
		result = prime * result + ((firstNameKor == null) ? 0 : firstNameKor.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((lastNameEng == null) ? 0 : lastNameEng.hashCode());
		result = prime * result + ((lastNameKor == null) ? 0 : lastNameKor.hashCode());
		result = prime * result + luggage;
		result = prime * result + luggageFee;
		result = prime * result + ((nationality == null) ? 0 : nationality.hashCode());
		result = prime * result + passengerTotalPrice;
		result = prime * result + ((passport == null) ? 0 : passport.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + routeInfoNum;
		result = prime * result + seatFee;
		result = prime * result + ((seatNumber == null) ? 0 : seatNumber.hashCode());
		result = prime * result + ((seatOrNot == null) ? 0 : seatOrNot.hashCode());
		result = prime * result + sleep;
		result = prime * result + ((ticketNum == null) ? 0 : ticketNum.hashCode());
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
		PassengerVO other = (PassengerVO) obj;
		if (active != other.active)
			return false;
		if (birth == null) {
			if (other.birth != null)
				return false;
		} else if (!birth.equals(other.birth))
			return false;
		if (checkIn == null) {
			if (other.checkIn != null)
				return false;
		} else if (!checkIn.equals(other.checkIn))
			return false;
		if (clean != other.clean)
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
		if (luggage != other.luggage)
			return false;
		if (luggageFee != other.luggageFee)
			return false;
		if (nationality == null) {
			if (other.nationality != null)
				return false;
		} else if (!nationality.equals(other.nationality))
			return false;
		if (passengerTotalPrice != other.passengerTotalPrice)
			return false;
		if (passport == null) {
			if (other.passport != null)
				return false;
		} else if (!passport.equals(other.passport))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (routeInfoNum != other.routeInfoNum)
			return false;
		if (seatFee != other.seatFee)
			return false;
		if (seatNumber == null) {
			if (other.seatNumber != null)
				return false;
		} else if (!seatNumber.equals(other.seatNumber))
			return false;
		if (seatOrNot == null) {
			if (other.seatOrNot != null)
				return false;
		} else if (!seatOrNot.equals(other.seatOrNot))
			return false;
		if (sleep != other.sleep)
			return false;
		if (ticketNum == null) {
			if (other.ticketNum != null)
				return false;
		} else if (!ticketNum.equals(other.ticketNum))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PassengerVO [ticketNum=" + ticketNum + ", lastNameEng=" + lastNameEng + ", firstNameEng=" + firstNameEng
				+ ", lastNameKor=" + lastNameKor + ", firstNameKor=" + firstNameKor + ", gender=" + gender
				+ ", nationality=" + nationality + ", birth=" + birth + ", phoneNumber=" + phoneNumber + ", passport="
				+ passport + ", checkIn=" + checkIn + ", luggage=" + luggage + ", luggageFee=" + luggageFee
				+ ", seatFee=" + seatFee + ", passengerTotalPrice=" + passengerTotalPrice + ", seatNumber=" + seatNumber
				+ ", clean=" + clean + ", sleep=" + sleep + ", active=" + active + ", routeInfoNum=" + routeInfoNum
				+ ", seatOrNot=" + seatOrNot + ", getTicketNum()=" + getTicketNum() + ", getLastNameEng()="
				+ getLastNameEng() + ", getFirstNameEng()=" + getFirstNameEng() + ", getLastNameKor()="
				+ getLastNameKor() + ", getFirstNameKor()=" + getFirstNameKor() + ", getGender()=" + getGender()
				+ ", getNationality()=" + getNationality() + ", getBirth()=" + getBirth() + ", getPhoneNumber()="
				+ getPhoneNumber() + ", getPassport()=" + getPassport() + ", getCheckIn()=" + getCheckIn()
				+ ", getLuggage()=" + getLuggage() + ", getLuggageFee()=" + getLuggageFee() + ", getSeatFee()="
				+ getSeatFee() + ", getPassengerTotalPrice()=" + getPassengerTotalPrice() + ", getSeatNumber()="
				+ getSeatNumber() + ", getClean()=" + getClean() + ", getSleep()=" + getSleep() + ", getActive()="
				+ getActive() + ", getRouteInfoNum()=" + getRouteInfoNum() + ", getSeatOrNot()=" + getSeatOrNot()
				+ ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString()
				+ "]";
	}

}
