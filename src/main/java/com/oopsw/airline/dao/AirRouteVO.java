package com.oopsw.airline.dao;

public class AirRouteVO {
	private String routeCode;
	private String airportCodeDep;
	private String dateDep;
	private String timeDep;
	private String airportCodeArr;
	private String dateArr;
	private String timeArr;
	private String flightStatus;
	private int gate;
	private int reservationSeat;
	private int basicFare;
	private int tax;
	private int commission;
	private int totalRouteFare;
	private String airplaneCode;
	
	
	public AirRouteVO() {
	}
	public AirRouteVO(String routeCode, String airportCodeDep, String dateDep, String timeDep, String airportCodeArr,
			String dateArr, String timeArr, String flightStatus, int gate, int reservationSeat, int basicFare, int tax,
			int commission, int totalRouteFare, String airplaneCode) {
		setRouteCode(routeCode);
		setAirportCodeDep(airportCodeDep);
		setDateDep(dateDep);
		setTimeDep(timeDep);
		setAirportCodeArr(airportCodeArr);
		setDateArr(dateArr);
		setTimeArr(timeArr);
		setFlightStatus(flightStatus);
		setGate(gate);
		setReservationSeat(reservationSeat);
		setBasicFare(basicFare);
		setTax(tax);
		setCommission(commission);
		setTotalRouteFare(totalRouteFare);
		setAirplaneCode(airplaneCode);
	}
	public String getRouteCode() {
		return routeCode;
	}
	public void setRouteCode(String routeCode) {
		this.routeCode = routeCode;
	}
	public String getAirportCodeDep() {
		return airportCodeDep;
	}
	public void setAirportCodeDep(String airportCodeDep) {
		this.airportCodeDep = airportCodeDep;
	}
	public String getDateDep() {
		return dateDep;
	}
	public void setDateDep(String dateDep) {
		this.dateDep = dateDep;
	}
	public String getTimeDep() {
		return timeDep;
	}
	public void setTimeDep(String timeDep) {
		this.timeDep = timeDep;
	}
	public String getAirportCodeArr() {
		return airportCodeArr;
	}
	public void setAirportCodeArr(String airportCodeArr) {
		this.airportCodeArr = airportCodeArr;
	}
	public String getDateArr() {
		return dateArr;
	}
	public void setDateArr(String dateArr) {
		this.dateArr = dateArr;
	}
	public String getTimeArr() {
		return timeArr;
	}
	public void setTimeArr(String timeArr) {
		this.timeArr = timeArr;
	}
	public String getFlightStatus() {
		return flightStatus;
	}
	public void setFlightStatus(String flightStatus) {
		this.flightStatus = flightStatus;
	}
	public int getGate() {
		return gate;
	}
	public void setGate(int gate) {
		this.gate = gate;
	}
	public int getReservationSeat() {
		return reservationSeat;
	}
	public void setReservationSeat(int reservationSeat) {
		this.reservationSeat = reservationSeat;
	}
	public int getBasicFare() {
		return basicFare;
	}
	public void setBasicFare(int basicFare) {
		this.basicFare = basicFare;
	}
	public int getTax() {
		return tax;
	}
	public void setTax(int tax) {
		this.tax = tax;
	}
	public int getCommission() {
		return commission;
	}
	public void setCommission(int commission) {
		this.commission = commission;
	}
	public int getTotalRouteFare() {
		return totalRouteFare;
	}
	public void setTotalRouteFare(int totalRouteFare) {
		this.totalRouteFare = totalRouteFare;
	}
	public String getAirplaneCode() {
		return airplaneCode;
	}
	public void setAirplaneCode(String airplaneCode) {
		this.airplaneCode = airplaneCode;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airplaneCode == null) ? 0 : airplaneCode.hashCode());
		result = prime * result + ((airportCodeArr == null) ? 0 : airportCodeArr.hashCode());
		result = prime * result + ((airportCodeDep == null) ? 0 : airportCodeDep.hashCode());
		result = prime * result + basicFare;
		result = prime * result + commission;
		result = prime * result + ((dateArr == null) ? 0 : dateArr.hashCode());
		result = prime * result + ((dateDep == null) ? 0 : dateDep.hashCode());
		result = prime * result + ((flightStatus == null) ? 0 : flightStatus.hashCode());
		result = prime * result + gate;
		result = prime * result + reservationSeat;
		result = prime * result + ((routeCode == null) ? 0 : routeCode.hashCode());
		result = prime * result + tax;
		result = prime * result + ((timeArr == null) ? 0 : timeArr.hashCode());
		result = prime * result + ((timeDep == null) ? 0 : timeDep.hashCode());
		result = prime * result + totalRouteFare;
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
		AirRouteVO other = (AirRouteVO) obj;
		if (airplaneCode == null) {
			if (other.airplaneCode != null)
				return false;
		} else if (!airplaneCode.equals(other.airplaneCode))
			return false;
		if (airportCodeArr == null) {
			if (other.airportCodeArr != null)
				return false;
		} else if (!airportCodeArr.equals(other.airportCodeArr))
			return false;
		if (airportCodeDep == null) {
			if (other.airportCodeDep != null)
				return false;
		} else if (!airportCodeDep.equals(other.airportCodeDep))
			return false;
		if (basicFare != other.basicFare)
			return false;
		if (commission != other.commission)
			return false;
		if (dateArr == null) {
			if (other.dateArr != null)
				return false;
		} else if (!dateArr.equals(other.dateArr))
			return false;
		if (dateDep == null) {
			if (other.dateDep != null)
				return false;
		} else if (!dateDep.equals(other.dateDep))
			return false;
		if (flightStatus == null) {
			if (other.flightStatus != null)
				return false;
		} else if (!flightStatus.equals(other.flightStatus))
			return false;
		if (gate != other.gate)
			return false;
		if (reservationSeat != other.reservationSeat)
			return false;
		if (routeCode == null) {
			if (other.routeCode != null)
				return false;
		} else if (!routeCode.equals(other.routeCode))
			return false;
		if (tax != other.tax)
			return false;
		if (timeArr == null) {
			if (other.timeArr != null)
				return false;
		} else if (!timeArr.equals(other.timeArr))
			return false;
		if (timeDep == null) {
			if (other.timeDep != null)
				return false;
		} else if (!timeDep.equals(other.timeDep))
			return false;
		if (totalRouteFare != other.totalRouteFare)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AirRouteVO [routeCode=" + routeCode + ", airportCodeDep=" + airportCodeDep + ", dateDep=" + dateDep
				+ ", timeDep=" + timeDep + ", airportCodeArr=" + airportCodeArr + ", dateArr=" + dateArr + ", timeArr="
				+ timeArr + ", flightStatus=" + flightStatus + ", gate=" + gate + ", reservationSeat=" + reservationSeat
				+ ", basicFare=" + basicFare + ", tax=" + tax + ", commission=" + commission + ", totalRouteFare="
				+ totalRouteFare + ", airplaneCode=" + airplaneCode + "]";
	}
	
	
}
