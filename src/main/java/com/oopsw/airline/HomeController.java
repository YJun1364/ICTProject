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

	//����UI
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
			request.setAttribute("message", "���� ����Դϴ�. (AA000 �������� �Է��ϼ���.)");
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
			request.setAttribute("message", "�ش� ����� �߱� ������ �����ϴ�.");
			url="main";
		}
		return url;
	}

	@RequestMapping(value="searchBookingInfoAction", method=RequestMethod.POST)
	public String searchBookingInfo(HttpServletRequest request){
		String url="searchBookingInfo";

		//�Է�
		String purchaseNum = request.getParameter("purchaseNum");
		String firstNameEng = request.getParameter("firstNameEng");
		String lastNameEng = request.getParameter("lastNameEng");
		HttpSession session = request.getSession();
		//purchaseInfo
		PurchaseVO purchaseInfo = airlineService.getPurchaseInfo(purchaseNum);

		if(purchaseInfo==null){ 
			request.setAttribute("error", true);
			request.setAttribute("message", "�����ȣ�� �ٽ� �Է��ϼ���");
			return "searchBookingInfo";				
		} 
		session.setAttribute("purchaseNum", purchaseNum);
		request.setAttribute("purchaseInfo", purchaseInfo);
		//selectRouteInfo
		ArrayList<Integer> selectRouteInfo = airlineService.getSelectRouteInfo(purchaseInfo.getPurchaseNum());
		ArrayList<String> selectRouteCode = airlineService.getSelectRouteCode(purchaseInfo.getPurchaseNum());

		//passengerInfo // ��, �պ� �����ؼ� �� �� �ִ� ��� ã�ƾ��� (���� ���� ��)
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
		//airRoute ���� ������ ���� 
		AirRouteVO bookingRouteInfo = airlineService.getBookingRouteInfo(selectRouteCode.get(0));
		request.setAttribute("bookingRouteInfo", bookingRouteInfo);
		session.setAttribute("routeCode", bookingRouteInfo.getRouteCode());

		return url;
	}

	//����߱� ���� or �߱�Ȯ��
	@RequestMapping (value="setSurveyAction", method=RequestMethod.POST)
	public String setSurveyAction(HttpServletRequest request){
		String url="getBookingInfo";
		HttpSession session = request.getSession();
		String ticketNum = session.getAttribute("ticketNumList").toString();
		String routeCode = session.getAttribute("routeCode").toString();
		String purchaseNum = session.getAttribute("purchaseNum").toString();
		request.setAttribute("bookingRouteInfo", airlineService.getRouteInfo(routeCode));
		request.setAttribute("purchaseInfo", airlineService.getPurchaseInfo(purchaseNum));
		//���� ��ȣ �Է�
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
		//��ǥ���� ���� �м�
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

		// ��ǥ���� ���ϱ� 
		for (PassengerVO passengerVO : HabitList) {
			String MainHabit = "active";
			if(passengerVO.getClean()>=2){
				MainHabit = "clean";
			}else if(passengerVO.getSleep()>=passengerVO.getActive()){
				MainHabit = "sleep";
			}
			//��ǥ���� ����� �ľ�
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
		//�����¼�ǥ��
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
			request.setAttribute("message", "�ش� ����� �߱� ������ �����ϴ�.");
			url="main";
		}
		return url;
	}

	//�װ��� �˻� ajax
	@RequestMapping(value="searchAirRouteAction",method=RequestMethod.POST)
	public String searchAirRouteAction(HttpServletRequest request){
		String url="searchAirRouteRoundTrip";

		String category=request.getParameter("category"); //��:oneWay �պ�:roundTrip
		String airportCodeDep=request.getParameter("airportCodeDep");//�����
		String airportCodeArr=request.getParameter("airportCodeArr");//������
		String dateDep=request.getParameter("dateDep");//�����
		String dateArr=request.getParameter("dateArr");//������ 

		switch(category){
		case "O" :
			Collection<AirRouteVO> airRouteInfo=airlineService.searchAirRoute(airportCodeDep,airportCodeArr,dateDep);

			Collection<String> jsonList = new ArrayList<String>();
			for (AirRouteVO airRouteVO : airRouteInfo) { // �ϳ��� �и�
				Gson gson = new Gson();
				String json = gson.toJson(airRouteVO); // �и��Ȱ��� json ���� �� �������
				jsonList.add(json);	//�� ��ü�� ArrrayList�� �־���			
			}
			request.setAttribute("resultJSON", jsonList);
			url="JSON";
			break;
		}
		return url;
	}

	//1. ���忹�� ���� ���� ����  ==> ������ �����Է� ���� �׼�
	@RequestMapping(value="selectAirRouteAction",method=RequestMethod.POST)
	public String selectAirRouteAction(HttpServletRequest request){
		String url="setPassengerInfo";

		String selectRouteCode = request.getParameter("selectRouteCode"); // üũ�ڽ��� ��� ����

		if(selectRouteCode==null){ //12.05 ��������
			request.setAttribute("error", true);
			request.setAttribute("message", "�װ����� ������ �ּ���.");
			return "searchAirRoute";

		} 
		String category=request.getParameter("category"); //��:oneWay �պ�:roundTrip
		String airportCodeDep=request.getParameter("airportCodeDep");//�����
		String airportCodeArr=request.getParameter("airportCodeArr");//������
		String dateDep=request.getParameter("dateDep");//�����
		String dateArr=request.getParameter("dateArr");//������ 
		int numAdult=Integer.parseInt(request.getParameter("numAdult"));//����
		int numChild=Integer.parseInt(request.getParameter("numChild"));//����
		int numInfant=Integer.parseInt(request.getParameter("numInfant"));//�Ҿ�	

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


		//System.out.println(selectRouteCode+"\n"+ category +"\n"+ airportCodeDep+"\n"+ airportCodeArr+"\n"+dateDep+"\n"+dateArr+"\n"+numAdult+"\n"+numChild+"\n"+numInfant);// ������ üũ�ڽ��� ��
		//������ ���� ������ ���� ������ ��� �ͼ�  ���� ���Ӽ������� ���� �ؾ���

		return url;
	}

	//������ ��ȸ
	@RequestMapping(value="searchMember", method=RequestMethod.POST)
	public String searchPurchase(HttpServletRequest request){
		String purchaseId=request.getParameter("purchaseId");
		AirlineMemberVO member=airlineService.searchMember(purchaseId);

		Gson gson=new Gson();
		String json=gson.toJson(member);
		request.setAttribute("resultJSON", json);
		return "JSON";			
	}



	//2.ž���� ���� �Է� �Ϸ�=> �ΰ����񽺷� 
	@RequestMapping(value="setPassengerInfoAction",method=RequestMethod.POST)
	public String setPassengerInfoAction(HttpServletRequest request){
		//VO �� �޾���
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

	//3.�ΰ����� ó��
	@RequestMapping(value="setAdditionalServiceAction", method=RequestMethod.POST)
	public String setAdditionalServiceAction(HttpServletRequest request){
		String url="setAdditionalService";
		//���ٴϴ� ��
		String purchaseInfo=request.getParameter("purchaseInfo");
		String selectRouteCode=request.getParameter("selectRouteCode");
		String getPassengerInfo=request.getParameter("passengerInfo");	
		String passengerId =request.getParameter("passengerId");

		//�̹��޼��忡 ������
		String survey=request.getParameter("survey");//������
		int luggage=Integer.parseInt(request.getParameter("luggage"));//��ȭ�� 
		String seatOrNot=request.getParameter("seatOrNot");//�¼�����

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
		String passengerInfo = gson.toJson(passengerInfoJson); // json ���� ��Ű¡
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

		//Ȩ��Ʈ�ѷ� �ٲﳻ�� DB 
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

	// ���� �߱� ���� -> ��� ���� DB�� insert
	@RequestMapping (value="confirmPaymentAction", method=RequestMethod.POST)
	public String confirmPaymentAction (HttpServletRequest request){
		String url = "confirmPayment";
		//�� �� �޾ƿ���
		String purchaseInfo=request.getParameter("purchaseInfo");
		String getPassengerInfo=request.getParameter("passengerInfo");
		String airRouteInfo=request.getParameter("airRouteInfo");

		//��� ������ Ǯ�� 
		Gson gson = new Gson();
		PurchaseVO purchaseInfoJSON=gson.fromJson(purchaseInfo, PurchaseVO.class);
		PassengerVO passengerInfoJSON=gson.fromJson(getPassengerInfo, PassengerVO.class);
		AirRouteVO airRouteInfoJSON=gson.fromJson(airRouteInfo, AirRouteVO.class);
		String routeCode=airRouteInfoJSON.getRouteCode();		

		//purchaseNum,routeInfoNum,ticketNum ���� 
		String purchaseNum = RandomStringUtils.randomAlphanumeric(6);
		int routeInfoNum = Integer.parseInt(RandomStringUtils.randomNumeric(6));
		String ticketNum = RandomStringUtils.randomAlphanumeric(8);

		//DB�� �ֱ�
		airlineService.addPurchaseInfo(purchaseNum, purchaseInfoJSON.getCategory(),purchaseInfoJSON.getNumAdult(),purchaseInfoJSON.getNumChild(),purchaseInfoJSON.getNumInfant(),purchaseInfoJSON.getTotalPrice(),"","","Credit",purchaseInfoJSON.getId());
		airlineService.addSelectRoute(routeInfoNum,routeCode,purchaseNum);
		airlineService.addPassengerInfo(ticketNum,passengerInfoJSON.getLastNameEng(),passengerInfoJSON.getFirstNameEng(),"","",passengerInfoJSON.getGender(),passengerInfoJSON.getNationality(),passengerInfoJSON.getBirth(),passengerInfoJSON.getPhoneNumber(),passengerInfoJSON.getPassport(),"Y",passengerInfoJSON.getLuggage(),passengerInfoJSON.getLuggageFee(),passengerInfoJSON.getSeatFee(),passengerInfoJSON.getPassengerTotalPrice(),"Z0",passengerInfoJSON.getClean(),passengerInfoJSON.getSleep(),passengerInfoJSON.getActive(),routeInfoNum);



		//��ǥ���� ���� ���
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

		//�����¼�ǥ��
		request.setAttribute("reservationSeats", airlineService.getReservationSeats(routeCode));

		//��� ������ �ѱ��  setOnsiteSeatSelection
		request.setAttribute("ticketNum",ticketNum);
		request.setAttribute("routeCode", airRouteInfoJSON.getRouteCode());
		request.setAttribute("purchaseNum", purchaseNum);


		url = "setOnsiteSeatSelection";
		return url;
	}

	@RequestMapping (value="setOnsiteSeatSelectionAction", method=RequestMethod.POST)
	public String setOnsiteSeatSelectionAction(HttpServletRequest request){
		String url="setSeatSelection";
		//�� �� �������� 
		String seatNumber=request.getParameter("seatNumber");
		String ticketNum=request.getParameter("ticketNum");
		String routeCode=request.getParameter("routeCode");
		String purchaseNum=request.getParameter("purchaseNum");

		// passenger�� seatNumber �ֱ�

		airlineService.setSeatNumber(ticketNum,seatNumber);

		// DB���� �޾Ƽ� ������ 
		request.setAttribute("passengerInfo", airlineService.getPassengerInfo(ticketNum));
		request.setAttribute("routeInfo", airlineService.getRouteInfo(routeCode));
		request.setAttribute("purchaseInfo", airlineService.getPurchaseInfo(purchaseNum));

		url="getOnsiteTicket";

		return url;
	}




}