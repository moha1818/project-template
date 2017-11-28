package com.gttown.template.api;

import com.gttown.common.auth.annotation.Authority;
import com.gttown.common.support.enums.enterprise.Tag;
import com.gttown.common.support.web.api.common.RestResponse;
import com.gttown.template.entity.Template;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/template")
@Api(description = "渠道API")
@Authority(value = Tag.GTTOWN_CHANNEL)
public class TemplateApi {

    @RequestMapping(value = "test", method = RequestMethod.GET)
    @ApiOperation(value = "当前渠道信息", notes = "获取当前登陆的渠道信息 [@胡斌]")
    public RestResponse<Template> test() {
        return null;
    }
}
