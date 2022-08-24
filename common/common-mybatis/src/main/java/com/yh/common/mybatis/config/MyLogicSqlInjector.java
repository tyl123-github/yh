package com.yh.common.mybatis.config;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.metadata.TableInfo;

import java.util.List;

/**
 * 功能描述: 自定义 SqlInjector
 *
 * @author yl_tao
 * @date 2022/5/13 16:29
 */
public class MyLogicSqlInjector extends DefaultSqlInjector {

	/**
	 * 如果只需增加方法，保留MP自带方法
	 * 可以super.getMethodList()
	 * 再add
	 *
	 * @return List<AbstractMethod>
	 */
	@Override
	public List<AbstractMethod> getMethodList(Class<?> mapperClass, TableInfo tableInfo) {
		return super.getMethodList(mapperClass, tableInfo);
	}
}