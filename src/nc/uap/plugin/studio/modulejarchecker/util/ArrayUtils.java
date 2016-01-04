package nc.uap.plugin.studio.modulejarchecker.util;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtils {

  public static boolean isEmpty(Object[] arrays) {
    if (null == arrays || 0 == arrays.length) {
      return true;
    }
    return false;
  }

  public static <T> List<T> arrayToList(T[] t) {
    if (ArrayUtils.isEmpty(t)) {
      return new ArrayList<>(0);
    }
    else {
      List<T> list = new ArrayList<T>();
      for (T e : t) {
        list.add(e);
      }
      return list;
    }
  }
}
