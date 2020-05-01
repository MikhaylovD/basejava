package com.urise.webapp.storage;

import com.urise.webapp.exception.NonExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class AbstractArrayStorageTest {

    private Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @BeforeEach
    public void setUp() throws Exception{
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    void save() {
        Resume resume = new Resume(UUID_4);
        storage.save(resume);
        assertEquals(resume, storage.get(UUID_4));
        assertEquals(4, storage.size());
    }

    @Test
    void update() {
        Resume resume = new Resume(UUID_3);
        storage.update(resume);
        assertEquals(resume, storage.get(UUID_3));
    }

    @Test
    void delete() {
        storage.delete(UUID_3);
        assertEquals(2, storage.size());
        assertThrows(NonExistStorageException.class, ()->{storage.get(UUID_3);} );
    }

    @Test
    void size() {
        assertEquals(3, storage.size());
    }

    @Test
    void getAll() {
        Resume[] actualResumes = storage.getAll();
        Resume[] expectedResumes = {new Resume(UUID_1), new Resume(UUID_2), new Resume(UUID_4)};
        assertArrayEquals(expectedResumes, actualResumes);
    }

    @Test
    void clear() {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    void get() {
        assertEquals(new Resume(UUID_2), storage.get(UUID_2));
    }

    @Test
    void getNotExist() {
        assertThrows(NonExistStorageException.class, ()->{storage.get("dummy");} );
    }

    @Test
    void getOverflowException() {
        assertThrows(StorageException.class, ()->{for (int i = 0; i < 1001; i++) {
                    storage.save(new Resume());
                }} );
    }
}