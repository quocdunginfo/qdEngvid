package com.android.qdengvid.daos;

import android.content.Context;

/**
 * My Custom Global DAO for cross access and use Cached supported
 * 
 * @author quocdunginfo
 * 
 */
public class GlobalDAO {
	private Context _ctx = null;
	private MyTopicDAO _myTopicDAO = null;
	
	private MyTeacherDAO _myTeacherDAO = null;
	private MyLessonDAO _myLessonDAO = null;
	private MyLevelDAO _myLevelDAO = null;
	private MyLesson_MyLevelDAO _myLesson_MyLevelDAO = null;
	
	private Integer source = 0;

	public GlobalDAO(Context ctx) {
		_ctx = ctx;
	}

	public Context getContext() {
		return _ctx;
	}

	public MyTopicDAO getMyTopicDAO() {
		// require
		if (getContext() == null) {
			return null;
		}
		// lazy
		if (_myTopicDAO != null) {
			return _myTopicDAO;
		}
		// init new one
		_myTopicDAO = new MyTopicDAO(getContext(), this);
		return _myTopicDAO;
	}

	

	

	public MyTeacherDAO getMyFormatDAO() {
		// require
		if (getContext() == null) {
			return null;
		}
		// lazy
		if (_myTeacherDAO != null) {
			return _myTeacherDAO;
		}
		// init new one
		_myTeacherDAO = new MyTeacherDAO(getContext(), this);
		return _myTeacherDAO;
	}

	public MyLessonDAO getMyLessonDAO() {
		// require
		if (getContext() == null) {
			return null;
		}
		// lazy
		if (_myLessonDAO != null) {
			return _myLessonDAO;
		}
		// init new one
		_myLessonDAO = new MyLessonDAO(getContext(), this);
		return _myLessonDAO;
	}

	public MyLevelDAO getMyLevelDAO() {
		// require
		if (getContext() == null) {
			return null;
		}
		// lazy
		if (_myLevelDAO != null) {
			return _myLevelDAO;
		}
		// init new one
		_myLevelDAO = new MyLevelDAO(getContext(), this);
		return _myLevelDAO;
	}
	
	public MyLesson_MyLevelDAO getMyLesson_MyLevelDAO() {
		// require
		if (getContext() == null) {
			return null;
		}
		// lazy
		if (_myLesson_MyLevelDAO != null) {
			return _myLesson_MyLevelDAO;
		}
		// init new one
		_myLesson_MyLevelDAO = new MyLesson_MyLevelDAO(getContext(), this);
		return _myLesson_MyLevelDAO;
	}

	public void release() {
		if (_myTopicDAO != null) {
			_myTopicDAO.release();
		}
		
		if (_myTeacherDAO != null) {
			_myTeacherDAO.release();
		}
		if (_myLessonDAO != null) {
			_myLessonDAO.release();
		}
		if (_myLevelDAO != null) {
			_myLevelDAO.release();
		}
		if (_myLesson_MyLevelDAO != null) {
			_myLesson_MyLevelDAO.release();
		}
		
		
	}
}
