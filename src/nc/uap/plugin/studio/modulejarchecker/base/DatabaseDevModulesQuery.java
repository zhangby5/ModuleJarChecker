package nc.uap.plugin.studio.modulejarchecker.base;

import java.util.List;

import com.yonyou.uap.studio.connection.ConnectionService;
import com.yonyou.uap.studio.connection.exception.ConnectionException;
import com.yonyou.uap.studio.connection.rsp.ObjectListResultSetProcessor;

import nc.uap.plugin.studio.modulejarchecker.exception.ExceptionUtils;
import nc.uap.plugin.studio.modulejarchecker.model.ModuleName;

/**
 * 
 * @description
 *              ���ݿ����Ѿ����õ�ģ�飬���п��ܻ���©����ģ�顣
 * @scene
 * 
 * @param
 * 
 *
 * @since 6.3
 * @version 2015��12��30�� ����2:29:38
 * @author zhangby5
 */
public class DatabaseDevModulesQuery implements IModulesQuery {

  @Override
  public String[] queryModules() throws Exception {

    List<ModuleName> result = null;
    try {
      result = ConnectionService.executeQuery(
          "SELECT DISTINCT DEVMODULE FROM DAP_DAPSYSTEM WHERE DEVMODULE IS NOT NULL",
          new ObjectListResultSetProcessor<>(ModuleName.class));
    }
    catch (ConnectionException e) {
      ExceptionUtils.marshRuntimeException("���ݿ����Ӳ���ȷ����������Դ���ã�");
    }
    if (result == null || result.size() == 0) {
      return null;
    }
    String[] exmodule = new String[result.size()];
    int i = 0;
    for (ModuleName mn : result) {
      exmodule[i++] = mn.getDevmodule();
    }
    return exmodule;
  }
}
