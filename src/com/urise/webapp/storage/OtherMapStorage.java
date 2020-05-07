package com.urise.webapp.storage;

public class OtherMapStorage extends AbstractMapStorage{
    @Override
    protected Object getSearchKey(String uuid) {
        String searchKey = getMapKey(uuid);
//        if (map.containsKey(searchKey)) {
//            return null;
//        }
        return null;
    }

    @Override
    protected String getMapKey(String uuid) {
        //Не понимаю что еще может выступать ключом кроме uuid.
        return null;
    }
}
