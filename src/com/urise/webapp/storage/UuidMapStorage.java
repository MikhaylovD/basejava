package com.urise.webapp.storage;

public class UuidMapStorage extends AbstractMapStorage{
    @Override
    protected Object getSearchKey(String uuid) {
        if (map.containsKey(uuid)) {
            return uuid;
        }
        return null;
    }

    @Override
    protected String getMapKey(String uuid) {
        return uuid;
    }
}
