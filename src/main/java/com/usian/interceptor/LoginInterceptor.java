package com.usian.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usian.bean.Student;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;


public class LoginInterceptor implements HandlerInterceptor{

	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/student/**");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler)throws Exception {
		String uri = request.getRequestURI();
		if(uri.contains("ogin") || uri.contains("c") || uri.contains("ame")){
			return true;
		}
		Student user = (Student) request.getSession().getAttribute("s");
		if(user!=null){
			return true;
		}
		response.sendRedirect("/student/login");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler,ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex)throws Exception {
	}

}