package org.bte.core.utils;

import java.sql.Types;

import org.hibernate.dialect.MySQLDialect;
import org.hibernate.type.StandardBasicTypes;

public class MySQlServerDBDialect extends MySQLDialect {

	public MySQlServerDBDialect() { 
		super(); 
		registerHibernateType(Types.BIGINT, StandardBasicTypes.INTEGER.getName());
	} 
}
