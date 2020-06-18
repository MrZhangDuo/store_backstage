package com.hy.store_backstage.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CountList
 * @Description TODO
 * @Author zhangduo
 * @Date 2020/6/14 14:41
 * @Version 1.0
 */
public class CountList {
    public static List<Integer> countList(Count count){
        List<Integer> integerList = new ArrayList<>();
        integerList.add(count.getMonday());
        integerList.add(count.getTuesday());
        integerList.add(count.getWednesday());
        integerList.add(count.getThursday());
        integerList.add(count.getFriday());
        integerList.add(count.getSaturday());
        integerList.add(count.getSunday());
        return integerList;
    }

    public static List<Double> countMoneyList(CountMoney countMoney){
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(countMoney.getMonday());
        doubleList.add(countMoney.getTuesday());
        doubleList.add(countMoney.getWednesday());
        doubleList.add(countMoney.getThursday());
        doubleList.add(countMoney.getFriday());
        doubleList.add(countMoney.getSaturday());
        doubleList.add(countMoney.getSunday());
        return doubleList;
    }
}
