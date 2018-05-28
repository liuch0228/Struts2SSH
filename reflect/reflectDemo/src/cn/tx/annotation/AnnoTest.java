package cn.tx.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import cn.tx.annotation.enums.HttpMethod;

/**
 * 1.自定义注解，自动实现了java.lang.Annotation接口
 * @author Administrator
 * 2.注解内部可以定义值，这里的值既不是属性，也不是方法
 * 3.语法：数据类型      值的名字();
 * 4.注解的意义：当非标识性注解(内部有值的注解)标注在方法上时，当方法被反射调用时，注解才有意义
 * 5.@Retention 注解
 * @Retention(RetentionPolicy.RUNTIME)
 * @Target(ElementType.ANNOTATION_TYPE) public @interface Retention {
 *                                      RetentionPolicy value(); }
 *                                      RetentionPolicy:注解的策略
 * RetentionPolicy.CLASS 表示这个注解能被编译到class文件里，但是运行时不参与运行
 * 6.@Target注解——指示注解类型所适用的程序元素的种类
 * @Documented
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.ANNOTATION_TYPE)
	public @interface Target {
    ElementType[] value();
    ElementType是一个枚举类型
	}
 *  7. @Target @Retention 只能用在注解的定义上面
 */

//ElementType.METHOD,表示AnnoTest只能放在方法上面，不能放在类，属性等其他上面
@Target(value = { ElementType.METHOD,ElementType.TYPE })  
@Retention(value = RetentionPolicy.RUNTIME)
public @interface AnnoTest {

	
	String value();//这里定义了值，在使用注解的地方，就得加上这个值
	
//	Class[]/*String[]*/ location();
//	
//	HttpMethod method();
	
	
}


// enum ElementType {
//    /**类，接口，枚举声明 Class, interface (including annotation type), or enum declaration */
//    TYPE,
//    /**字段声明，包括枚举常量   Field declaration (includes enum constants) */
//    FIELD,
//    /**方法声明   Method declaration */
//    METHOD,
//    /** Parameter declaration */
//    PARAMETER,
//    /** 构造方法声明  Constructor declaration */
//    CONSTRUCTOR,
//    /**局部变量声明  Local variable declaration */
//    LOCAL_VARIABLE,
//    /**注解类型声明   Annotation type declaration */
//    ANNOTATION_TYPE,
//    /**包声明    Package declaration */
//    PACKAGE
//}
