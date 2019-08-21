package com.mxq.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mxq.App;
import com.mxq.dao.UsersRepository;
import com.mxq.dao.UsersRepositoryByName;
import com.mxq.dao.UsersRepositoryCrudRepository;
import com.mxq.dao.UsersRepositoryPagingAndSorting;
import com.mxq.dao.UsersRepositoryQueryAnnotation;
import com.mxq.dao.UsersRepositorySpecification;
import com.mxq.pojo.Users;

/**
 *测试类 
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class UsersRepositoryTest {

	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private UsersRepositoryByName usersRepositoryByName;
	@Autowired
	private UsersRepositoryQueryAnnotation usersRepositoryQueryAnnotation;
	@Autowired
	private UsersRepositoryCrudRepository usersRepositoryCrudRepository;
	@Autowired
	private UsersRepositoryPagingAndSorting usersRepositoryPagingAndSorting;
	@Autowired
	private UsersRepositorySpecification usersRepositorySpecification;
	@Test
	public void testsave() {
		
		Users user = new Users();
		user.setName("王五");
		user.setAddress("贵阳白云区");
		user.setAge(22);
		usersRepository.save(user);
	}
	
	/**
	 * Repository--方法命名测试
	 */
	@Test
	public void testFindByName() {
		List<Users> list = this.usersRepositoryByName.findByName("张三");
		for(Users us:list) {
			System.out.println(us.toString());
		}
	}
	
	/**
	 * Repository--方法命名测试
	 */
	@Test
	public void testFindByNameAndAge() {
		List<Users> list = this.usersRepositoryByName.findByNameAndAge("张三", 23);
		
		for(Users us:list) {
			System.out.println(us.toString());
		}
	}
	
	/**
	 * Repository--方法命名测试
	 */
	@Test
	public void testFindByNameLike() {
		List<Users> list = this.usersRepositoryByName.findByNameLike("%1");
		
		for(Users us:list) {
			System.out.println(us.toString());
		}
	}
	
	/**
	 * Repository--@Query测试
	 */
	@Test
	public void testQueryByNameUseHQL() {
		 List<Users> list = this.usersRepositoryQueryAnnotation.queryByNameUseHQL("张三1");
		 
		 for(Users us:list) { 
			 System.out.println(us.toString()); 
		 }
		 
	}
	
	/**
	 * Repository--@Query测试
	 */
	@Test
	public void queryByNameUseSQL() {
		 List<Users> list = this.usersRepositoryQueryAnnotation.queryByNameUseSQL("张三1");
		 
		 for(Users us:list) { 
			 System.out.println(us.toString()); 
		 }
		 
	}
	
	/**
	 * Repository--@Query测试
	 */
	@Test
	@Transactional
	public void updateUsersNameById() {
		 this.usersRepositoryQueryAnnotation.updateUsersNameById("张三", 1);		 
	}
	
	/**
	 * crudRepository--crud测试
	 */
	@Test
	public void testCrudRepositorySave() {
		Users user = new Users();
		user.setAddress("天津");
		user.setAge(30);
		user.setName("张三丰");
		
		this.usersRepositoryCrudRepository.save(user);
	}
	
	/**
	 * crudRepository--crud测试
	 */
	@Test
	public void testCrudRepositoryupdate() {
		Users user = new Users();
		user.setId(4);
		user.setAddress("东京");
		user.setAge(30);
		user.setName("张三丰");
		
		this.usersRepositoryCrudRepository.save(user);
	}
	
	/**
	 * crudRepository--crud测试
	 */
	@Test
	public void testCrudRepositoryFindone() {
		
		Optional<Users> user = this.usersRepositoryCrudRepository.findById(1);
		
		System.out.println(user);
	}
	/**
	 * crudRepository--crud测试
	 */
	@Test
	public void testCrudRepositoryFindAll() {
		
		List<Users> user = (List<Users>) this.usersRepositoryCrudRepository.findAll();
		for(Users us:user) 
		System.out.println(us.toString());
	}
	/**
	 * crudRepository--crud测试
	 */
	@Test
	public void testCrudRepositoryDeleteById() {
		
		this.usersRepositoryCrudRepository.deleteById(4);
		
		
	}
	
	/**
	 * PagingAndSortingRepository--排序测试
	 */
	@Test
	public void testPagingAndSortingRepositorySort() {
		
		//Order 定义排序规则
		Order order = new Order(Direction.DESC, "id");
		//Sort对象封装了排序规则
		Sort sort = new Sort(order);
		List<Users> user = (List<Users>) this.usersRepositoryPagingAndSorting.findAll(sort);
		for(Users us:user) {
			System.out.println(us.toString());
		}
		
		
	}
	
	/**
	 * PagingAndSortingRepository--分页测试
	 */
	@Test
	public void testPagingAndSortingRepositoryPaging() {
		
		//Pageable:封装了分页的参数，当前页，每页显示的条数。注意：他的当前是从0页开始的。
		//PageRequest(0, 2); page:当前页。size：每页显示的条数
		Pageable pageable = new PageRequest(1, 2);
		Page<Users> page = this.usersRepositoryPagingAndSorting.findAll(pageable);
		System.out.println("总条数："+page.getTotalElements());
		System.out.println("总页数："+page.getTotalPages());
		List<Users> list = page.getContent();
		for(Users user:list) {
			System.out.println(user.toString());
		}
		
		
	}
	
	/**
	 * PagingAndSortingRepository--排序+分页  测试
	 */
	@Test
	public void testPagingAndSortingRepositorySortAndPaging() {
		
		//Order 定义排序规则
		Order order = new Order(Direction.DESC, "age");
		//Sort对象封装了排序规则
		Sort sort = new Sort(order);
		
		//Pageable:封装了分页的参数，当前页，每页显示的条数。注意：他的当前是从0页开始的。
		//PageRequest(0, 2); page:当前页。size：每页显示的条数
		Pageable pageable = new PageRequest(0, 2,sort);
		Page<Users> page = this.usersRepositoryPagingAndSorting.findAll(pageable);
		System.out.println("总条数："+page.getTotalElements());
		System.out.println("总页数："+page.getTotalPages());
		List<Users> list = page.getContent();
		for(Users user:list) {
			System.out.println(user.toString());
		}
		
		
	}
	
	/**
	 *JpaRepository--排序+分页  测试
	 */
	@Test
	public void testJpaRepositorySortAndPaging() {
		
		List<Users> list = this.usersRepository.findAll();
		for(Users user:list) {
			System.out.println(user.toString());
		}
		
		
	}
	
	/**
	 *UsersRepositorySpecification--单条件测试
	 */
	@Test
	public void testJpaSpecificationExecutor1() {
		
		/**
		 * Specification<Users>:用于封装查询条件
		 */
		Specification<Users> spec = new Specification<Users>() {

			
			//Predicate：封装了单个的查询条件
			/**
			 * Root<Users> root：查询对象的属性的封装
			 * CriteriaQuery<?> query：封装了我们要执行的查询总的各个部分的信息
			 * CriteriaBuilder criteriaBuilder：查询条件的构造器。定义不同的查询条件
			 */
			@Override
			public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				
				/**
				 * 参数一：查询的条件属性
				 * 参数二：条件的值
				 */
				Predicate pre = criteriaBuilder.equal(root.get("name"), "张三");
				
				return pre;
			}
		};
		
		List<Users> list = this.usersRepositorySpecification.findAll(spec);
		for(Users user:list) {
			System.out.println(user.toString());
		}
		
	}
	
	/**
	 *UsersRepositorySpecification--多条件测试
	 */
	@Test
	public void testJpaSpecificationExecutor2() {
		
		/**
		 * Specification<Users>:用于封装查询条件
		 */
		Specification<Users> spec = new Specification<Users>() {

			
			//Predicate：封装了单个的查询条件
			/**
			 * Root<Users> root：查询对象的属性的封装
			 * CriteriaQuery<?> query：封装了我们要执行的查询总的各个部分的信息
			 * CriteriaBuilder criteriaBuilder：查询条件的构造器。定义不同的查询条件
			 */
			@Override
			public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				
				List<Predicate> list = new ArrayList<Predicate>();
				list.add(criteriaBuilder.equal(root.get("name"), "张三"));
				list.add(criteriaBuilder.equal(root.get("age"), 23));
				Predicate[] arr = new Predicate[list.size()];
				return criteriaBuilder.and(list.toArray(arr));
			}
		};
		
		List<Users> list = this.usersRepositorySpecification.findAll(spec);
		for(Users user:list) {
			System.out.println(user.toString());
		}
		
	}
	
	/**
	 *UsersRepositorySpecification--多条件测试第二种写法
	 */
	@Test
	public void testJpaSpecificationExecutor3() {
		
		/**
		 * Specification<Users>:用于封装查询条件
		 */
		Specification<Users> spec = new Specification<Users>() {

			
			//Predicate：封装了单个的查询条件
			/**
			 * Root<Users> root：查询对象的属性的封装
			 * CriteriaQuery<?> query：封装了我们要执行的查询总的各个部分的信息
			 * CriteriaBuilder criteriaBuilder：查询条件的构造器。定义不同的查询条件
			 */
			@Override
			public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				
				return criteriaBuilder.or(criteriaBuilder.or(criteriaBuilder.equal(root.get("name"), "张三"),criteriaBuilder.equal(root.get("age"), 22)));
			}
		};
		Sort sort = new Sort(new Order(Direction.DESC,"id"));
		List<Users> list = this.usersRepositorySpecification.findAll(spec,sort);
		for(Users user:list) {
			System.out.println(user.toString());
		}
		
	}
}
