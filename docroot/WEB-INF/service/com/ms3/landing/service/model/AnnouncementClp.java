/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.ms3.landing.service.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.ms3.landing.service.service.AnnouncementLocalServiceUtil;
import com.ms3.landing.service.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author John
 */
public class AnnouncementClp extends BaseModelImpl<Announcement>
	implements Announcement {
	public AnnouncementClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Announcement.class;
	}

	@Override
	public String getModelClassName() {
		return Announcement.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _ID;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setID(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ID;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID", getID());
		attributes.put("Title", getTitle());
		attributes.put("Content", getContent());
		attributes.put("SetDate", getSetDate());
		attributes.put("Author", getAuthor());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ID = (Long)attributes.get("ID");

		if (ID != null) {
			setID(ID);
		}

		String Title = (String)attributes.get("Title");

		if (Title != null) {
			setTitle(Title);
		}

		String Content = (String)attributes.get("Content");

		if (Content != null) {
			setContent(Content);
		}

		Date SetDate = (Date)attributes.get("SetDate");

		if (SetDate != null) {
			setSetDate(SetDate);
		}

		String Author = (String)attributes.get("Author");

		if (Author != null) {
			setAuthor(Author);
		}
	}

	@Override
	public long getID() {
		return _ID;
	}

	@Override
	public void setID(long ID) {
		_ID = ID;

		if (_announcementRemoteModel != null) {
			try {
				Class<?> clazz = _announcementRemoteModel.getClass();

				Method method = clazz.getMethod("setID", long.class);

				method.invoke(_announcementRemoteModel, ID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _Title;
	}

	@Override
	public void setTitle(String Title) {
		_Title = Title;

		if (_announcementRemoteModel != null) {
			try {
				Class<?> clazz = _announcementRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_announcementRemoteModel, Title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContent() {
		return _Content;
	}

	@Override
	public void setContent(String Content) {
		_Content = Content;

		if (_announcementRemoteModel != null) {
			try {
				Class<?> clazz = _announcementRemoteModel.getClass();

				Method method = clazz.getMethod("setContent", String.class);

				method.invoke(_announcementRemoteModel, Content);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getSetDate() {
		return _SetDate;
	}

	@Override
	public void setSetDate(Date SetDate) {
		_SetDate = SetDate;

		if (_announcementRemoteModel != null) {
			try {
				Class<?> clazz = _announcementRemoteModel.getClass();

				Method method = clazz.getMethod("setSetDate", Date.class);

				method.invoke(_announcementRemoteModel, SetDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAuthor() {
		return _Author;
	}

	@Override
	public void setAuthor(String Author) {
		_Author = Author;

		if (_announcementRemoteModel != null) {
			try {
				Class<?> clazz = _announcementRemoteModel.getClass();

				Method method = clazz.getMethod("setAuthor", String.class);

				method.invoke(_announcementRemoteModel, Author);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAnnouncementRemoteModel() {
		return _announcementRemoteModel;
	}

	public void setAnnouncementRemoteModel(BaseModel<?> announcementRemoteModel) {
		_announcementRemoteModel = announcementRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _announcementRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_announcementRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AnnouncementLocalServiceUtil.addAnnouncement(this);
		}
		else {
			AnnouncementLocalServiceUtil.updateAnnouncement(this);
		}
	}

	@Override
	public Announcement toEscapedModel() {
		return (Announcement)ProxyUtil.newProxyInstance(Announcement.class.getClassLoader(),
			new Class[] { Announcement.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AnnouncementClp clone = new AnnouncementClp();

		clone.setID(getID());
		clone.setTitle(getTitle());
		clone.setContent(getContent());
		clone.setSetDate(getSetDate());
		clone.setAuthor(getAuthor());

		return clone;
	}

	@Override
	public int compareTo(Announcement announcement) {
		int value = 0;

		value = DateUtil.compareTo(getSetDate(), announcement.getSetDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AnnouncementClp)) {
			return false;
		}

		AnnouncementClp announcement = (AnnouncementClp)obj;

		long primaryKey = announcement.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{ID=");
		sb.append(getID());
		sb.append(", Title=");
		sb.append(getTitle());
		sb.append(", Content=");
		sb.append(getContent());
		sb.append(", SetDate=");
		sb.append(getSetDate());
		sb.append(", Author=");
		sb.append(getAuthor());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.ms3.landing.service.model.Announcement");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ID</column-name><column-value><![CDATA[");
		sb.append(getID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>SetDate</column-name><column-value><![CDATA[");
		sb.append(getSetDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Author</column-name><column-value><![CDATA[");
		sb.append(getAuthor());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _ID;
	private String _Title;
	private String _Content;
	private Date _SetDate;
	private String _Author;
	private BaseModel<?> _announcementRemoteModel;
}