package com;

//import java.util.*;
//import java.util.Optional;
//
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import com.activities_item.model.CategoryVO_ForIt;
//import com.activities_item.model.ItemRepository;
//import com.activities_item.model.ItemVO;
//import com.activity.hibernate.util.CompositeQuery.Item_Compositegory;


//@SpringBootApplication
//public class Test_Application_CommandLineRunner_ForItem implements CommandLineRunner{
//	
//	@Autowired
//	ItemRepository itemRepository;
//	
//	@Autowired
//	private SessionFactory sessionFactory;
//	
//	public static void main(String[] args) {
//        SpringApplication.run(Test_Application_CommandLineRunner_ForItem.class);
//    }
//
//	@Override
//	public void run(String... args) throws Exception {
		
		// 新增
//		CategoryVO_ForIt categoryVO_ForIt = new CategoryVO_ForIt();
//		categoryVO_ForIt.setActivityCategoryId(2);
//		
//		ItemVO itemVO = new ItemVO();
//		itemVO.setActivityName("BBQ 晚餐吃到飽");
//		itemVO.setActivityDescription("吃到飽");
//		itemVO.setActivityInfo("吃到飽");
//		itemVO.setActivityPrice(1000);
//		itemVO.setActivityState(false);
//		itemVO.setCategoryVO_ForIt(categoryVO_ForIt);
//		itemRepository.save(itemVO);
		
		//修改
//		ItemVO itemVO2 = new ItemVO();
//		itemVO2.setActivityId(10);
//		itemVO2.setActivityName("BBQ晚餐吃到飽");
//		itemVO2.setActivityDescription("吃到飽test2");
//		itemVO2.setActivityInfo("吃到飽");
//		itemVO2.setActivityPrice(1000);
//		itemVO2.setActivityState(false);
//		
//		CategoryVO_ForIt categoryVO_ForIt = new CategoryVO_ForIt();
//		categoryVO_ForIt.setActivityCategoryId(2);
//		itemVO2.setCategoryVO_ForIt(categoryVO_ForIt);
//		
//		itemRepository.save(itemVO2);
		
		//刪除
//		itemRepository.deleteByActivityId(5);
		
		//● 查詢-findByPrimaryKey
//		Optional<ItemVO> optional = itemRepository.findById(1);
//		ItemVO itemVO2 = optional.get();
//		System.out.print(itemVO2.getActivityId() + ",");
//		System.out.println(itemVO2.getCategoryVO_ForIt().getActivityCategoryId() + ",");
//		System.out.print(itemVO2.getActivityName() + ",");
//		System.out.print(itemVO2.getActivityDescription() + ",");
//		System.out.print(itemVO2.getActivityInfo() + ",");
//		System.out.print(itemVO2.getActivityPrice() + ",");
//		System.out.print(itemVO2.getActivityState() + ",");
//		
//		System.out.println("\n---------------------");
		
		
		//查詢-getAll
		
//		List<ItemVO> list = itemRepository.findAll();
//		for (ItemVO aItemVO : list) {
//			System.out.print(aItemVO.getActivityId() + ",");
//			System.out.print(aItemVO.getCategoryVO_ForIt().getActivityCategoryId() + ",");
//			System.out.print(aItemVO.getActivityName() + ",");
//			System.out.print(aItemVO.getActivityDescription() + ",");
//			System.out.print(aItemVO.getActivityInfo() + ",");
//			System.out.print(aItemVO.getActivityPrice() + ",");
//			System.out.print(aItemVO.getActivityState() + ",");
//			
//			System.out.println();
//		}
		
		//● 複合查詢-getAll(map) 配合 req.getParameterMap()方法 回傳 java.util.Map<java.lang.String,java.lang.String[]> 之測試
//		Map<String, String[]> map = new TreeMap<String, String[]>();
//		map.put("activityId", new String[] { "3" });
//		map.put("activityName", new String[] { "吃到飽" });
//		map.put("activityDescription", new String[] { "水" });
//		map.put("activityInfo", new String[] { "吃到飽" });
//		map.put("activityPrice", new String[] { "1000" });
//		map.put("activityState", new String[] { "0" }); //也可以輸入false
//		map.put("activityCategoryId", new String[] { "1" });
		
//		List<ItemVO> list2 = Item_Compositegory.getAllItemVOs(map, sessionFactory.openSession());
//		for (ItemVO aItemVO : list2) {
//			System.out.print(aItemVO.getActivityId() + ",");
//			System.out.print(aItemVO.getCategoryVO_ForIt().getActivityCategoryId() + ",");
//			System.out.print(aItemVO.getActivityName() + ",");
//			System.out.print(aItemVO.getActivityDescription() + ",");
//			System.out.print(aItemVO.getActivityInfo() + ",");
//			System.out.print(aItemVO.getActivityPrice() + ",");
//			System.out.print(aItemVO.getActivityState() + ",");
//			System.out.println();
//		}
//		
//		
//		
//	}
//	
//	
//
//}
