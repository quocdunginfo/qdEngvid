package com.android.qdengvid.entities;

import com.android.qdengvid.daos.MyTeacherDAO;
import com.android.qdengvid.libraries.MyStringHelper;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "MyTeachers")
public class MyTeacher extends _MyEntityAbstract<MyTeacherDAO, MyTeacher> {
	
	@DatabaseField(unique = true, canBeNull = false)
	private String name = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MyTeacher() {
		
	}

	public MyTeacher(String name) {
		setName(name);
	}

	@Override
	public void reset() {
		super.reset();
	}

	@Override
	public Integer insert() {
		// very importance
		// since MyBitrate may be loaded when fetching MySong
		// if not force to set loaded=true then
		// new load script will be acted and reset will be called
		// then all data pre-loaded will swiped out
		setLoaded(true);
		return super.insert();
	}
}
