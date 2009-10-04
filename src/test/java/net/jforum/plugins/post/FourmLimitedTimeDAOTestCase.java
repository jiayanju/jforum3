/*
 * Copyright (c) JForum Team. All rights reserved.
 *
 * The software in this package is published under the terms of the LGPL
 * license a copy of which has been included with this distribution in the
 * license.txt file.
 *
 * The JForum Project
 * http://www.jforum.net
 */
package net.jforum.plugins.post;

import net.jforum.core.hibernate.AbstractDAOTestCase;
import net.jforum.entities.Forum;
import net.jforum.util.JDBCLoader;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Rafael Steil
 */
public class FourmLimitedTimeDAOTestCase extends AbstractDAOTestCase<ForumLimitedTime> {

	@SuppressWarnings("deprecation")
	@Test
	public void getFourmLimitedTime() {
		new JDBCLoader(sessionFactory.getCurrentSession().connection())
			.run("/posteditlimited/dump.sql");

		ForumLimitedTimeDAO dao = this.newFourmLimitedTimeDAO();
		Forum forum = new Forum();
		forum.setId(2);

		ForumLimitedTime fourmLimitedTime = dao.getForumLimitedTime(forum);

		Assert.assertNotNull(fourmLimitedTime);
		Assert.assertEquals(4, fourmLimitedTime.getId());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void getFourmLimitedTimeReturnNullIfNotFound() {
		new JDBCLoader(sessionFactory.getCurrentSession().connection())
			.run("/posteditlimited/dump.sql");

		ForumLimitedTimeDAO dao = this.newFourmLimitedTimeDAO();
		Forum forum = new Forum();
		forum.setId(5);

		ForumLimitedTime fourmLimitedTime = dao.getForumLimitedTime(forum);

		Assert.assertNull(fourmLimitedTime);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void getLimitedTime() {
		new JDBCLoader(sessionFactory.getCurrentSession().connection())
		.run("/posteditlimited/dump.sql");

		ForumLimitedTimeDAO dao = this.newFourmLimitedTimeDAO();
		Forum forum = new Forum();
		forum.setId(1);

		long limitedTime = dao.getLimitedTime(forum);

		Assert.assertEquals(125, limitedTime);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void getLimitedTimeReturn0IfNotFound() {
		new JDBCLoader(sessionFactory.getCurrentSession().connection())
		.run("/posteditlimited/dump.sql");

		ForumLimitedTimeDAO dao = this.newFourmLimitedTimeDAO();
		Forum forum = new Forum();
		forum.setId(5);

		long limitedTime = dao.getLimitedTime(forum);

		Assert.assertEquals(0, limitedTime);
	}

	private ForumLimitedTimeDAO newFourmLimitedTimeDAO() {
		return new ForumLimitedTimeDAO(sessionFactory);
	}

}