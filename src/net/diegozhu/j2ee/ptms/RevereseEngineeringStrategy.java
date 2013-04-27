package net.diegozhu.j2ee.ptms;

import org.hibernate.cfg.reveng.DelegatingReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.ReverseEngineeringSettings;
import org.hibernate.cfg.reveng.ReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.TableIdentifier;

public class RevereseEngineeringStrategy extends DelegatingReverseEngineeringStrategy {

	public RevereseEngineeringStrategy(ReverseEngineeringStrategy delegate) {
		super(delegate);
	}

	@Override
	public void setSettings(ReverseEngineeringSettings settings) {
		super.setSettings(settings);
	}

	@Override
	public boolean excludeForeignKeyAsCollection(String keyname, TableIdentifier fromTable, java.util.List fromColumns, TableIdentifier referencedTable,
	        java.util.List referencedColumns) {

		System.out.print(keyname + " " + fromTable.getName() + " " + fromColumns + " " + referencedTable.getName());
		// if (keyname.equals("___") && fromTable.getName().equals("___") &&
		// fromColumns.contains("___") &&
		// referencedTable.getName().equals("___")
		// && referencedColumns.contains("___")) {
		//
		// return true;
		// }

		return false;
	}
}
