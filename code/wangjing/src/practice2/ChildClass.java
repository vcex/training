 
package practice2;

/**
 * <p>
 * @TODO 请“caoqifa” 尽快添加代码注释!（中文表达，简要说明）
 * </p>
 *
 * @author caoqifa
 *
 * @version 1.0.0
 *
 * @since 1.0.0
 *
 */
public class ChildClass extends FatherClass{

	public void func1()
	{
		System.out.println("This is Func1 of ChildClass");
	}
	
	 public void callFathersFun1()
	 {
		 super.func1();
	 }
}
