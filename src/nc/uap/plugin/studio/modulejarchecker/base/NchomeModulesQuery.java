package nc.uap.plugin.studio.modulejarchecker.base;

import java.io.File;

import nc.uap.plugin.studio.StudioUtil;
import nc.uap.plugin.studio.modulejarchecker.exception.ExceptionUtils;
import nc.uap.plugin.studio.modulejarchecker.util.ArrayUtils;
import nc.uap.plugin.studio.modulejarchecker.util.StringUtil;

/**
 * 
 * @description
 *              查询NCHOME/modules下的所有模块
 * @scene
 * 
 * @param
 * 
 *
 * @since 6.3
 * @version 2015年12月30日 下午2:07:28
 * @author zhangby5
 */
public class NchomeModulesQuery implements IModulesQuery {

  @Override
  public String[] queryModules() throws Exception {
    String nchome = StudioUtil.getNCHome();
    if (StringUtil.isEmpty(nchome)) {
      ExceptionUtils.marshRuntimeException("NCHOME未设置");
    }
    File module = new File(nchome + "/modules");
    String[] modules = null;
    if (module.exists()) {
      modules = module.list();
    }
    if (ArrayUtils.isEmpty(modules)) {
      ExceptionUtils.marshRuntimeException("NCHOME设置不正确，请检查NCHOME下的modules文件夹");
    }
    return modules;
  }
}
