package com.gttown.template.entity;

import io.swagger.annotations.ApiModelProperty;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "template")
@NameStyle(Style.normal)
public class Template {
    @Id
    @Column(name = "Id")
    @ApiModelProperty(value = "企业ID", required = true)
    private Long id;

    @Column(name = "LegalPersonId")
    @ApiModelProperty(value = "法人ID")
    private Long legalPersonId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLegalPersonId() {
        return legalPersonId;
    }

    public void setLegalPersonId(Long legalPersonId) {
        this.legalPersonId = legalPersonId;
    }
}
