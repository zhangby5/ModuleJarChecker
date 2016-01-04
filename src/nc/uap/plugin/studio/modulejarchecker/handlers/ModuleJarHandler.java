package nc.uap.plugin.studio.modulejarchecker.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import nc.uap.plugin.studio.modulejarchecker.exception.BusinessException;
import nc.uap.plugin.studio.modulejarchecker.rule.IRule;
import nc.uap.plugin.studio.modulejarchecker.rule.RuleProcesser;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class ModuleJarHandler extends AbstractHandler {

  /**
   * The constructor.
   */
  public ModuleJarHandler() {
  }

  /**
   * the command has been executed, so extract extract the needed information
   * from the application context.
   */
  public Object execute(ExecutionEvent event) throws ExecutionException {
    IWorkbenchWindow window =
        HandlerUtil.getActiveWorkbenchWindowChecked(event);
    RuleProcesser processor = new RuleProcesser();
    this.addRule(processor);
    try {
      processor.process();
    }
    catch (BusinessException e) {
      MessageDialog.openInformation(window.getShell(), "自动检查启用模块",
          e.getMessage());
      throw new ExecutionException(e.getMessage());
    }
    MessageDialog.openInformation(window.getShell(), "自动检查启用模块", "已检查完毕");
    return null;
  }

  private void addRule(RuleProcesser processor) {
    IRule rule = new AutoSelectModuleJarRule();
    processor.addRule(rule);
  }
}
