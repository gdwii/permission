package mybatis.genertor;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.internal.DefaultCommentGenerator;

public class CustomCommentGenerator extends DefaultCommentGenerator{
	@Override
	public void addFieldComment(Field field, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
		String columnRemarks = introspectedColumn.getRemarks();
		if(columnRemarks == null || columnRemarks.length() == 0){
			return;
		}
        field.addJavaDocLine("/**"); //$NON-NLS-1$
        field.addJavaDocLine(" * " + introspectedColumn.getRemarks()); //$NON-NLS-1$
        field.addJavaDocLine(" */"); //$NON-NLS-1$
	}
	
	@Override
	public void addGetterComment(Method method, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
	}
	
	@Override
	public void addSetterComment(Method method, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
	}
	
	@Override
	public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
	}
}
