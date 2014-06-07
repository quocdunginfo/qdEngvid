package com.android.qdengvid.daos;

import java.util.ArrayList;

import android.content.Context;

import com.android.qdengvid.entities.MyTopic;
import com.j256.ormlite.dao.RuntimeExceptionDao;

public class MyTopicDAO extends _MyDAOAbstract<MyTopicDAO, MyTopic>
		implements _MyDAOInterface<MyTopicDAO, MyTopic> {

	public MyTopicDAO(Context ctx, GlobalDAO g) {
		super(ctx, g);
	}

	@Override
	public RuntimeExceptionDao<MyTopic, Integer> getDao() {
		if (getManager() != null && getHelper() != null) {
			return getHelper().getMyTopicDAO();
		}
		return null;
	}

	@Override
	public ArrayList<MyTopic> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyTopic getById(Integer id) {
		MyTopic obj = getDao().queryForId(id);
		obj.setDao(this);
		obj.setLoaded(true);
		return obj;
	}

	@Override
	public Integer insert(MyTopic obj) {
		return 1;
	}
}
