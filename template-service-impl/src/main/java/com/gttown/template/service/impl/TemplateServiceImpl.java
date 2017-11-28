package com.gttown.template.service.impl;

import com.gttown.common.support.mybatis.BaseCRUDServiceImpl;
import com.gttown.template.entity.Template;
import com.gttown.template.service.TemplateService;
import org.springframework.stereotype.Service;

@Service
public class TemplateServiceImpl extends BaseCRUDServiceImpl<Template> implements TemplateService {
    @Override
    public Template webMethod() {
        return null;
    }

    @Override
    public Template localMethod() {
        return null;
    }
}
