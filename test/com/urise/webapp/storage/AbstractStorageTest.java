package com.urise.webapp.storage;

import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AbstractStorageTest {
    protected Storage storage;
    protected static final String UUID_1 = "uuid1";
    protected static final String UUID_2 = "uuid2";
    protected static final String UUID_3 = "uuid3";
    protected static final String UUID_4 = "uuid4";
    protected static final String NAME_1 = "Alex";
    protected static final String NAME_2 = "Bob";
    protected static final String NAME_3 = "Joe";
    protected static final String NAME_4 = "Sam";

    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @BeforeEach
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1, NAME_1));
        storage.save(new Resume(UUID_2, NAME_2));
        storage.save(new Resume(UUID_3, NAME_3));
    }

    @Test
    void save() {
        Resume resume = new Resume(UUID_4, NAME_4);
        storage.save(resume);
        assertEquals(resume, storage.get(UUID_4));
        assertEquals(4, storage.size());
    }

    @Test
    void update() {
        Resume resume = new Resume(UUID_3, NAME_3);
        storage.update(resume);
        assertEquals(resume, storage.get(UUID_3));
    }

    @Test
    void delete() {
        storage.delete(UUID_3);
        assertEquals(2, storage.size());
        assertThrows(NotExistStorageException.class, () -> storage.get(UUID_3));
    }

    @Test
    void size() {
        assertEquals(3, storage.size());
    }

    @Test
    void getAll() {
        List<Resume> actualResumes = storage.getAllSorted();
        List<Resume> expectedResumes = new ArrayList<>();
        expectedResumes.add(new Resume(UUID_1, NAME_1));
        expectedResumes.add(new Resume(UUID_2, NAME_2));
        expectedResumes.add(new Resume(UUID_3, NAME_3));
        assertIterableEquals(expectedResumes, actualResumes);
    }

    @Test
    void clear() {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    void get() {
        assertEquals(new Resume(UUID_2, NAME_2), storage.get(UUID_2));
    }

    @Test
    void getNotExist() {
        assertThrows(NotExistStorageException.class, () -> storage.get("dummy"));
    }
}
