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

package com.ms3.landing.service.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.ms3.landing.service.model.Announcement;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Announcement in entity cache.
 *
 * @author John
 * @see Announcement
 * @generated
 */
public class AnnouncementCacheModel implements CacheModel<Announcement>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{ID=");
		sb.append(ID);
		sb.append(", Title=");
		sb.append(Title);
		sb.append(", Content=");
		sb.append(Content);
		sb.append(", SetDate=");
		sb.append(SetDate);
		sb.append(", Author=");
		sb.append(Author);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Announcement toEntityModel() {
		AnnouncementImpl announcementImpl = new AnnouncementImpl();

		announcementImpl.setID(ID);

		if (Title == null) {
			announcementImpl.setTitle(StringPool.BLANK);
		}
		else {
			announcementImpl.setTitle(Title);
		}

		if (Content == null) {
			announcementImpl.setContent(StringPool.BLANK);
		}
		else {
			announcementImpl.setContent(Content);
		}

		if (SetDate == Long.MIN_VALUE) {
			announcementImpl.setSetDate(null);
		}
		else {
			announcementImpl.setSetDate(new Date(SetDate));
		}

		if (Author == null) {
			announcementImpl.setAuthor(StringPool.BLANK);
		}
		else {
			announcementImpl.setAuthor(Author);
		}

		announcementImpl.resetOriginalValues();

		return announcementImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ID = objectInput.readLong();
		Title = objectInput.readUTF();
		Content = objectInput.readUTF();
		SetDate = objectInput.readLong();
		Author = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(ID);

		if (Title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Title);
		}

		if (Content == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Content);
		}

		objectOutput.writeLong(SetDate);

		if (Author == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Author);
		}
	}

	public long ID;
	public String Title;
	public String Content;
	public long SetDate;
	public String Author;
}