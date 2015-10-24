package by.epam.training.service;

import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Created by Vitali on 23.10.2015.
 */
public class DataMapServiceImpl implements DataMapService {
    private int maxId;

    @Override
    public Integer getUniqueRandomId(Set<Integer> idSet) {
        int id = new Random().nextInt(maxId) + 1;
        if(idSet.contains(id)){
            return  getUniqueRandomId(idSet);
        }
        return id;
    }

    @Override
    public <T> int getObjectId(Map<Integer, T> map, T object) {
        for(Map.Entry<Integer, T> entry: map.entrySet()){
            if(entry.getValue().equals(object)){
                return entry.getKey();
            }
        }
        return -1;
    }

    @Override
    public <T> void register(Map<Integer, T> map, T object) {
        map.put(getUniqueRandomId(map.keySet()), object);
    }

    public void setMaxId(int maxId) {
        this.maxId = maxId;
    }
}
