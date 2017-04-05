package com.vigorous.dbtest;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.Rollback;

import com.platform.utils.SSHUtils;
import com.vigorous.bean.Category;
import com.vigorous.service.impl.CategoryService;

public class CategoryServiceTest {
	
	private static CategoryService<Category> categoryService;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		ApplicationContext context = SSHUtils.getAppContext();
		categoryService = (CategoryService<Category>) context.getBean("categoryService");
	}

	@Test
	//@Rollback(true)
	public void test() {
		for (int i = 0; i < 1000; i++) {
			Category category = new Category();
			category.setName("category" + i);
			Integer id = categoryService.create(category);
			assertTrue(id != null);
		}
	}

}
