${pojo.getPackageDeclaration()}


<#assign classbody>

<#assign declarationName = pojo.importType(pojo.getDeclarationName())>

import net.diegozhu.j2ee.ptms.model.${declarationName};
import net.diegozhu.j2ee.ptms.service.base.IBaseService;

/**
 * ${declarationName}Interface.
 * @author diegozhu.net
 */
public interface I${declarationName}Service extends IBaseService<${declarationName}, Integer>{

}  
</#assign>

${pojo.generateImports()}
${classbody}
