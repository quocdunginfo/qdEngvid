package com.android.qdengvid.entities;

import com.android.qdengvid.daos.MyLesson_MyLevelDAO;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "MyLesson_MyLevels")
public class MyLesson_MyLevel extends
		_MyEntityAbstract<MyLesson_MyLevelDAO, MyLesson_MyLevel> {

	public static final String level_ID = "level_id";
	public static final String lesson_ID = "lesson_id";
	@DatabaseField(foreign = true, canBeNull = false)
	private MyLevel level = null;
	@DatabaseField(foreign = true, canBeNull = false)
	private MyLesson lesson = null;

	public MyLesson_MyLevel() {

	}

	@Override
	public void reset() {
		super.reset();
		lesson = null;
		level = null;
	}

	@Override
	public Integer insert() {
		// very importance
		// since MyBitrate may be loaded when fetching MyLesson
		// if not force to set loaded=true then
		// new load script will be acted and reset will be called
		// then all data pre-loaded will swiped out
		setLoaded(true);
		return super.insert();
	}

	public MyLesson getLesson() {
		// TODO Auto-generated method stub
		return lesson;
	}

	public MyLevel getLevel() {
		return level;
	}

	public void setLevel(MyLevel Level) {
		this.level = Level;
	}

	public void setLesson(MyLesson Lesson) {
		this.lesson = Lesson;
	}

}
