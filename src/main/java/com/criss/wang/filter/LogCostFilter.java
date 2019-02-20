package com.criss.wang.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


/**
 *
 * author: wangqiubao
 *
 * date: 2019-02-20 09:05:08
 *
 * describe: @WebFilter这个注解并没有指定执行顺序的属性，其执行顺序依赖于Filter的名称，
 * 			是根据Filter类名（注意不是配置的filter的名字）的字母顺序倒序排列，
 * 			并且@WebFilter指定的过滤器优先级都高于FilterRegistrationBean配置的过滤器。
 * 			除了这个注解以外，我们还需在配置类中加另外一个注解：@ServletComponentScan，指定扫描的包。
 */

@WebFilter(urlPatterns = "/*", filterName = "logFilter")
public class LogCostFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	// 这段代码的逻辑比较简单，就是在方法执行前先记录时间戳，然后通过过滤器链完成请求的执行，在返回结果之间计算执行的时间。
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		long start = System.currentTimeMillis();
		filterChain.doFilter(servletRequest, servletResponse);
		System.out.println("LogFilter2 Execute cost=" + (System.currentTimeMillis() - start));
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
