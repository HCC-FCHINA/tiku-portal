package com.chaofan.config.web;

import com.chaofan.common.utils.SystemConstant;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Component
public class ThymeleafConfig implements EnvironmentAware{

	@Resource
    private Environment env;

	@Resource
	private void configureThymeleafStaticVars(ThymeleafViewResolver viewResolver) {
	    if(viewResolver != null) {
	        Map<String, Object> vars = new HashMap<>();
	        vars.put("domainName", env.getProperty("domain.name"));
	        vars.put("adminDomain", env.getProperty("admin.domain.name"));
	        vars.put("memberDomain", env.getProperty("member.domain.name"));
	        vars.put("PAPER_TYPE_ZHENTI", SystemConstant.ZHENGTI_PAPER_ID);
	        vars.put("PAPER_TYPE_MONI", SystemConstant.MONI_PAPER_ID);
	        vars.put("PAPER_TYPE_YATI", SystemConstant.YATI_PAPER_ID);
	        vars.put("PAPER_TYPE_MINGXIAO", SystemConstant.MINGXIAO_PAPER_ID);
	        vars.put("BEIJING_AREA_ID", SystemConstant.BEIJING_AREA_ID);
	        viewResolver.setStaticVariables(vars);
	    }
	}

	@Override
	public void setEnvironment(Environment environment) {
		env = environment;
	}

}
