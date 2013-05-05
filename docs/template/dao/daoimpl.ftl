${pojo.getPackageDeclaration()}


<#assign classbody>

<#assign declarationName = pojo.importType(pojo.getDeclarationName())>

import net.diegozhu.j2ee.ptms.dao.I${declarationName}Dao;
import net.diegozhu.j2ee.ptms.dao.base.impl.BaseDao;
import net.diegozhu.j2ee.ptms.model.${declarationName};
import org.springframework.stereotype.Repository;

/**
 * ${declarationName}Dao.
 * @author diegozhu.net
 */
@Repository  
public class ${pojo.declarationName}Dao extends BaseDao<${pojo.declarationName}, Integer> implements I${pojo.declarationName}Dao{  
  
}  
</#assign>

${pojo.generateImports()}
${classbody}
