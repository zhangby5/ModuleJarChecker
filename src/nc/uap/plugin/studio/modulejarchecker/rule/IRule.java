package nc.uap.plugin.studio.modulejarchecker.rule;

import nc.uap.plugin.studio.modulejarchecker.exception.BusinessException;

/**
 * 
 * @description
 *              ҵ������Ҫ����Ĺ���
 * @scene
 * 
 * @param
 * 
 *
 * @since 6.3
 * @version 2015��12��30�� ����10:55:35
 * @author zhangby5
 */
public interface IRule {

  void process() throws BusinessException;
}
