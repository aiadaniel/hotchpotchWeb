package com.vigorous.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.platform.bean.BaseBean;

@Entity
@Table(name="tb_category")
public class Category extends BaseBean {
	private String name;

	@OneToMany(mappedBy = "category")
	private List<Board> boards = new ArrayList<Board>();

	public List<Board> getBoards() {
		return boards;
	}

	public void setBoards(List<Board> boards) {
		this.boards = boards;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
