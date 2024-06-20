package com.example.demo.services;

import org.springframework.stereotype.Service;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

@Service
public class HistoryServices {
    Dictionary<String, Integer> history = new Hashtable<>();

    private boolean isHas(Enumeration<String> keys, String ip) {
        while (keys.hasMoreElements()) {
            var key = keys.nextElement();
            if(key.equals(ip)) {
                return true;
            }
        }
        return false;
    }

    public void addIp(String ip) {
//        List<String> ips = (List<String>) history.keys();
//        var key = ips.stream().filter(i->i.equals(ip)).findFirst().orElse(null);
        Enumeration<String> ips = history.keys();

        boolean isHas = isHas(ips, ip);

        if (isHas) {
            int count = history.get(ip);
            count++;
            history.put(ip, count);
        } else {
            history.put(ip, 1);
        }
    }

    public Dictionary<String, Integer> getInfo() {
        return history;
    }

}
