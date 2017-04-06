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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ms3.landing.service.service.http.AnnouncementServiceSoap}.
 *
 * @author John
 * @see com.ms3.landing.service.service.http.AnnouncementServiceSoap
 * @generated
 */
public class AnnouncementSoap implements Serializable {
	public static AnnouncementSoap toSoapModel(Announcement model) {
		AnnouncementSoap soapModel = new AnnouncementSoap();

		soapModel.setID(model.getID());
		soapModel.setTitle(model.getTitle());
		soapModel.setContent(model.getContent());
		soapModel.setSetDate(model.getSetDate());
		soapModel.setAuthor(model.getAuthor());

		return soapModel;
	}

	public static AnnouncementSoap[] toSoapModels(Announcement[] models) {
		AnnouncementSoap[] soapModels = new AnnouncementSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AnnouncementSoap[][] toSoapModels(Announcement[][] models) {
		AnnouncementSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AnnouncementSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AnnouncementSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AnnouncementSoap[] toSoapModels(List<Announcement> models) {
		List<AnnouncementSoap> soapModels = new ArrayList<AnnouncementSoap>(models.size());

		for (Announcement model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AnnouncementSoap[soapModels.size()]);
	}

	public AnnouncementSoap() {
	}

	public long getPrimaryKey() {
		return _ID;
	}

	public void setPrimaryKey(long pk) {
		setID(pk);
	}

	public long getID() {
		return _ID;
	}

	public void setID(long ID) {
		_ID = ID;
	}

	public String getTitle() {
		return _Title;
	}

	public void setTitle(String Title) {
		_Title = Title;
	}

	public String getContent() {
		return _Content;
	}

	public void setContent(String Content) {
		_Content = Content;
	}

	public Date getSetDate() {
		return _SetDate;
	}

	public void setSetDate(Date SetDate) {
		_SetDate = SetDate;
	}

	public String getAuthor() {
		return _Author;
	}

	public void setAuthor(String Author) {
		_Author = Author;
	}

	private long _ID;
	private String _Title;
	private String _Content;
	private Date _SetDate;
	private String _Author;
}