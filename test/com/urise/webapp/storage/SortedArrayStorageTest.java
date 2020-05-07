package com.urise.webapp.storage;

import org.junit.jupiter.api.extension.Extension;

public class SortedArrayStorageTest extends AbstractArrayStorageTest implements Extension {

    public SortedArrayStorageTest() {
        super(new SortedArrayStorage());
    }


}