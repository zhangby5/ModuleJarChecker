package nc.uap.plugin.studio.modulejarchecker.util;

public class StringUtil {

  public static boolean isEmpty(String str) {
    if (str == null || str.length() == 0 || str.trim().length() == 0) {
      return true;
    }
    return false;
  }

  public static boolean isEquals(String value1, String value2) {
    boolean flag = false;
    if (null != value1) {
      if (null != value2) {
        flag = value2.equals(value1);
      }
    }
    else {
      if (null == value2) {
        flag = true;
      }
    }
    return flag;
  }

}
