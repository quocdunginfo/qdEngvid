package com.android.qdengvid.entities;

import java.util.ArrayList;

import com.android.qdengvid.daos.MyLessonDAO;
import com.android.qdengvid.libraries.MyStringHelper;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "MyLessons")
public class MyLesson extends _MyEntityAbstract<MyLessonDAO, MyLesson> {
	
	@DatabaseField(unique = true, canBeNull = false)
	private String title = null;
	@DatabaseField(unique = true, canBeNull = true)
	private String link = null;
	//FK
	@DatabaseField(canBeNull = true, foreign = true)
	private MyTeacher teacher = null;
	//Level
	@DatabaseField(canBeNull = true, foreign = true)
	private ArrayList<MyLevel> levels = null;
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public MyTeacher getTeacher() {
		return teacher;
	}

	public void setTeacher(MyTeacher teacher) {
		this.teacher = teacher;
	}

	public ArrayList<MyLevel> getLevels() {
		return levels;
	}

	public void setLevels(ArrayList<MyLevel> levels) {
		this.levels = levels;
	}

	public ArrayList<MyTopic> getTopics() {
		return topics;
	}

	public void setTopics(ArrayList<MyTopic> topics) {
		this.topics = topics;
	}

	//Toppic
	@DatabaseField(canBeNull = true, foreign = true)
	private ArrayList<MyTopic> topics = null;

	public String getName() {
		return title;
	}

	public void setName(String name) {
		this.title = name;
	}

	public MyLesson() {
		
	}

	public MyLesson(String name) {
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
