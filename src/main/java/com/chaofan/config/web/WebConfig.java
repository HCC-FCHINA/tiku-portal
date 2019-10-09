package com.chaofan.config.web;

import com.chaofan.web.interceptor.MemberInterceptor;
import com.chaofan.web.interceptor.MenuInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Value("${file.storage.path}")
	private String fileStoragePath;
	@Value("${cookie.domian.name}")
	private String cookieDomianName;
	@Autowired
	private MemberInterceptor memberInterceptor;
	@Autowired
	private MenuInterceptor menuInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(menuInterceptor).addPathPatterns("/**");
		registry.addInterceptor(memberInterceptor).addPathPatterns("/member/**");
	}
	
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	   registry.addResourceHandler("/files/**").addResourceLocations("file:"+fileStoragePath);
    }
    
    @Bean
    public CookieSerializer defaultCookieSerializer(){
        DefaultCookieSerializer defaultCookieSerializer = new DefaultCookieSerializer();
        defaultCookieSerializer.setCookieName("sessionId");
        defaultCookieSerializer.setDomainName(cookieDomianName);
        defaultCookieSerializer.setCookiePath("/");
        return defaultCookieSerializer;
    }
    
}
