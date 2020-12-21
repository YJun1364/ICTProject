package com.oopsw.airline.dao;


import java.util.ArrayList;
import java.util.Collection;

import org.apache.ibatis.annotations.Param;

public interface AirlineDAO{

	String login(@Param("staffNum") int staffNum,@Param("pw") String pw);

	AirRouteVO getRouteInfo(@Param("routeCode")String routeCode);

	Collection<PassengerVO> getRoutePassengerList(@Param("routeCode")String routeCode);

	int getRouteInfoNum(@Param("ticketNum") String ticketNum);

	String getPurchaseNum(@Param("routeInfoNum") int routeInfoNum);

	PurchaseVO getPurchaseInfo(@Param("purchaseNum") String purchaseNum);

	Collection<PassengerVO> getPassengerInfoList(@Param("ticketNum") String ticketNum);

	Collection<AirRouteVO> getAirRouteInfoList();

	Collection<AirRouteVO> getSearchedAirRouteInfoList(@Param("airportCodeDep") String airportCodeDep,@Param("airportCodeArr") String airportCodeArr,@Param("dateDep") String dateDep);

	Collection<SelectRouteVO> getSelectRouteInfo(@Param("purchaseNum") String purchaseNum);

	Collection<PassengerVO> getBookingInfo(@Param("routeInfoNum") Integer routeInfoNum);

	int setPassport(@Param("ticketNum") String ticketNum, @Param("passport") String passport);

	PassengerVO getPassengerInfo(@Param("ticketNum") String ticketNum);

	int setHabitInfo(@Param("ticketNum") String ticketNum, @Param("clean") int clean, @Param("sleep") int sleep, @Param("active") int active);

	Collection<PassengerVO> getMainHabit(@Param("routeCode")String routeCode);

	ArrayList<String> getRouteInfoNumList(@Param("routeCode")String routeCode);

	ArrayList<String> getReservationSeats(@Param("routeInfoNum")String routeInfoNum);

	void setSeatNumber(@Param("ticketNum")String ticketNum, @Param("seatNumber")String seatNumber);

	Collection<AirRouteVO> searchAirRoute(@Param("airportCodeDep") String airportCodeDep,@Param("airportCodeArr") String airportCodeArr, @Param("dateDep")String dateDep);

	AirlineMemberVO searchMember(@Param("purchaseId")String purchaseId);

	AirlineMemberVO getPurchaseName(@Param("id")String id);

	void addPurchaseInfo(@Param("purchaseNum")String purchaseNum, @Param("category")String category, @Param("numAdult")int numAdult, @Param("numChild")int numChild, @Param("numInfant")int numInfant, @Param("totalPrice")int totalPrice,
			@Param("purchaseDate")String purchaseDate, @Param("paymentStatus")String paymentStatus, @Param("paymentInfo")String paymentInfo, @Param("id")String id);

	void addSelectRoute(@Param("routeInfoNum")int routeInfoNum, @Param("routeCode")String routeCode, @Param("purchaseNum")String purchaseNum);

	void addPassengerInfo(@Param("ticketNum") String ticketNum, @Param("lastNameEng")String lastNameEng, @Param("firstNameEng")String firstNameEng, @Param("lastNameKor")String lastNameKor,
			@Param("firstNameKor")String firstNameKor, @Param("gender")String gender, @Param("nationality")String nationality, @Param("birth")String birth, @Param("phoneNumber")String phoneNumber, @Param("passport")String passport,
			@Param("checkIn")String checkIn,@Param("luggage")int luggage, @Param("luggageFee")int luggageFee, @Param("seatFee")int seatFee, @Param("passengerTotalPrice")int passengerTotalPrice, @Param("seatNumber")String seatNumber, @Param("clean")int clean,
			@Param("sleep")int sleep, @Param("active")int active, @Param("routeInfoNum")int routeInfoNum);

	void updateCheckIn(@Param("ticketNum")String ticketNum);

	int checkWorkCode(@Param("staffNum")String staffNum);
	
}