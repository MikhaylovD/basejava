package com.urise.webapp.storage;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({
        ListStorageTest.class,
        MapStorageTest.class,
        ArrayStorageTest.class,
        SortedArrayStorageTest.class,
})
public class AllStorageTest {
}
