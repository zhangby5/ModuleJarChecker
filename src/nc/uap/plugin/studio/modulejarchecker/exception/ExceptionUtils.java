package nc.uap.plugin.studio.modulejarchecker.exception;

public class ExceptionUtils {

  public static void throwsRuntimeException(Exception e) {
    ExceptionUtils.throwsRuntimeExceptionWithoutLog(e);
  }

  public static void throwsRuntimeException(String message) {
    ExceptionUtils.throwsRuntimeExceptionWithoutLog(message);
  }

  public static void throwsRuntimeException(Throwable t) {
    ExceptionUtils.throwsRuntimeExceptionWithoutLog(t);
  }

  public static void throwsRuntimeExceptionWithoutLog(Throwable t) {
    throw new RuntimeException(t);
  }

  public static void throwsRuntimeExceptionWithoutLog(Exception e) {
    throw new RuntimeException(e);
  }

  public static void throwsRuntimeExceptionWithoutLog(String message) {
    throw new RuntimeException(message);
  }

  public static void marshRuntimeException(Exception e)
      throws BusinessException {
    throw new BusinessException(e);
  }

  public static void marshRuntimeException(String message)
      throws BusinessException {
    throw new BusinessException(message);
  }

}
