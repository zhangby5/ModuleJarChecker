package nc.uap.plugin.studio.modulejarchecker.rule;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import nc.uap.plugin.studio.modulejarchecker.exception.BusinessException;
import nc.uap.plugin.studio.modulejarchecker.exception.ExceptionUtils;

/**
 * 
 * @description
 *              规则处理类
 * @scene
 * 
 * @param
 * 
 *
 * @since 1.0
 * @version 2015年12月30日 上午10:54:58
 * @author zhangby5
 */
public class RuleProcesser {

  private List<IRule> ruleList = new ArrayList<IRule>();

  public void addRule(IRule rule) {
    ruleList.add(rule);
  }

  public boolean removeRule(IRule rule) {
    return ruleList.remove(rule);
  }

  public void process() throws BusinessException {
    if (ruleList.size() == 0) {
      return;
    }
    Iterator<IRule> it = ruleList.iterator();
    while (it.hasNext()) {
      IRule rule = (IRule) it.next();
      if (rule != null) {
        try {
          rule.process();
        }
        catch (BusinessException e) {
          ExceptionUtils.marshRuntimeException(e);
        }
      }
    }
  }
}
