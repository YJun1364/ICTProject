package com.oopsw.airline;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.oopsw.airline.dao.AirRouteVO;
import com.oopsw.airline.dao.AirlineMemberVO;
import com.oopsw.airline.dao.PassengerVO;
import com.oopsw.airline.dao.PurchaseVO;


@Controller
public class HomeController {

	@Autowired
	private AirlineService airlineService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginUI() {
		return "login";
	}

	@RequestMapping (value="loginAction", method=RequestMethod.POST)
	public String loginAction(HttpServletRequest request){
		String url = "login";
		int staffNum = Integer.parseInt(request.getParameter("staffNum"));
		String pw = request.getParameter("pw");
		String staffName = airlineService.login(staffNum,pw);
		if(staffName!=null){
			HttpSession session = request.getSession(true);
			session.setAttribute("loginOK", staffName);
			session.setAttribute("staffNum", staffNum);
			url="main"; 
		}
		return url;
	}
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest request){
		HttpSession session=request.getSession();
		if(session!=null)
			session.invalidate();
		return "login";
	}

	//메인UI
	@RequestMapping(value="mainUI",method=RequestMethod.GET)
	public String main(){
		return "main";
	}
	
	//
	@RequestMapping(value="aircraftUI", method=RequestMethod.GET)
	public String aircraft(){
		return "aircraft";
	}




	@RequestMapping (value="searchRoutePassengerListUI", method=RequestMethod.GET)
	public String getBookingListUI(){
		return "searchRoutePassengerList";
	}

	@RequestMapping (value="searchRoutePassengerListAction", method=RequestMethod.POST)
	public String getBookingListAction(HttpServletRequest request){
		String url="searchRoutePassengerList";
		String routeCode=request.getParameter("routeCode");
		AirRouteVO routeInfo = new AirRouteVO();	
		routeInfo = airlineService.getRouteInfo(routeCode);

		if(routeInfo==null){
			request.setAttribute("error",true);
			request.setAttribute("message", "없는 편명입니다. (AA000 형식으로 입력하세요.)");
			return "searchRoutePassengerList";
		}else{
			request.setAttribute("routeInfo", routeInfo);		
			Collection<PassengerVO> passengerList = airlineService.getRoutePassengerList(routeCode);
			if(passengerList!=null){
				request.setAttribute("passengerList" , passengerList);			
				url = "getRoutePassengerList";
			}
		}
		return url;
	}

	@RequestMapping (value="checkInRoutePassengerAction", method=RequestMethod.POST)
	public String checkInRoutePassengerAction(HttpServletRequest request){
		String url="getRoutePassengerList";
		String ticketNum = request.getParameter("ticketNum");
		String routeCode = request.getParameter("routeCode");
		HttpSession session = request.getSession();
		session.setAttribute("ticketNumList", ticketNum);
		session.setAttribute("routeCode", routeCode);
		int routeInfoNum = airlineService.getRouteInfoNum(ticketNum);
		String purchaseNum = airlineService.getPurchaseNum(routeInfoNum);
		session.setAttribute("purchaseNum", purchaseNum);
		request.setAttribute("purchaseInfo", airlineService.getPurchaseInfo(purchaseNum));
		request.setAttribute("bookingInfo", airlineService.getPassengerInfoList(ticketNum));
		request.setAttribute("bookingRouteInfo", airlineService.getBookingRouteInfo(routeCode));
		url = "getBookingInfo";
		return url;
	}

	@RequestMapping (value="getAirRouteInfoUI", method=RequestMethod.GET)
	public String getAirRouteInfoUI(Model model){
		String url="main";
		Collection<AirRouteVO> airRouteInfoList = airlineService.getAirRouteInfoList();
		if(airRouteInfoList!=null){
			model.addAttribute("airRouteInfoList",airRouteInfoList);
			url="getAirRouteInfo";
		}
		return url;
	}

	@RequestMapping (value="getAirRouteInfoAction", method=RequestMethod.POST)
	public String getAirRouteInfoAction(HttpServletRequest request){
		String airportCodeDep = request.getParameter("airportCodeDep");
		String airportCodeArr = request.getParameter("airportCodeArr");
		String dateDep = request.getParameter("dateDep");

		Collection<AirRouteVO> getsearchedAirRouteInfoList = airlineService.getSearchedAirRouteInfoList(airportCodeDep,airportCodeArr,dateDep);
		Collection<String> jsonList = new ArrayList<String>();
	
		for (AirRouteVO airRouteVO : getsearchedAirRouteInfoList) {
			Gson gson = new Gson();
			String json = gson.toJson(airRouteVO);
			jsonList.add(json);
		}

		request.setAttribute("resultJSON", jsonList);
		return "JSON";
	}

	@RequestMapping(value="searchBookingInfoUI", method=RequestMethod.GET)
	public String searchBookingInfoUI(HttpServletRequest request){
		HttpSession session= request.getSession();
		String staffNum=session.getAttribute("staffNum").toString();
		String url="searchBookingInfo";
		if(airlineService.checkWorkCode(staffNum)!=154){
			request.setAttribute("error", true);
			request.setAttribute("message", "해당 사원은 발권 권한이 없습니다.");
			url="main";
		}
		return url;
	}

	@RequestMapping(value="searchBookingInfoAction", method=RequestMethod.POST)
	public String searchBookingInfo(HttpServletRequest request){
		String url="searchBookingInfo";

		//입력
		String purchaseNum = request.getParameter("purchaseNum");
		String firstNameEng = request.getParameter("firstNameEng");
		String lastNameEng = request.getParameter("lastNameEng");
		HttpSession session = request.getSession();
		//purchaseInfo
		PurchaseVO purchaseInfo = airlineService.getPurchaseInfo(purchaseNum);

		if(purchaseInfo==null){ 
			request.setAttribute("error", true);
			request.setAttribute("message", "예약번호를 다시 입력하세요");
			return "searchBookingInfo";				
		} 
		session.setAttribute("purchaseNum", purchaseNum);
		request.setAttribute("purchaseInfo", purchaseInfo);
		//selectRouteInfo
		ArrayList<Integer> selectRouteInfo = airlineService.getSelectRouteInfo(purchaseInfo.getPurchaseNum());
		ArrayList<String> selectRouteCode = airlineService.getSelectRouteCode(purchaseInfo.getPurchaseNum());

		//passengerInfo // 편도, 왕복 구분해서 할 수 있는 방법 찾아야함 (편도만 구현 중)
		Collection<PassengerVO> bookingInfoOneway = airlineService.getBookingInfo(selectRouteInfo.get(0));
		ArrayList<String> ticketNumList = new ArrayList<String>();
		for (PassengerVO passengerVO : bookingInfoOneway) {
			ticketNumList.add(passengerVO.getTicketNum());
		}
		if(bookingInfoOneway!=null){
			request.setAttribute("bookingInfo", bookingInfoOneway);
			url="getBookingInfo";
		}
		session.setAttribute("ticketNumList",ticketNumList.get(0));
		//		if(selectRouteInfo.size()==2){
		//			Collection<PassengerVO> bookingInfoRoundWay = airlineService.getBookingInfo(selectRouteInfo.get(1));
		//			if(bookingInfoRoundWay!=null){
		//				request.setAttribute("bookingInfo2", bookingInfoRoundWay);
		//				url="getBookingInfo";
		//			}
		//		}
		//airRoute 정보 가지고 오기 
		AirRouteVO bookingRouteInfo = airlineService.getBookingRouteInfo(selectRouteCode.get(0));
		request.setAttribute("bookingRouteInfo", bookingRouteInfo);
		session.setAttribute("routeCode", bookingRouteInfo.getRouteCode());

		return url;
	}

	//예약발권 설문 or 발권확인
	@RequestMapping (value="setSurveyAction", method=RequestMethod.POST)
	public String setSurveyAction(HttpServletRequest request){
		String url="getBookingInfo";
		HttpSession session = request.getSession();
		String ticketNum = session.getAttribute("ticketNumList").toString();
		String routeCode = session.getAttribute("routeCode").toString();
		String purchaseNum = session.getAttribute("purchaseNum").toString();
		request.setAttribute("bookingRouteInfo", airlineService.getRouteInfo(routeCode));
		request.setAttribute("purchaseInfo", airlineService.getPurchaseInfo(purchaseNum));
		//여권 번호 입력
		String passport = request.getParameter("passport0");
		String survey = request.getParameter("survey0");	
		if(airlineService.setPassport(ticketNum,passport)){
			request.setAttribute("passengerInfo", airlineService.getPassengerInfo(ticketNum));
			switch(survey){
			case "survey0":
				url="setSurveyBooking";
				break;
			case "ticket0":
				if(airlineService.getHabitInfo(ticketNum)){
					url="confirmBookingIssue";
				}
				break;
			}
		}
		return url;
	}

	@RequestMapping (value="setSurveyResultAction", method=RequestMethod.POST)
	public String setSurveyResultAction(HttpServletRequest request){
		String url="setSurvey";
		HttpSession session = request.getSession();
		String ticketNum = session.getAttribute("ticketNumList").toString();
		String routeCode = session.getAttribute("routeCode").toString();
		String purchaseNum = session.getAttribute("purchaseNum").toString();

		float clean = Float.parseFloat(request.getParameter("clean"));
		float sleep = Float.parseFloat(request.getParameter("sleep"));
		float active = Float.parseFloat(request.getParameter("active"));
		if(airlineService.setHabitInfo(ticketNum, clean, sleep, active))
			url="confirmBookingIssue";
		request.setAttribute("passengerInfo", airlineService.getPassengerInfo(ticketNum));
		request.setAttribute("bookingRouteInfo", airlineService.getRouteInfo(routeCode));
		request.setAttribute("purchaseInfo", airlineService.getPurchaseInfo(purchaseNum));
		return url;
	}

	@RequestMapping (value="setSeatSelectionUI", method=RequestMethod.POST)
	public String setSeatSelectionUI(HttpServletRequest request){
		//대표유형 비율 분석
		String url="setBookingSeatSelection";
		String seatNumber = request.getParameter("seatNumber");
		if(!seatNumber.equals("Z0")){
			url="getBookingTicket";
		}
		HttpSession session = request.getSession();
		String ticketNum = session.getAttribute("ticketNumList").toString();
		String routeCode = session.getAttribute("routeCode").toString();
		String purchaseNum = session.getAttribute("purchaseNum").toString();
		airlineService.setSeatNumber(ticketNum,seatNumber);
		request.setAttribute("passengerInfo", airlineService.getPassengerInfo(ticketNum));
		request.setAttribute("routeInfo", airlineService.getRouteInfo(routeCode));
		request.setAttribute("purchaseInfo", airlineService.getPurchaseInfo(purchaseNum));

		Collection<PassengerVO> HabitList = airlineService.getMainHabit(routeCode);
		HashMap<String,Integer> HabitPoint = new HashMap<String,Integer>();
		HabitPoint.put("clean",0);
		HabitPoint.put("sleep",0);
		HabitPoint.put("active",0);

		// 대표유형 정하기 
		for (PassengerVO passengerVO : HabitList) {
			String MainHabit = "active";
			if(passengerVO.getClean()>=2){
				MainHabit = "clean";
			}else if(passengerVO.getSleep()>=passengerVO.getActive()){
				MainHabit = "sleep";
			}
			//대표유형 사람수 파악
			if(MainHabit.equals("clean")){
				HabitPoint.replace("clean", HabitPoint.get("clean")+1);
			}else if(MainHabit.equals("sleep")){
				HabitPoint.replace("sleep", HabitPoint.get("sleep")+1);
			}else{
				HabitPoint.replace("active", HabitPoint.get("active")+1);
			}
		}

		int totalPoint = (int)(HabitPoint.get("clean")+HabitPoint.get("sleep")+HabitPoint.get("active"));
		request.setAttribute("cleanLine", Math.round((HabitPoint.get("clean")*12)/(float)totalPoint)); 
		request.setAttribute("activeLine", Math.round((HabitPoint.get("active")*12)/(float)totalPoint));
		request.setAttribute("sleepLine", Math.round((HabitPoint.get("sleep")*12)/(float)totalPoint));
		//예매좌석표시
		request.setAttribute("reservationSeats", airlineService.getReservationSeats(routeCode));
		//checkIn --> Y
		airlineService.updateCheckIn(ticketNum);

		return url;
	}
	@RequestMapping (value="setSeatSelectionAction", method=RequestMethod.POST)
	public String setSeatSelectionAction(HttpServletRequest request){
		String url="setSeatSelection";
		String seatNumber=request.getParameter("seatNumber");
		HttpSession session = request.getSession();
		String ticketNum = session.getAttribute("ticketNumList").toString();
		String routeCode = session.getAttribute("routeCode").toString();
		String purchaseNum = session.getAttribute("purchaseNum").toString();
		airlineService.setSeatNumber(ticketNum,seatNumber);
		request.setAttribute("passengerInfo", airlineService.getPassengerInfo(ticketNum));
		request.setAttribute("routeInfo", airlineService.getRouteInfo(routeCode));
		request.setAttribute("purchaseInfo", airlineService.getPurchaseInfo(purchaseNum));

		url="getBookingTicket";

		return url;
	}

	@RequestMapping(value="searchAirRouteUI",method=RequestMethod.GET)
	public String searchAirRouteUI(HttpServletRequest request){
		HttpSession session= request.getSession();
		String staffNum=session.getAttribute("staffNum").toString();
		String url="searchAirRoute";
		if(airlineService.checkWorkCode(staffNum)!=154){
			request.setAttribute("error", true);
			request.setAttribute("message", "해당 사원은 발권 권한이 없습니다.");
			url="main";
		}
		return url;
	}

	//항공편 검색 ajax
	@RequestMapping(value="searchAirRouteAction",method=RequestMethod.POST)
	public String searchAirRouteAction(HttpServletRequest request){
		String url="searchAirRouteRoundTrip";

		String category=request.getParameter("category"); //편도:oneWay 왕복:roundTrip
		String airportCodeDep=request.getParameter("airportCodeDep");//출발지
		String airportCodeArr=request.getParameter("airportCodeArr");//도착지
		String dateDep=request.getParameter("dateDep");//출발일
		String dateArr=request.getParameter("dateArr");//도착일 

		switch(category){
		case "O" :
			Collection<AirRouteVO> airRouteInfo=airlineService.searchAirRoute(airportCodeDep,airportCodeArr,dateDep);

			Collection<String> jsonList = new ArrayList<String>();
			for (AirRouteVO airRouteVO : airRouteInfo) { // 하나씩 분리
				Gson gson = new Gson();
				String json = gson.toJson(airRouteVO); // 분리된것을 json 형태 로 만들어줌
				jsonList.add(json);	//그 객체를 ArrrayList에 넣어줌			
			}
			request.setAttribute("resultJSON", jsonList);
			url="JSON";
			break;
		}
		return url;
	}

	//1. 현장예매 구간 운임 선택  ==> 구매자 정보입력 선택 액션
	@RequestMapping(value="selectAirRouteAction",method=RequestMethod.POST)
	public String selectAirRouteAction(HttpServletRequest request){
		String url="setPassengerInfo";

		String selectRouteCode = request.getParameter("selectRouteCode"); // 체크박스에 편명 넣음

		if(selectRouteCode==null){ //12.05 수정사항
			request.setAttribute("error", true);
			request.setAttribute("message", "항공편을 선택해 주세요.");
			return "searchAirRoute";

		} 
		String category=request.getParameter("category"); //편도:oneWay 왕복:roundTrip
		String airportCodeDep=request.getParameter("airportCodeDep");//출발지
		String airportCodeArr=request.getParameter("airportCodeArr");//도착지
		String dateDep=request.getParameter("dateDep");//출발일
		String dateArr=request.getParameter("dateArr");//도착일 
		int numAdult=Integer.parseInt(request.getParameter("numAdult"));//성인
		int numChild=Integer.parseInt(request.getParameter("numChild"));//유아
		int numInfant=Integer.parseInt(request.getParameter("numInfant"));//소아	

		PurchaseVO purchaseVO= new PurchaseVO();
		purchaseVO.setCategory(category);
		purchaseVO.setNumAdult(numAdult);
		purchaseVO.setNumChild(numChild);
		purchaseVO.setNumInfant(numInfant);

		Gson gson=new Gson();
		String purchaseInfo=gson.toJson(purchaseVO);
		//String selectRouteCode=gson.toJson(getSelectRouteCode);
		request.setAttribute("purchaseInfo", purchaseInfo);
		request.setAttribute("selectRouteCode", selectRouteCode);
		//System.out.println(purchaseInfo);


		//System.out.println(selectRouteCode+"\n"+ category +"\n"+ airportCodeDep+"\n"+ airportCodeArr+"\n"+dateDep+"\n"+dateArr+"\n"+numAdult+"\n"+numChild+"\n"+numInfant);// 선택한 체크박스의 값
		//비행편에 관한 정보와 구매 정보를 들고 와서  구간 운임선택으로 리턴 해야함

		return url;
	}

	//구매자 조회
	@RequestMapping(value="searchMember", method=RequestMethod.POST)
	public String searchPurchase(HttpServletRequest request){
		String purchaseId=request.getParameter("purchaseId");
		AirlineMemberVO member=airlineService.searchMember(purchaseId);

		Gson gson=new Gson();
		String json=gson.toJson(member);
		request.setAttribute("resultJSON", json);
		return "JSON";			
	}



	//2.탑승자 정보 입력 완료=> 부가서비스로 
	@RequestMapping(value="setPassengerInfoAction",method=RequestMethod.POST)
	public String setPassengerInfoAction(HttpServletRequest request){
		//VO 를 받아줌
		String getPurchaseInfo=request.getParameter("purchaseInfo"); 
		String purchaseId=request.getParameter("purchaseId");
		String passengerId =request.getParameter("passengerId");

		String selectRouteCode=request.getParameter("selectRouteCode");
		String gender = request.getParameter("gender");
		String passengerFirstNameEng = request.getParameter("passengerFirstNameEng");
		String passengerLastNameEng = request.getParameter("passengerLastNameEng");
		String nationality = request.getParameter("nationality");
		String passport=request.getParameter("passport");
		String birth = request.getParameter("birth");
		String phoneNumber= request.getParameter("phoneNumber");

		PassengerVO passenger=new PassengerVO();
		passenger.setGender(gender);
		passenger.setLastNameEng(passengerLastNameEng);
		passenger.setFirstNameEng(passengerFirstNameEng);
		passenger.setNationality(nationality);
		passenger.setPassport(passport);
		passenger.setBirth(birth);
		passenger.setPhoneNumber(phoneNumber);

		Gson gson=new Gson();
		PurchaseVO purchaseInfoJson = gson.fromJson(getPurchaseInfo, PurchaseVO.class); // 
		purchaseInfoJson.setId(purchaseId);			

		String purchaseInfo = gson.toJson(purchaseInfoJson);
		String passengerInfo=gson.toJson(passenger);

		request.setAttribute("purchaseInfo", purchaseInfo);
		request.setAttribute("selectRouteCode", selectRouteCode);
		request.setAttribute("passengerInfo", passengerInfo);
		request.setAttribute("passengerId", passengerId);
		String url="setAdditionalService";

		return url;
	}

	//3.부가서비스 처리
	@RequestMapping(value="setAdditionalServiceAction", method=RequestMethod.POST)
	public String setAdditionalServiceAction(HttpServletRequest request){
		String url="setAdditionalService";
		//들고다니는 값
		String purchaseInfo=request.getParameter("purchaseInfo");
		String selectRouteCode=request.getParameter("selectRouteCode");
		String getPassengerInfo=request.getParameter("passengerInfo");	
		String passengerId =request.getParameter("passengerId");

		//이번메서드에 받은값
		String survey=request.getParameter("survey");//서베이
		int luggage=Integer.parseInt(request.getParameter("luggage"));//수화물 
		String seatOrNot=request.getParameter("seatOrNot");//좌석선택

		int luggageFee;
		if(luggage == 1){
			luggageFee=0;
		}else if(luggage == 2){
			luggageFee=10000;
		}else if(luggage == 3){
			luggageFee=15000;
		}else{luggageFee=20000;
		}

		Gson gson=new Gson();
		PassengerVO passengerInfoJson=gson.fromJson(getPassengerInfo, PassengerVO.class);
		passengerInfoJson.setLuggage(luggage);
		passengerInfoJson.setLuggageFee(luggageFee);
		passengerInfoJson.setSeatOrNot(seatOrNot);

		if(survey.equals("N") ){
			AirRouteVO airRouteVO=airlineService.getRouteInfo(selectRouteCode);
			String airRouteInfo=gson.toJson(airRouteVO);
			request.setAttribute("airRouteInfo", airRouteInfo);	
			url="getOnsiteIssue";
			if(passengerId!=null){
				AirlineMemberVO habitInfo= airlineService.searchMember(passengerId);
				if(habitInfo.getClean()==0 && habitInfo.getSleep()==0 && habitInfo.getActive()==0){
					int	clean = 1;
					int sleep = 7;
					int active = 2;
					passengerInfoJson.setClean(clean);
					passengerInfoJson.setSleep(sleep);
					passengerInfoJson.setActive(active);
				}else{
					passengerInfoJson.setClean(habitInfo.getClean());
					passengerInfoJson.setSleep(habitInfo.getSleep());
					passengerInfoJson.setActive(habitInfo.getActive());
				}
			}
		}else{
			url="setSurveyOnsite";
		}
		String passengerInfo = gson.toJson(passengerInfoJson); // json 으로 패키징
		request.setAttribute("purchaseInfo", purchaseInfo);
		request.setAttribute("selectRouteCode", selectRouteCode);
		request.setAttribute("passengerInfo", passengerInfo);

		return url;
	}

	@RequestMapping (value="setSurveyOnsiteAction", method=RequestMethod.POST)
	public String setSurveyOnsiteAction(HttpServletRequest request){
		String url="setSurveyOnsite";
		String purchaseInfo=request.getParameter("purchaseInfo");
		String routeCode=request.getParameter("selectRouteCode");
		String getPassengerInfo=request.getParameter("passengerInfo");	

		Gson gson=new Gson();
		PassengerVO passengerInfoJson = gson.fromJson(getPassengerInfo, PassengerVO.class);

		float clean = Float.parseFloat(request.getParameter("clean"));
		float sleep = Float.parseFloat(request.getParameter("sleep"));
		float active = Float.parseFloat(request.getParameter("active"));
		int totalPoint = (int)(clean+(sleep/10)+(active/10));
		int cleanPoint = Math.round((clean*10)/(float)totalPoint);
		int activePoint = Math.round((active)/(float)totalPoint);
		int sleepPoint = Math.round((sleep)/(float)totalPoint);
		passengerInfoJson.setClean(cleanPoint);
		passengerInfoJson.setSleep(sleepPoint);
		passengerInfoJson.setActive(activePoint);
		String passengerInfo=gson.toJson(passengerInfoJson);

		request.setAttribute("purchaseInfo", purchaseInfo);
		request.setAttribute("passengerInfo", passengerInfo);		

		//홈컨트롤러 바뀐내용 DB 
		AirRouteVO airRouteVO=airlineService.getRouteInfo(routeCode);
		String airRouteInfo=gson.toJson(airRouteVO);
		request.setAttribute("airRouteInfo", airRouteInfo);

		url="getOnsiteIssue";
		return url;
	}

	@RequestMapping (value="getOnsiteIssueAction", method=RequestMethod.POST)
	public String getOnsiteIssueAction (HttpServletRequest request){
		String url = "getOnsiteIssue";
		String getpurchaseInfo=request.getParameter("purchaseInfo");
		String getPassengerInfo=request.getParameter("passengerInfo");
		String airRouteInfo=request.getParameter("airRouteInfo");
		String passengerTotalPrice=request.getParameter("totalFee");

		Gson gson=new Gson();
		PassengerVO passengerInfoJson=gson.fromJson(getPassengerInfo, PassengerVO.class);
		passengerInfoJson.setPassengerTotalPrice(Integer.parseInt(passengerTotalPrice));
		String passengerInfo=gson.toJson(passengerInfoJson);
		url = "confirmPayment";

		PurchaseVO purchaseInfoJson=gson.fromJson(getpurchaseInfo, PurchaseVO.class);
		purchaseInfoJson.setTotalPrice(Integer.parseInt(passengerTotalPrice));
		String id= purchaseInfoJson.getId();
		request.setAttribute("purchaseName",airlineService.getPurchaseName(id));
		String purchaseInfo=gson.toJson(purchaseInfoJson,PurchaseVO.class);
		request.setAttribute("purchaseInfo", purchaseInfo);
		request.setAttribute("passengerInfo", passengerInfo);	
		request.setAttribute("airRouteInfo", airRouteInfo);

		return url;
	}

	// 현장 발권 결제 -> 모든 정보 DB로 insert
	@RequestMapping (value="confirmPaymentAction", method=RequestMethod.POST)
	public String confirmPaymentAction (HttpServletRequest request){
		String url = "confirmPayment";
		//값 다 받아오기
		String purchaseInfo=request.getParameter("purchaseInfo");
		String getPassengerInfo=request.getParameter("passengerInfo");
		String airRouteInfo=request.getParameter("airRouteInfo");

		//모든 데이터 풀기 
		Gson gson = new Gson();
		PurchaseVO purchaseInfoJSON=gson.fromJson(purchaseInfo, PurchaseVO.class);
		PassengerVO passengerInfoJSON=gson.fromJson(getPassengerInfo, PassengerVO.class);
		AirRouteVO airRouteInfoJSON=gson.fromJson(airRouteInfo, AirRouteVO.class);
		String routeCode=airRouteInfoJSON.getRouteCode();		

		//purchaseNum,routeInfoNum,ticketNum 생성 
		String purchaseNum = RandomStringUtils.randomAlphanumeric(6);
		int routeInfoNum = Integer.parseInt(RandomStringUtils.randomNumeric(6));
		String ticketNum = RandomStringUtils.randomAlphanumeric(8);

		//DB에 넣기
		airlineService.addPurchaseInfo(purchaseNum, purchaseInfoJSON.getCategory(),purchaseInfoJSON.getNumAdult(),purchaseInfoJSON.getNumChild(),purchaseInfoJSON.getNumInfant(),purchaseInfoJSON.getTotalPrice(),"","","Credit",purchaseInfoJSON.getId());
		airlineService.addSelectRoute(routeInfoNum,routeCode,purchaseNum);
		airlineService.addPassengerInfo(ticketNum,passengerInfoJSON.getLastNameEng(),passengerInfoJSON.getFirstNameEng(),"","",passengerInfoJSON.getGender(),passengerInfoJSON.getNationality(),passengerInfoJSON.getBirth(),passengerInfoJSON.getPhoneNumber(),passengerInfoJSON.getPassport(),"Y",passengerInfoJSON.getLuggage(),passengerInfoJSON.getLuggageFee(),passengerInfoJSON.getSeatFee(),passengerInfoJSON.getPassengerTotalPrice(),"Z0",passengerInfoJSON.getClean(),passengerInfoJSON.getSleep(),passengerInfoJSON.getActive(),routeInfoNum);



		//대표유형 비율 계산
		Collection<PassengerVO> HabitList = airlineService.getMainHabit(routeCode);
		HashMap<String,Integer> HabitPoint = new HashMap<String,Integer>();
		HabitPoint.put("clean",0);
		HabitPoint.put("sleep",0);
		HabitPoint.put("active",0);

		for (PassengerVO passengerVO : HabitList) {
			String MainHabit = "active";
			if(passengerVO.getClean()>=2){
				MainHabit = "clean";
			}else if(passengerVO.getSleep()>=passengerVO.getActive()){
				MainHabit = "sleep";
			}
			if(MainHabit.equals("clean")){
				HabitPoint.replace("clean", HabitPoint.get("clean")+1);
			}else if(MainHabit.equals("sleep")){
				HabitPoint.replace("sleep", HabitPoint.get("sleep")+1);
			}else{
				HabitPoint.replace("active", HabitPoint.get("active")+1);
			}
		}
		int totalPoint = (int)(HabitPoint.get("clean")+HabitPoint.get("sleep")+HabitPoint.get("active"));
		request.setAttribute("cleanLine", Math.round((HabitPoint.get("clean")*12)/(float)totalPoint)); 
		request.setAttribute("activeLine", Math.round((HabitPoint.get("active")*12)/(float)totalPoint));
		request.setAttribute("sleepLine", Math.round((HabitPoint.get("sleep")*12)/(float)totalPoint));

		//예매좌석표시
		request.setAttribute("reservationSeats", airlineService.getReservationSeats(routeCode));

		//모든 데이터 넘기기  setOnsiteSeatSelection
		request.setAttribute("ticketNum",ticketNum);
		request.setAttribute("routeCode", airRouteInfoJSON.getRouteCode());
		request.setAttribute("purchaseNum", purchaseNum);


		url = "setOnsiteSeatSelection";
		return url;
	}

	@RequestMapping (value="setOnsiteSeatSelectionAction", method=RequestMethod.POST)
	public String setOnsiteSeatSelectionAction(HttpServletRequest request){
		String url="setSeatSelection";
		//값 다 가져오기 
		String seatNumber=request.getParameter("seatNumber");
		String ticketNum=request.getParameter("ticketNum");
		String routeCode=request.getParameter("routeCode");
		String purchaseNum=request.getParameter("purchaseNum");

		// passenger에 seatNumber 넣기

		airlineService.setSeatNumber(ticketNum,seatNumber);

		// DB에서 받아서 보내기 
		request.setAttribute("passengerInfo", airlineService.getPassengerInfo(ticketNum));
		request.setAttribute("routeInfo", airlineService.getRouteInfo(routeCode));
		request.setAttribute("purchaseInfo", airlineService.getPurchaseInfo(purchaseNum));

		url="getOnsiteTicket";

		return url;
	}




}