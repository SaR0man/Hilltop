package com.example.demo.services;

import org.springframework.stereotype.Service;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

@Service
public class HistoryServices {
    Dictionary<String, Integer> history = new Hashtable<>();

    private boolean isHas(String ip) {
        Enumeration<String> keys = history.keys();
        while (keys.hasMoreElements()) {
            var key = keys.nextElement();
            if(key.equals(ip)) {
                return true;
            }
        }
        return false;
    }

    public boolean addIp(String ip) {
        boolean isHas = isHas(ip);
        if (isHas) {
            int count = history.get(ip);
            count++;
            history.put(ip, count);

            if (count>5) {
                return false;
            }
        } else {
            history.put(ip, 1);
        }
        return true;
    }

    public Dictionary<String, Integer> getInfo() {
        return history;
    }
}
