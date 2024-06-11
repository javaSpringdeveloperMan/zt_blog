package com.shiyi.mapper;

import com.shiyi.entity.ArticleElastic;
import org.dromara.easyes.core.kernel.BaseEsMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface EasyesMapper extends BaseEsMapper<ArticleElastic> {
}
