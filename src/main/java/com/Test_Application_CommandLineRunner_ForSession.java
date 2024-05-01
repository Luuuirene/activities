package com;

//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//import java.util.TreeMap;
//
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import com.activities_session.model.ItemVO_ForSe;
//import com.activities_session.model.SessionRepository;
//import com.activities_session.model.SessionVO;
//import com.activity.hibernate.util.CompositeQuery.Session_Compositegory;
//
//@SpringBootApplication
//public class Test_Application_CommandLineRunner_ForSession implements CommandLineRunner{
//	
//	@Autowired
//	SessionRepository sessionRepository;
//	
//	@Autowired
//	private SessionFactory sessionFactory;
//	
//	public static void main(String[] args) {
//        SpringApplication.run(Test_Application_CommandLineRunner_ForSession.class);
//    }
//
//	@Override
//	public void run(String... args) throws Exception {
		
		// 新增
//		ItemVO_ForSe itemVO_ForSe = new ItemVO_ForSe();
//		itemVO_ForSe.setActivityId(3);
		
//		SessionVO sessionVO = new SessionVO();
//		sessionVO.setActivityStarted(java.sql.Timestamp.valueOf("2024-04-01 09:00:00"));
//		sessionVO.setActivityEnd(java.sql.Timestamp.valueOf("2024-04-01 12:00:00"));
//		sessionVO.setActivityLocation("凱克特司1樓大廳");;
//		sessionVO.setActivityMaxPart(20);
//		sessionVO.setActivityMinPart(40);
//		sessionVO.setEnrollTotal(40);
//		sessionVO.setEnrollStarted(java.sql.Timestamp.valueOf("2024-03-01 09:00:00"));
//		sessionVO.setEnrollEnd(java.sql.Timestamp.valueOf("2024-03-31 09:00:00"));
//		sessionVO.setActivitySessionState(0);
//		sessionVO.setActivityNote("TEST");
//		sessionVO.setItemVO_ForSe(itemVO_ForSe);
//		sessionRepository.save(sessionVO);
		
		//修改
//		SessionVO sessionVO2 = new SessionVO();
//		sessionVO2.setActivitySessionId(4);
//		sessionVO2.setActivityStarted(java.sql.Timestamp.valueOf("2024-04-01 10:00:00"));
//		sessionVO2.setActivityEnd(java.sql.Timestamp.valueOf("2024-04-01 12:00:00"));
//		sessionVO2.setActivityLocation("凱克特司1樓大廳test");;
//		sessionVO2.setActivityMaxPart(20);
//		sessionVO2.setActivityMinPart(40);
//		sessionVO2.setEnrollTotal(40);
//		sessionVO2.setEnrollStarted(java.sql.Timestamp.valueOf("2024-03-01 09:00:00"));
//		sessionVO2.setEnrollEnd(java.sql.Timestamp.valueOf("2024-03-31 09:00:00"));
//		sessionVO2.setActivitySessionState(1);
//		sessionVO2.setActivityNote("TEST++");
//		
//		ItemVO_ForSe itemVO_ForSe = new ItemVO_ForSe();
//		itemVO_ForSe.setActivityId(3);
//		sessionVO2.setItemVO_ForSe(itemVO_ForSe);
//		
//		sessionRepository.save(sessionVO2);
		
		
		//刪除
//		sessionRepository.deleteById(3);
		
		//● 查詢-findByPrimaryKey
//		Optional<SessionVO> optional = sessionRepository.findById(1);
//		SessionVO sessionVO3 = optional.get();
//		System.out.print(sessionVO3.getActivitySessionId() + ",");
//		System.out.print(sessionVO3.getItemVO_ForSe().getActivityId()+ ",");
//		System.out.print(sessionVO3.getActivityStarted()+ ",");
//		System.out.print(sessionVO3.getActivityEnd()+ ",");
//		System.out.print(sessionVO3.getActivityLocation()+ ",");
//		System.out.print(sessionVO3.getActivityMaxPart()+ ",");
//		System.out.print(sessionVO3.getActivityMinPart()+ ",");
//		System.out.print(sessionVO3.getEnrollTotal()+ ",");
//		System.out.print(sessionVO3.getEnrollStarted()+ ",");
//		System.out.print(sessionVO3.getEnrollEnd()+ ",");
//		System.out.print(sessionVO3.getActivitySessionState()+ ",");
//		System.out.print(sessionVO3.getActivityNote()+ ",");
//		System.out.println("----------------------");
		
		
		//查詢-getAll
//		List<SessionVO> list = sessionRepository.findAll();
//		for(SessionVO aSessionVO : list) {
//			System.out.print(aSessionVO.getActivitySessionId()+ ",");
//			System.out.print(aSessionVO.getItemVO_ForSe().getActivityId()+ ",");
//			System.out.print(aSessionVO.getActivityStarted()+ ",");
//			System.out.print(aSessionVO.getActivityEnd()+ ",");
//			System.out.print(aSessionVO.getActivityLocation()+ ",");
//			System.out.print(aSessionVO.getActivityMaxPart()+ ",");
//			System.out.print(aSessionVO.getActivityMinPart()+ ",");
//			System.out.print(aSessionVO.getEnrollTotal()+ ",");
//			System.out.print(aSessionVO.getEnrollStarted()+ ",");
//			System.out.print(aSessionVO.getEnrollEnd()+ ",");
//			System.out.print(aSessionVO.getActivitySessionState()+ ",");
//			System.out.print(aSessionVO.getActivityNote()+ ",");
//			
//			System.out.println();
//			
//		}
		
		//● 複合查詢-getAll(map) 配合 req.getParameterMap()方法 回傳 java.util.Map<java.lang.String,java.lang.String[]> 之測試
//		Map<String, String[]> map = new TreeMap<String, String[]>();
//		map.put("activitySessionId", new String[] {"3"});
//		map.put("activityId", new String[] {"3"});
//		map.put("activityStarted", new String[] {"2024-04-30 13:00:00"});
//		map.put("activityEnd", new String[] {"2024-04-30 15:00:00"});
//		map.put("activityLocation", new String[] {"嵵裡沙灘"});
//		map.put("activityMaxPart", new String[] {"40"});
//		map.put("activityMinPart", new String[] {"10"});
//		map.put("enrollTotal", new String[] {"40"});
//		map.put("enrollStarted", new String[] {"2024-04-20 08:00:00"});
//		map.put("enrollEnd", new String[] {"2024-04-30 00:00:00"});
//		map.put("activitySessionState", new String[] {"0"});
//		map.put("activitySessionNote", new String[] {"幫教練準備一個蛙鏡"});
		
//		List<SessionVO> list2 = Session_Compositegory.getAllSessionVOs(map, sessionFactory.openSession());
//		for(SessionVO aSessionVO : list2) {
//			System.out.print(aSessionVO.getActivitySessionId() + ",");
//			System.out.print(aSessionVO.getItemVO_ForSe().getActivityId() + ",");
//			System.out.print(aSessionVO.getActivityStarted() + ",");
//			System.out.print(aSessionVO.getActivityEnd() + ",");
//			System.out.print(aSessionVO.getActivityLocation() + ",");
//			System.out.print(aSessionVO.getActivityMaxPart() + ",");
//			System.out.print(aSessionVO.getActivityMinPart() + ",");
//			System.out.print(aSessionVO.getEnrollTotal() + ",");
//			System.out.print(aSessionVO.getEnrollStarted() + ",");
//			System.out.print(aSessionVO.getEnrollEnd() + ",");
//			System.out.print(aSessionVO.getActivitySessionState() + ",");
//			System.out.print(aSessionVO.getActivityNote() + ",");
//			System.out.println("\n" + "=============");
//			
//		}
//		
//		
//		
//		
//	}
//	
//	
//
//}
