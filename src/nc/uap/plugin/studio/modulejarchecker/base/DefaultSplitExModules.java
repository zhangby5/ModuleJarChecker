package nc.uap.plugin.studio.modulejarchecker.base;

import java.util.HashSet;
import java.util.Set;

import nc.uap.plugin.studio.modulejarchecker.exception.ExceptionUtils;
import nc.uap.plugin.studio.modulejarchecker.util.ArrayUtils;
import nc.uap.plugin.studio.modulejarchecker.util.StringUtil;

/**
 * 
 * @description
 *              默认过滤启用模块类
 * @scene
 * 
 * @param
 * 
 *
 * @since 6.3
 * @version 2015年12月30日 下午2:28:44
 * @author zhangby5
 */
public class DefaultSplitExModules extends AbstractSplitExModules {

  public DefaultSplitExModules() {
    // 最好通过spring注入
    this.addBaseModulesQuery(new NchomeModulesQuery());
    this.addDatabaseModulesQuery(new DatabaseDevModulesQuery());
    this.addDatabaseModulesQuery(new JsonDocModulesQuery());
  }

  @Override
  public String[] splitExModules() throws Exception {

    String[] allBaseModules = this.getAllBaseModules();
    String[] devModules = this.getAllDatabaseModulesQuery();
    if (ArrayUtils.isEmpty(allBaseModules)) {
      ExceptionUtils.marshRuntimeException("请检查NCHOME路径下的modules文件是否为空！");
    }
    if (ArrayUtils.isEmpty(devModules)) {
      return new String[0];
    }
    Set<String> exmoduleset = new HashSet<String>();
    retry:
    for (String baseModule : allBaseModules) {
       for (String devModule : devModules) {
        if (StringUtil.isEquals(baseModule, devModule)) {
          continue retry;
        }
      }
      exmoduleset.add(baseModule);
    }
    return exmoduleset.toArray(new String[exmoduleset.size()]);
  }
}
