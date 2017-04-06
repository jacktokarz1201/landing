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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Announcement}.
 * </p>
 *
 * @author John
 * @see Announcement
 * @generated
 */
public class AnnouncementWrapper implements Announcement,
	ModelWrapper<Announcement> {
	public AnnouncementWrapper(Announcement announcement) {
		_announcement = announcement;
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

	/**
	* Returns the primary key of this announcement.
	*
	* @return the primary key of this announcement
	*/
	@Override
	public long getPrimaryKey() {
		return _announcement.getPrimaryKey();
	}

	/**
	* Sets the primary key of this announcement.
	*
	* @param primaryKey the primary key of this announcement
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_announcement.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the i d of this announcement.
	*
	* @return the i d of this announcement
	*/
	@Override
	public long getID() {
		return _announcement.getID();
	}

	/**
	* Sets the i d of this announcement.
	*
	* @param ID the i d of this announcement
	*/
	@Override
	public void setID(long ID) {
		_announcement.setID(ID);
	}

	/**
	* Returns the title of this announcement.
	*
	* @return the title of this announcement
	*/
	@Override
	public java.lang.String getTitle() {
		return _announcement.getTitle();
	}

	/**
	* Sets the title of this announcement.
	*
	* @param Title the title of this announcement
	*/
	@Override
	public void setTitle(java.lang.String Title) {
		_announcement.setTitle(Title);
	}

	/**
	* Returns the content of this announcement.
	*
	* @return the content of this announcement
	*/
	@Override
	public java.lang.String getContent() {
		return _announcement.getContent();
	}

	/**
	* Sets the content of this announcement.
	*
	* @param Content the content of this announcement
	*/
	@Override
	public void setContent(java.lang.String Content) {
		_announcement.setContent(Content);
	}

	/**
	* Returns the set date of this announcement.
	*
	* @return the set date of this announcement
	*/
	@Override
	public java.util.Date getSetDate() {
		return _announcement.getSetDate();
	}

	/**
	* Sets the set date of this announcement.
	*
	* @param SetDate the set date of this announcement
	*/
	@Override
	public void setSetDate(java.util.Date SetDate) {
		_announcement.setSetDate(SetDate);
	}

	/**
	* Returns the author of this announcement.
	*
	* @return the author of this announcement
	*/
	@Override
	public java.lang.String getAuthor() {
		return _announcement.getAuthor();
	}

	/**
	* Sets the author of this announcement.
	*
	* @param Author the author of this announcement
	*/
	@Override
	public void setAuthor(java.lang.String Author) {
		_announcement.setAuthor(Author);
	}

	@Override
	public boolean isNew() {
		return _announcement.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_announcement.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _announcement.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_announcement.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _announcement.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _announcement.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_announcement.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _announcement.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_announcement.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_announcement.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_announcement.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AnnouncementWrapper((Announcement)_announcement.clone());
	}

	@Override
	public int compareTo(
		com.ms3.landing.service.model.Announcement announcement) {
		return _announcement.compareTo(announcement);
	}

	@Override
	public int hashCode() {
		return _announcement.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ms3.landing.service.model.Announcement> toCacheModel() {
		return _announcement.toCacheModel();
	}

	@Override
	public com.ms3.landing.service.model.Announcement toEscapedModel() {
		return new AnnouncementWrapper(_announcement.toEscapedModel());
	}

	@Override
	public com.ms3.landing.service.model.Announcement toUnescapedModel() {
		return new AnnouncementWrapper(_announcement.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _announcement.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _announcement.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_announcement.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AnnouncementWrapper)) {
			return false;
		}

		AnnouncementWrapper announcementWrapper = (AnnouncementWrapper)obj;

		if (Validator.equals(_announcement, announcementWrapper._announcement)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Announcement getWrappedAnnouncement() {
		return _announcement;
	}

	@Override
	public Announcement getWrappedModel() {
		return _announcement;
	}

	@Override
	public void resetOriginalValues() {
		_announcement.resetOriginalValues();
	}

	private Announcement _announcement;
}