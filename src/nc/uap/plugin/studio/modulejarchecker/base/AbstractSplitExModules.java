package nc.uap.plugin.studio.modulejarchecker.base;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nc.uap.plugin.studio.modulejarchecker.util.ArrayUtils;

/**
 * 
 * @description
 *              ��������࣬�ṩ�˲�ѯ����ģ��Ͳ�ѯ������ģ�飬������Ҫ���ദ��
 * @scene
 * 
 * @param
 * 
 *
 * @since 6.3
 * @version 2015��12��30�� ����2:26:58
 * @author zhangby5
 */
public abstract class AbstractSplitExModules implements ISplitExModules {

  /**
   * ����ģ���ѯ����
   */
  private List<IModulesQuery> baseModulesQuery = new ArrayList<IModulesQuery>();

  /**
   * ���ݿ���������ģ���ѯ����
   */
  private List<IModulesQuery> databaseModulesQuery =
      new ArrayList<IModulesQuery>();

  protected String[] getAllBaseModules() throws Exception {
    if (baseModulesQuery.size() == 0) {
      return null;
    }
    return queryModules(baseModulesQuery);
  }

  protected String[] getAllDatabaseModulesQuery() throws Exception {
    if (databaseModulesQuery.size() == 0) {
      return null;
    }
    return queryModules(databaseModulesQuery);
  }

  private String[] queryModules(List<IModulesQuery> modulesQuery)
      throws Exception {
    Set<String> baseModules = new HashSet<String>();
    for (IModulesQuery query : modulesQuery) {
      String[] itemModules = query.queryModules();
      if (ArrayUtils.isEmpty(itemModules)) {
        continue;
      }
      for (String str : itemModules) {
        baseModules.add(str);
      }
    }
    return baseModules.toArray(new String[baseModules.size()]);
  }

  public void addBaseModulesQuery(IModulesQuery query) {
    baseModulesQuery.add(query);
  }

  public void addDatabaseModulesQuery(IModulesQuery query) {
    databaseModulesQuery.add(query);
  }

  public List<IModulesQuery> getBaseModulesQuery() {
    return this.baseModulesQuery;
  }

  public void setBaseModulesQuery(List<IModulesQuery> baseModulesQuery) {
    this.baseModulesQuery = baseModulesQuery;
  }

  public List<IModulesQuery> getDatabaseModulesQuery() {
    return this.databaseModulesQuery;
  }

  public void setDatabaseModulesQuery(
      List<IModulesQuery> databaseModulesQuery) {
    this.databaseModulesQuery = databaseModulesQuery;
  }

}
