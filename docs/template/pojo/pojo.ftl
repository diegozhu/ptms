/*
 * ptms
 * Copyright (c) 2013 diegozhu All Rights Reserved.
 */
${pojo.getPackageDeclaration()}

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

<#assign classbody>

/**
${pojo.getClassJavaDoc(clazz.table.comment + "<br>", 0)}
${pojo.getClassJavaDoc("table:" + clazz.table.name + "<br>", 0)}
 * @author diego zhu
 * @version 1.0
 */
 
@Entity
@Table(name = "${pojo.getDeclarationName()}", catalog = "ptms")
${pojo.getClassModifiers()} ${pojo.getDeclarationType()} ${pojo.getDeclarationName()} implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
<#-- // Fields -->
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
<#foreach field in pojo.getAllPropertiesIterator()>
	
	<#if (pojo.getJavaTypeName(field, jdk5) != "String" && pojo.getJavaTypeName(field, jdk5) != "Integer") && pojo.getJavaTypeName(field, jdk5) != "Set"  && pojo.getJavaTypeName(field, jdk5) != "Double"  && pojo.getJavaTypeName(field, jdk5) != "Boolean"&& pojo.getJavaTypeName(field, jdk5) != "int">
		@ManyToOne
		@JoinColumn(name = "${field.name}id")
		${pojo.getFieldModifiers(field)} ${pojo.getJavaTypeName(field, jdk5)} ${field.name};
	</#if>
	<#if pojo.getJavaTypeName(field, jdk5) == "String" || pojo.getJavaTypeName(field, jdk5) == "Integer" || pojo.getJavaTypeName(field, jdk5) == "Double"  || pojo.getJavaTypeName(field, jdk5) == "Boolean" || pojo.getJavaTypeName(field, jdk5) == "int">
		@Column(name = "${field.name}")
		${pojo.getFieldModifiers(field)} ${pojo.getJavaTypeName(field, jdk5)} ${field.name};
	</#if>
</#foreach>
   
<#foreach property in pojo.getAllPropertiesIterator()>
	<#if pojo.getJavaTypeName(property, jdk5) != "Set">
	${pojo.getPropertyGetModifiers(property)} ${pojo.getJavaTypeName(property, jdk5)} ${pojo.getGetterSignature(property)}() {
        return this.${property.name};
    }
	${pojo.getPropertySetModifiers(property)} void set${pojo.getPropertyName(property)}(${pojo.getJavaTypeName(property, jdk5)} ${property.name}) {
		this.${property.name} = ${property.name};
	}
	</#if>
</#foreach>


 public String toString() {
	return "${pojo.getDeclarationName()}:"<#foreach field in pojo.getAllPropertiesIterator()><#if pojo.getJavaTypeName(field, jdk5) != "Set">+this.${field.name}</#if></#foreach>;
     }

public boolean equals(Object obj){
		 return obj.hashCode() == this.hashCode();
   }
   
   public int hashCode() {
        return this.id;
	}
}
</#assign>

${pojo.generateImports()}
${classbody}

