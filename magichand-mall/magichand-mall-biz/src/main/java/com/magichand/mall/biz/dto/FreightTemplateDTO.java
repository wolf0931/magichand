package com.magichand.mall.biz.dto;

import com.magichand.mall.biz.entity.FreightTemplate;
import com.magichand.mall.biz.entity.FreightTemplateCarriage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FreightTemplateDTO extends SuperDTO {

    private FreightTemplate freightTemplateDO;

    private List<FreightTemplateCarriage> freightTemplateCarriageDOList;

}
