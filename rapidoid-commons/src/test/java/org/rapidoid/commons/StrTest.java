package org.rapidoid.commons;

/*
 * #%L
 * rapidoid-commons
 * %%
 * Copyright (C) 2014 - 2016 Nikolche Mihajlovski and contributors
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import org.junit.Test;
import org.rapidoid.annotation.Authors;
import org.rapidoid.annotation.Since;
import org.rapidoid.test.AbstractCommonsTest;

@Authors("Nikolche Mihajlovski")
@Since("5.1.0")
public class StrTest extends AbstractCommonsTest {

	@Test
	public void testTriml() {
		eq(Str.triml("/abc/", "/"), "abc/");
		eq(Str.triml("/abc/", "/a"), "bc/");
		eq(Str.triml("/abc/", "/abc/"), "");
		eq(Str.triml(".abc.", '.'), "abc.");
		eq(Str.triml("/abc/", '.'), "/abc/");
	}

	@Test
	public void testTrimr() {
		eq(Str.trimr("/abc/", "/"), "/abc");
		eq(Str.trimr("/abc/", "c/"), "/ab");
		eq(Str.trimr("/abc/", "/abc/"), "");
		eq(Str.trimr(".abc.", '.'), ".abc");
		eq(Str.trimr("/abc/", '.'), "/abc/");
	}

	@Test
	public void testInsert() {
		eq(Str.insert("", 0, "ab"), "ab");
		eq(Str.insert("a", 0, "b"), "ba");
		eq(Str.insert("a", 1, "b"), "ab");
		eq(Str.insert("abc", 2, "123"), "ab123c");
	}

	@Test
	public void testCut() throws Exception {
		eq(Str.cutToFirst("a.b.c", "."), "a");
		eq(Str.cutToFirst("a.b.c", "-"), null);

		eq(Str.cutToLast("a.b.c", "."), "a.b");
		eq(Str.cutToLast("a.b.c", "-"), null);

		eq(Str.cutFromFirst("a.b.c", "."), "b.c");
		eq(Str.cutFromFirst("a.b.c", "-"), null);

		eq(Str.cutFromLast("a.b.c", "."), "c");
		eq(Str.cutFromLast("a.b.c", "-"), null);
	}

	@Test
	public void testCamelSplit() {
		eq(Str.camelSplit("bookTitle"), new String[]{"book", "Title"});
		eq(Str.camelSplit("BookTitle"), new String[]{"Book", "Title"});
		eq(Str.camelSplit("MyFoo"), new String[]{"My", "Foo"});
		eq(Str.camelSplit("Foo"), new String[]{"Foo"});
		eq(Str.camelSplit("bar"), new String[]{"bar"});
		eq(Str.camelSplit("ABC"), new String[]{"ABC"});
		eq(Str.camelSplit("myID"), new String[]{"my", "ID"});
		eq(Str.camelSplit("xID2"), new String[]{"x", "ID", "2"});
		eq(Str.camelSplit("date1"), new String[]{"date", "1"});
		eq(Str.camelSplit("myDate2"), new String[]{"my", "Date", "2"});
	}

	@Test
	public void testCamelToSnake() {
		eq(Str.camelToSnake("bookTitle"), "book_title");
		eq(Str.camelToSnake("BookTitle"), "book_title");
		eq(Str.camelToSnake("Foo"), "foo");
		eq(Str.camelToSnake("bar"), "bar");
		eq(Str.camelToSnake("ABC"), "abc");
		eq(Str.camelToSnake("myID"), "my_id");
		eq(Str.camelToSnake("xID2"), "x_id_2");
		eq(Str.camelToSnake("date1"), "date_1");
		eq(Str.camelToSnake("myDate2"), "my_date_2");
	}

}
