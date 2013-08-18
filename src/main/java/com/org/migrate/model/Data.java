package com.org.migrate.model;

/**
 * Model object
 * @author ambika_b
 *
 */
public class Data {

	Long id;
	String contents;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String singer) {
		this.contents = singer;
	}

	@Override
	public String toString() {
		return "Data [id=" + id + ", contents=" + contents + "]";
	}

}