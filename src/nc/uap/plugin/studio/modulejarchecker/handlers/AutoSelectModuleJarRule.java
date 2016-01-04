package nc.uap.plugin.studio.modulejarchecker.handlers;

import nc.uap.plugin.studio.CommonPlugin;
import nc.uap.plugin.studio.modulejarchecker.base.DefaultSplitExModules;
import nc.uap.plugin.studio.modulejarchecker.base.ISplitExModules;
import nc.uap.plugin.studio.modulejarchecker.exception.BusinessException;
import nc.uap.plugin.studio.modulejarchecker.exception.ExceptionUtils;
import nc.uap.plugin.studio.modulejarchecker.rule.IRule;

/**
 * 
 * @description
 *              �Զ���ѡ���ݿ������õ�ģ��
 * @scene
 * 
 * @param
 * 
 *
 * @since 6.3
 * @version 2015��12��30�� ����2:43:26
 * @author zhangby5
 */
public class AutoSelectModuleJarRule implements IRule {

  @Override
  public void process() throws BusinessException {
    ISplitExModules dsem = new DefaultSplitExModules();
    String[] exModules = null;
    try {
      exModules = dsem.splitExModules();
    }
    catch (Exception e) {
      ExceptionUtils.marshRuntimeException(e);
    }
    StringBuffer buffer = new StringBuffer();
    if (exModules != null) {
      for (Object obj : exModules) {
        buffer.append(obj);
        buffer.append(",");
      }
      if (buffer.length() > 1) {
        buffer.setLength(buffer.length() - 1);
      }
    }
    CommonPlugin.getDefault().getPreferenceStore().setValue("FIELD_EX_MODULES",
        buffer.toString());
  }

}
