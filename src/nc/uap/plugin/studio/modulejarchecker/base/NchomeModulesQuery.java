package nc.uap.plugin.studio.modulejarchecker.base;

import java.io.File;

import nc.uap.plugin.studio.StudioUtil;
import nc.uap.plugin.studio.modulejarchecker.exception.ExceptionUtils;
import nc.uap.plugin.studio.modulejarchecker.util.ArrayUtils;
import nc.uap.plugin.studio.modulejarchecker.util.StringUtil;

/**
 * 
 * @description
 *              ��ѯNCHOME/modules�µ�����ģ��
 * @scene
 * 
 * @param
 * 
 *
 * @since 6.3
 * @version 2015��12��30�� ����2:07:28
 * @author zhangby5
 */
public class NchomeModulesQuery implements IModulesQuery {

  @Override
  public String[] queryModules() throws Exception {
    String nchome = StudioUtil.getNCHome();
    if (StringUtil.isEmpty(nchome)) {
      ExceptionUtils.marshRuntimeException("NCHOMEδ����");
    }
    File module = new File(nchome + "/modules");
    String[] modules = null;
    if (module.exists()) {
      modules = module.list();
    }
    if (ArrayUtils.isEmpty(modules)) {
      ExceptionUtils.marshRuntimeException("NCHOME���ò���ȷ������NCHOME�µ�modules�ļ���");
    }
    return modules;
  }
}
