package com.gttown.template.service;

import com.gttown.common.support.mybatis.BaseCRUDService;
import com.gttown.template.entity.Template;

import javax.jws.WebMethod;

public interface TemplateService extends BaseCRUDService<Template> {
    @WebMethod
    Template webMethod();

    Template localMethod();
}
