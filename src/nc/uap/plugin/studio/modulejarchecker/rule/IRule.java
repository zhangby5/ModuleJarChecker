package nc.uap.plugin.studio.modulejarchecker.rule;

import nc.uap.plugin.studio.modulejarchecker.exception.BusinessException;

/**
 * 
 * @description
 *              业务处理需要处理的规则
 * @scene
 * 
 * @param
 * 
 *
 * @since 6.3
 * @version 2015年12月30日 上午10:55:35
 * @author zhangby5
 */
public interface IRule {

  void process() throws BusinessException;
}
