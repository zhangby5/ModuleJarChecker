package nc.uap.plugin.studio.modulejarchecker.base;

import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.Gson;

import nc.uap.plugin.studio.modulejarchecker.exception.ExceptionUtils;
import nc.uap.plugin.studio.modulejarchecker.handlers.AutoSelectModuleJarRule;
import nc.uap.plugin.studio.modulejarchecker.model.ModuleBean;

/**
 * 
 * @description
 *              ��ȡJSON�ļ�����ӵ�����ģ��
 * @scene
 * 
 * @param
 * 
 *
 * @since 6.3
 * @version 2015��12��30�� ����2:30:44
 * @author zhangby5
 */
public class JsonDocModulesQuery implements IModulesQuery {

  private String jsonLocation = "/exmodule.json";

  @Override
  public String[] queryModules() throws Exception {

    ModuleBean bean = null;
    try {
      Gson gson = new Gson();
      InputStream input = new AutoSelectModuleJarRule().getClass()
          .getResourceAsStream(this.getJsonLocation());
      bean = gson.fromJson(new InputStreamReader(input), ModuleBean.class);
    }
    catch (Exception e) {
      ExceptionUtils.marshRuntimeException(e);
    }
    return bean.getModuleName();
  }

  public String getJsonLocation() {
    return this.jsonLocation;
  }

  public void setJsonLocation(String jsonLocation) {
    this.jsonLocation = jsonLocation;
  }
}
