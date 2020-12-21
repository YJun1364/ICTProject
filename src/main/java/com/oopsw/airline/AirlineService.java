package com.oopsw.airline;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oopsw.airline.dao.AirRouteVO;
import com.oopsw.airline.dao.AirlineDAO;
import com.oopsw.airline.dao.AirlineMemberVO;
import com.oopsw.airline.dao.PassengerVO;
import com.oopsw.airline.dao.PurchaseVO;
import com.oopsw.airline.dao.SelectRouteVO;

@Service
public class AirlineService {
	@Autowired
	private AirlineDAO airlineDAO;

	public String login(int staffNum, String pw) {
		return airlineDAO.login(staffNum,pw);
	}

	public AirRouteVO getRouteInfo(String routeCode) {
		return airlineDAO.getRouteInfo(routeCode);
	}

	public Collection<PassengerVO> getRoutePassengerList(String routeCode) {
		return airlineDAO.getRoutePassengerList(routeCode);
	}

	public int getRouteInfoNum(String ticketNum) {
		return airlineDAO.getRouteInfoNum(ticketNum);
	}

	public String getPurchaseNum(int routeInfoNum) {
		return airlineDAO.getPurchaseNum(routeInfoNum);
	}

	public PurchaseVO getPurchaseInfo(String purchaseNum) {
		return airlineDAO.getPurchaseInfo(purchaseNum);
	}

	public Collection<PassengerVO> getPassengerInfoList(String ticketNum) {
		return airlineDAO.getPassengerInfoList(ticketNum);
	}

	public AirRouteVO getBookingRouteInfo(String routeCode) {

		return airlineDAO.getRouteInfo(routeCode);
	}

	public Collection<AirRouteVO> getAirRouteInfoList() {
		// TODO Auto-generated method stub
		return airlineDAO.getAirRouteInfoList();
	}

	public Collection<AirRouteVO> getSearchedAirRouteInfoList(String airportCodeDep, String airportCodeArr,String dateDep) {
		return airlineDAO.getSearchedAirRouteInfoList(airportCodeDep, airportCodeArr, dateDep);
	}

	public ArrayList<Integer> getSelectRouteInfo(String purchaseNum) {
		Collection<SelectRouteVO> selectRouteInfo = airlineDAO.getSelectRouteInfo(purchaseNum);
		ArrayList<Integer> routeInfoNumList=new ArrayList(); 
		for (SelectRouteVO selectRouteVO : selectRouteInfo) {
			routeInfoNumList.add(selectRouteVO.getRouteInfoNum());

		}
		return routeInfoNumList;
	}

	public ArrayList<String> getSelectRouteCode(String purchaseNum) {
		Collection<SelectRouteVO> selectRouteInfo = airlineDAO.getSelectRouteInfo(purchaseNum);
		ArrayList<String> routeCodeList=new ArrayList();
		for (SelectRouteVO selectRouteVO : selectRouteInfo) {
			routeCodeList.add(selectRouteVO.getRouteCode());
		}
		return routeCodeList;
	}

	public Collection<PassengerVO> getBookingInfo(Integer routeInfoNum) {
		return airlineDAO.getBookingInfo(routeInfoNum);
	}

	public boolean setPassport(String ticketNum, String passport) {
		boolean b=false;

		if(airlineDAO.setPassport(ticketNum, passport)==1){
			b=true;}
		return b;
	}

	public PassengerVO getPassengerInfo(String ticketNum){
		return airlineDAO.getPassengerInfo(ticketNum);
	}

	public boolean getHabitInfo(String ticketNum) {
		boolean b=false;
		PassengerVO habitInfo = getPassengerInfo(ticketNum); //티켓넘버로 정보 가지고오기
		int clean=0;
		int sleep=0;
		int active=0;
		if(habitInfo.getClean()==0 && habitInfo.getSleep()==0 && habitInfo.getActive()==0){
			clean = 1;
			sleep = 7;
			active = 2;
			if(airlineDAO.setHabitInfo(ticketNum, clean, sleep, active)==1){//점수 업데이트완료 확인
				b=true;
			}
		}else b=true;
		return b; // 업데이트 => true
	}

	public boolean setHabitInfo(String ticketNum, float clean, float sleep, float active) {
		boolean b=false;
		int totalPoint = (int)(clean+(sleep/10)+(active/10));
		int cleanPoint = Math.round((clean*10)/(float)totalPoint);
		int activePoint = Math.round((active)/(float)totalPoint);
		int sleepPoint = Math.round((sleep)/(float)totalPoint);
		if(airlineDAO.setHabitInfo(ticketNum, cleanPoint, sleepPoint, activePoint)==1)
			b=true;
		return b;
	}

	public Collection<PassengerVO> getMainHabit(String routeCode) {
		return airlineDAO.getMainHabit(routeCode);
	}

	public ArrayList<String> getReservationSeats(String routeCode) {
		ArrayList<String> routeInfoNumList = airlineDAO.getRouteInfoNumList(routeCode);
		ArrayList<String> reservationSeats = new ArrayList();
		for (String routeInfoNum : routeInfoNumList) {
			reservationSeats.addAll(airlineDAO.getReservationSeats(routeInfoNum));
		}
		System.out.println(reservationSeats);
		return reservationSeats;
	}

	public void setSeatNumber(String ticketNum, String seatNumber) {
		airlineDAO.setSeatNumber(ticketNum,seatNumber);
	}

	public Collection<AirRouteVO> searchAirRoute(String airportCodeDep, String airportCodeArr, String dateDep) {
		return airlineDAO.searchAirRoute(airportCodeDep, airportCodeArr, dateDep);
	}

	public AirlineMemberVO searchMember(String purchaseId) {
		return airlineDAO.searchMember(purchaseId);
	}

	public AirlineMemberVO getPurchaseName(String id) {
		return airlineDAO.getPurchaseName(id);
	}

	public void addPurchaseInfo(String purchaseNum, String category, int numAdult, int numChild, int numInfant,
			int totalPrice, String purchaseDate, String paymentStatus, String paymentInfo, String id) {
		airlineDAO.addPurchaseInfo(purchaseNum, category, numAdult, numChild, numInfant,
				 totalPrice, purchaseDate, paymentStatus, paymentInfo,id);
	}

	public void addSelectRoute(int routeInfoNum, String routeCode, String purchaseNum) {
		airlineDAO.addSelectRoute(routeInfoNum, routeCode, purchaseNum);
		
	}

	public void addPassengerInfo(String ticketNum, String lastNameEng, String firstNameEng, String lastNameKor,
			String firstNameKor, String gender, String nationality, String birth, String phoneNumber, String passport,
			String checkIn, int luggage, int luggageFee, int seatFee, int passengerTotalPrice, String seatNumber, int clean, int sleep,
			int active, int routeInfoNum) {
		airlineDAO.addPassengerInfo(ticketNum, lastNameEng, firstNameEng, lastNameKor,
				 firstNameKor, gender, nationality, birth, phoneNumber, passport,
				 checkIn, luggage, luggageFee, seatFee, passengerTotalPrice, seatNumber, clean, sleep,
				 active, routeInfoNum);
		
	}

	public void updateCheckIn(String ticketNum) {
		airlineDAO.updateCheckIn(ticketNum);
		
	}

	public int checkWorkCode(String staffNum) {
		return airlineDAO.checkWorkCode(staffNum);
	}
}
