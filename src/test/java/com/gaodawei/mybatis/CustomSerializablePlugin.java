package mybatis.genertor;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.plugins.SerializablePlugin;

public class CustomSerializablePlugin extends SerializablePlugin{
	FullyQualifiedJavaType serializable = new FullyQualifiedJavaType("java.io.Serializable"); //$NON-NLS-1$
	@Override
	public void makeSerializable(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		 topLevelClass.addImportedType(serializable);
         topLevelClass.addSuperInterface(serializable);

         Field field = new Field();
         field.setFinal(true);
         field.setInitializationString("1L"); //$NON-NLS-1$
         field.setName("serialVersionUID"); //$NON-NLS-1$
         field.setStatic(true);
         field.setType(new FullyQualifiedJavaType("long")); //$NON-NLS-1$
         field.setVisibility(JavaVisibility.PRIVATE);
         topLevelClass.addField(field);
	}
}
