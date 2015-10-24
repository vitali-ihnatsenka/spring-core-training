package by.epam.training.service;

import java.util.Map;
import java.util.Set;

/**
 * Created by Vitali on 23.10.2015.
 */
public interface DataMapService {
    Integer getUniqueRandomId(Set<Integer> idSet);
    <T> int getObjectId(Map<Integer, T> map, T object);
    <T> void register(Map<Integer, T> map, T object);
}
