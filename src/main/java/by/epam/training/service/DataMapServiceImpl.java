package by.epam.training.service;

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

    public void setMaxId(int maxId) {
        this.maxId = maxId;
    }
}
