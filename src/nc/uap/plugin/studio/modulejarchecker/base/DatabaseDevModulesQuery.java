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
 *              数据库中已经启用的模块，但有可能会遗漏部分模块。
 * @scene
 * 
 * @param
 * 
 *
 * @since 6.3
 * @version 2015年12月30日 下午2:29:38
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
      ExceptionUtils.marshRuntimeException("数据库连接不正确，请检查数据源配置！");
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
