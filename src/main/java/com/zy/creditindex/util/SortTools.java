package com.zy.creditindex.util;

import org.springframework.data.domain.Sort;

/**
 * Created by ${ZhaoYing}on 2017/10/20 0020
 */
public class SortTools {
    public static Sort basicSort() {
        return basicSort("desc", "id");
    }

    public static Sort basicSort(String orderType, String orderField) {
        Sort sort = new Sort(Sort.Direction.fromString(orderType), orderField);
        return sort;
    }
}
