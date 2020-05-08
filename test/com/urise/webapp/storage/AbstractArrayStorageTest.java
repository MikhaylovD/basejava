package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract class AbstractArrayStorageTest extends AbstractStorageTest {
    public AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test
    void getOverflowException() {
        try {
            for (int i = 4; i < 1001; i++) {
                storage.save(new Resume(""));
            }
        } catch (StorageException e) {
            fail();
        }
        assertThrows(StorageException.class, () -> storage.save(new Resume("")));
    }
}