package com.company;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.*;
import java.math.BigDecimal;
import java.text.NumberFormat;

public class Main {
    static class Item {
        String name;
        PairInt pair;

        public Item(String name, PairInt pair) {
            this.name = name;
            this.pair = pair;
        }
    }

    static class PairInt {
        int relevance;
        int price;
        public PairInt(int relevance, int price) {
            this.relevance = relevance;
            this.price = price;
        }
    }


    public static List<String> fetchItemToDisplay(int numOfItem, HashMap<String, PairInt> items,
                                                  int sortParameter, int sortedOrder,
                                                  int itemPerPage, int pageNum) {
        Item[] itemList = new Item[numOfItem];
        int i = 0;
        for (Map.Entry<String, PairInt> e : items.entrySet()) {
            itemList[i++] = new Item(e.getKey(), e.getValue());
        }

        Comparator<Item> itemComparator = new Comparator<Item>() {
            public int compare(Item o1, Item o2) {
                if (sortParameter == 0) {
                    if (sortedOrder == 0) {
                        return o1.name.compareTo(o2.name);
                    } else {
                        return o2.name.compareTo(o1.name);
                    }
                } else {
                    int o1Val = sortParameter == 1 ? o1.pair.relevance : o1.pair.price;
                    int o2Val = sortParameter == 1 ? o2.pair.relevance : o2.pair.price;

                    return sortedOrder == 0 ? o1Val - o2Val : o2Val - o1Val;
                }
            }
        };


        PriorityQueue<Item> heap = new PriorityQueue<Item>(itemComparator);
        heap.addAll(Arrays.asList(itemList));

        HashMap<Integer, List<String>> map = new HashMap<>();
        int p = 0;
        while (p <= pageNum && !heap.isEmpty()) {
            int  num = 0;
            List<String> str = new ArrayList<>();
            while (!heap.isEmpty() && num < itemPerPage) {
                str.add(heap.poll().name);
                num++;
            }
            map.put(p, str);
            p++;
        }
        return map.containsKey(pageNum) ? map.get(pageNum) : new ArrayList<String>();
    }


    public static void main(String[] args) {
        PairInt p1 = new PairInt(10, 15);
        PairInt p2 = new PairInt(3, 4);
        PairInt p3 = new PairInt(17, 8);

        HashMap<String, PairInt> map = new HashMap<>();
        map.put("Item1", p1);
        map.put("Item2", p2);
        map.put("Item3", p3);

        List<String> ans = fetchItemToDisplay(3, map, 1, 0, 2, 1);
        System.out.println(ans.toString());
    }
}

