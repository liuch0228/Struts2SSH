package cn.tx.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import cn.tx.annotation.enums.HttpMethod;

/**
 * 1.�Զ���ע�⣬�Զ�ʵ����java.lang.Annotation�ӿ�
 * @author Administrator
 * 2.ע���ڲ����Զ���ֵ�������ֵ�Ȳ������ԣ�Ҳ���Ƿ���
 * 3.�﷨����������      ֵ������();
 * 4.ע������壺���Ǳ�ʶ��ע��(�ڲ���ֵ��ע��)��ע�ڷ�����ʱ�����������������ʱ��ע���������
 * 5.@Retention ע��
 * @Retention(RetentionPolicy.RUNTIME)
 * @Target(ElementType.ANNOTATION_TYPE) public @interface Retention {
 *                                      RetentionPolicy value(); }
 *                                      RetentionPolicy:ע��Ĳ���
 * RetentionPolicy.CLASS ��ʾ���ע���ܱ����뵽class�ļ����������ʱ����������
 * 6.@Targetע�⡪��ָʾע�����������õĳ���Ԫ�ص�����
 * @Documented
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.ANNOTATION_TYPE)
	public @interface Target {
    ElementType[] value();
    ElementType��һ��ö������
	}
 *  7. @Target @Retention ֻ������ע��Ķ�������
 */

//ElementType.METHOD,��ʾAnnoTestֻ�ܷ��ڷ������棬���ܷ����࣬���Ե���������
@Target(value = { ElementType.METHOD,ElementType.TYPE })  
@Retention(value = RetentionPolicy.RUNTIME)
public @interface AnnoTest {

	
	String value();//���ﶨ����ֵ����ʹ��ע��ĵط����͵ü������ֵ
	
//	Class[]/*String[]*/ location();
//	
//	HttpMethod method();
	
	
}


// enum ElementType {
//    /**�࣬�ӿڣ�ö������ Class, interface (including annotation type), or enum declaration */
//    TYPE,
//    /**�ֶ�����������ö�ٳ���   Field declaration (includes enum constants) */
//    FIELD,
//    /**��������   Method declaration */
//    METHOD,
//    /** Parameter declaration */
//    PARAMETER,
//    /** ���췽������  Constructor declaration */
//    CONSTRUCTOR,
//    /**�ֲ���������  Local variable declaration */
//    LOCAL_VARIABLE,
//    /**ע����������   Annotation type declaration */
//    ANNOTATION_TYPE,
//    /**������    Package declaration */
//    PACKAGE
//}
