package com.example.demo.代理;

import java.lang.reflect.Proxy;

/**
 * @program: demo
 * @description:
 * @author: Mr.Zhang
 * @create: 2019-07-24 10:47
 **/
// 抽象接口
interface IStudentDao {
	void save();
}

// 目标对象
class StudentDao implements IStudentDao {
	@Override
	public void save() {
		System.out.println(" 保存成功 ");
	}
}

// 代理对象
public class StudentDaoProxy implements IStudentDao{
	// 持有目标对象的引用
	private IStudentDao target;
	public StudentDaoProxy(IStudentDao target){
		this.target = target;
	}

	// 在目标功能对象方法的前后加入事务控制
	@Override
	public void save() {
		System.out.println(" 开始事务 ");
		target.save();// 执行目标对象的方法
		System.out.println(" 提交事务 ");
	}

	public static void main(String[] args) {
		// 创建目标对象
		StudentDao target = new StudentDao();

		// 创建代理对象, 把目标对象传给代理对象, 建立代理关系
		StudentDaoProxy proxy = new StudentDaoProxy(target);

		// 执行的是代理的方法
		proxy.save();

	}
}