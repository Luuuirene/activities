//package com;
//
//
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
//
//import com.activities_category.model.CategoryRepository;
//import com.activities_category.model.CategoryVO;
//import com.activity.hibernate.util.CompositeQuery.Category_Compositegory;
//
//@SpringBootApplication
//public class Test_Application_CommandLineRunner implements CommandLineRunner{
//
//	@Autowired
//	CategoryRepository categoryRepository;
//	
//	@Autowired
//	private SessionFactory sessionFactory;
//	
//	public static void main(String[] args) {
//        SpringApplication.run(Test_Application_CommandLineRunner.class);
//    }
//	
//	@Override
//	public void run(String... args) throws Exception {
		// 新增
		
//		CategoryVO categoryVO = new CategoryVO();
//		categoryVO.setActivityCategoryName("親子活動");
//		categoryVO.setActivityCategoryInfo("Test");
//		categoryRepository.save(categoryVO);
		
		//修改
//		CategoryVO categoryVO = new CategoryVO();
//		categoryVO.setActivityCategoryId(4);
//		categoryVO.setActivityCategoryName("情侶活動");
//		categoryVO.setActivityCategoryInfo("test2");
//		categoryRepository.save(categoryVO);
		
		//刪除
//		categoryRepository.deleteById(4);
		
		//查詢-findByPrimaryKey
//		Optional<CategoryVO> optional = categoryRepository.findById(1);
//		CategoryVO categoryVO2 = optional.get();
//		System.out.println(categoryVO2.getActivityCategoryId() + ",");
//		System.out.println(categoryVO2.getActivityCategoryName() + ",");
//		System.out.println(categoryVO2.getActivityCategoryInfo() + ",");
		
//		查詢-getAll
//		List<CategoryVO> list = categoryRepository.findAll();
//		for (CategoryVO aCategoryVO : list) {
//			System.out.print(aCategoryVO.getActivityCategoryId() + ",");
//			System.out.print(aCategoryVO.getActivityCategoryName() + ",");
//			System.out.print(aCategoryVO.getActivityCategoryInfo() + ",");
//			System.out.println();
//		}
		
		//● 複合查詢-getAll(map) 配合 req.getParameterMap()方法 回傳 java.util.Map<java.lang.String,java.lang.String[]> 之測試
//		Map<String, String[]> map = new TreeMap<String, String[]>();
//		
//		map.put("activityCategoryName", new String[] { "水上活動" });
//		map.put("activityCategoryInfo", new String[] { "潛水" });
//		
//		List<CategoryVO> list2 = Category_Compositegory.getAllCategory(map, sessionFactory.openSession());
//		for (CategoryVO aCategoryVO : list2) {
//			System.out.print(aCategoryVO.getActivityCategoryId() + ",");
//			System.out.print(aCategoryVO.getActivityCategoryName() + ",");
//			System.out.print(aCategoryVO.getActivityCategoryInfo() + ",");
//			System.out.println();
//		}
//	}
//	
//	
//
//}
