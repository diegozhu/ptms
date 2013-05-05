${pojo.getPackageDeclaration()}


<#assign classbody>

<#assign declarationName = pojo.importType(pojo.getDeclarationName())>

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.diegozhu.j2ee.ptms.model.${declarationName};
import net.diegozhu.j2ee.ptms.dao.impl.${declarationName}Dao;
import net.diegozhu.j2ee.ptms.service.I${declarationName}Service;
import net.diegozhu.j2ee.ptms.service.base.impl.BaseService;


/**
 * ${declarationName}Interface.
 * @author diegozhu.net
 */
@Service
public class ${declarationName}Service extends BaseService<${declarationName}, Integer> implements I${declarationName}Service {
	
	
	@Autowired  
    public void setBaseDao(${declarationName}Dao dao) {  
        super.setBaseDao(dao);  
    }  

}
</#assign>

${pojo.generateImports()}
${classbody}
