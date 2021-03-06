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
package net.jforum.bbcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Rafael Steil
 */
public class U_TestCase extends TagBaseTest {
	@Test
	public void singleLine() {
		formatter.addBb(bbCodes.get("u"));
		Assert.assertEquals("some <u>underline</u> text", formatter.format("some [u]underline[/u] text", defaultOptions()));
	}

	@Test
	public void incompleteTagShouldDoNothing() {
		formatter.addBb(bbCodes.get("u"));
		Assert.assertEquals("some [u]underline text", formatter.format("some [u]underline text", defaultOptions()));
	}

	@Test
	public void twoOpenZeroClosedShouldDoNothing() {
		formatter.addBb(bbCodes.get("u"));
		Assert.assertEquals("some [u]underline[u] text", formatter.format("some [u]underline[u] text", defaultOptions()));
	}

	@Test
	public void twoOpenOneClosedExpectOneFormatted() {
		formatter.addBb(bbCodes.get("u"));
		Assert.assertEquals("some <u>underline[u] text</u>", formatter.format("some [u]underline[u] text[/u]", defaultOptions()));
	}

	@Test
	public void multipleLines() {
		formatter.addBb(bbCodes.get("u"));
		Assert.assertEquals("some <u>\nunderline\n\n</u>\n text", formatter.format("some [u]\nunderline\n\n[/u]\n text", defaultOptions()));
	}

	@Test
	public void mixedCase() {
		formatter.addBb(bbCodes.get("u"));
		Assert.assertEquals("some <u>underline</u> text", formatter.format("some [U]underline[/u] text", defaultOptions()));
	}
}
