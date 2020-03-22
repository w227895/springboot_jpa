package com.kebo.springboot_jpa;

import com.kebo.springboot_jpa.dao.UserDao;
import com.kebo.springboot_jpa.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@SpringBootTest
class SpringbootJpaApplicationTests {
	@Autowired
	private UserDao userDao;

	@Test
	void contextLoads() {
		List<User> userList=userDao.findAll();
		for (User u:userList) {
			System.out.println(u);
		}

	}

	@Test
	void testSave() {
		User u=new User("kebo",12,"55317332@qq.com",new Date(),new Date(),2);
		userDao.save(u);
	}

	@Test
	void testQuery(){
		List<User> userList=userDao.queryUserByNameSQL("Helen");
		for (User u:userList) {
			System.out.println(u);
		}
	}

	@Test
	void testUpdate(){
		User u=new User("kebo1",12,"55317332@qq.com",new Date(),new Date(),2);
		u.setId(1208728913748967428l);
		userDao.save(u);
	}

	@Test
	void testSpecification(){
		Specification<User> spec = new Specification<User>() {

			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<>();
				list.add(cb.equal(root.get("name"),"kebo"));
				list.add(cb.equal(root.get("age"),12));
				//此时条件之间是没有任何关系的。
				Predicate[] arr = new Predicate[list.size()];
				return cb.and(list.toArray(arr));
			}

		};
		List<User> list = this.userDao.findAll(spec);
		for (User user : list) {
			System.out.println(user);
		}
	}

	@Test
	void testPage(){
		Specification<User> spec = new Specification<User>() {

			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<>();
				list.add(cb.equal(root.get("name"),"kebo"));
				//此时条件之间是没有任何关系的。
				Predicate[] arr = new Predicate[list.size()];
				return cb.and(list.toArray(arr));
			}

		};
		//Sort sort = new Sort(Sort.Direction.DESC,"userid");
		PageRequest pageRequest = PageRequest.of(0, 2);
		Page<User> page = this.userDao.findAll(spec, pageRequest);
		System.out.println(page.getContent());
	}


}
