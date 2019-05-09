package edu.bgcms.helper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListHelper {
    /**
     * 比较一个list集合里是否有重复
     * */
    public static boolean isRepeat(List<Object> list) {
        Set<Object> set = new HashSet<>(list);
        return set.size() != list.size();
    }
/**
 * 比较两个集合是否有重复
 * */
public static boolean isRepeat(List<Object> list1, List<Object> list2){
    Set<Object> set1 = new HashSet<>(list1);
    Set<Object> set2 = new HashSet<>(list2);
    Set<Object> setAll = new HashSet<>(set1);
    setAll.addAll(set2);
    int setSize = set1.size() + set2.size();
    return setAll.size() != setSize;
}
}
