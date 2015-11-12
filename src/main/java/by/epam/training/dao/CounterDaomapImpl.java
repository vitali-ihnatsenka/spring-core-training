package by.epam.training.dao;

import java.util.HashMap;
import java.util.Map;

/**
 */
public class CounterDaomapImpl implements CounterDao {
    private Map<String, Integer> counterMap = new HashMap<String, Integer>();

    @Override
    public void incrementCounter(String name) {
        if(!counterMap.containsKey(name)){
            counterMap.put(name, 0);
        }
        counterMap.put(name, counterMap.get(name) + 1);
    }

    @Override
    public int getCounter(String name) {
        if(counterMap.containsKey(name)){
            return counterMap.get(name);
        }
        return 0;
    }
}
