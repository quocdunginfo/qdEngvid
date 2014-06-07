package com.android.qdengvid.entities;

import com.android.qdengvid.daos.MyLevelDAO;
import com.android.qdengvid.libraries.MyStringHelper;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "MyLevels")
public class MyLevel extends _MyEntityAbstract<MyLevelDAO, MyLevel> {
	
	@DatabaseField(unique = true, canBeNull = false)
	private String name = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MyLevel() {
		
	}

	public MyLevel(String name) {
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
