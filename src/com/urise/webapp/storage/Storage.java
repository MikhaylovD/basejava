package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public interface Storage {

    void save(Resume r);

    void update(Resume r);

    Resume get(String uuid);

    void delete(String uuid);

    void clear();

    Resume[] getAll();

    int size();
}
