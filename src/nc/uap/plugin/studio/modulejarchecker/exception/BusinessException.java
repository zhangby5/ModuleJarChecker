package nc.uap.plugin.studio.modulejarchecker.exception;

public class BusinessException extends Exception {

  /**
   * 
   */
  private static final long serialVersionUID = -735457325211328873L;

  public BusinessException(Exception e) {
    super(e);
  }

  public BusinessException(String message) {
    super(message);
  }

}
