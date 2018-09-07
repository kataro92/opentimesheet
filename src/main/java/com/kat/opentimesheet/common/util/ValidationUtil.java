package com.kat.opentimesheet.common.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ValidationUtil {
    public static boolean isEmpty(Object target){
        if (target == null) {
            return true;
        }
        if (target instanceof String) {
            return StringUtils.isEmpty(target.toString());
        }
        else if (target instanceof String && String.valueOf(target).trim().equals("")) {
            return true;
        }
        return target instanceof Object[] && ((Object[]) target).length == 0 ? true : target instanceof List<?>
                && ((List<?>) target).size() == 0 ? true : target instanceof Map<?, ?>
                && ((Map<?, ?>) target).size() == 0 ? true : target instanceof Collection<?>
                && ((Collection<?>) target).size() == 0 ? true : false;
    }
}
