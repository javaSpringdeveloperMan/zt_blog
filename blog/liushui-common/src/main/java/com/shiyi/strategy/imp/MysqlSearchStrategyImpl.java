package com.shiyi.strategy.imp;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shiyi.common.Constants;
import com.shiyi.mapper.ArticleMapper;
import com.shiyi.strategy.SearchStrategy;
import com.shiyi.utils.PageUtil;
import com.shiyi.vo.article.ApiArticleSearchVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("mysqlSearch")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MysqlSearchStrategyImpl implements SearchStrategy {

    private final ArticleMapper articleMapper;

    @Override
    public Page<ApiArticleSearchVO> searchArticle(String keywords){
        // 搜索文章
        Page<ApiArticleSearchVO> articlePage = articleMapper.selectSearchArticle(new Page<>(PageUtil.getPageNo(), PageUtil.getPageSize()),
                keywords);
        //高亮处理
        articlePage.getRecords().forEach(item -> item.setTitle(item.getTitle().replaceAll(keywords, Constants.PRE_TAG + keywords + Constants.POST_TAG)));

        return articlePage;
    }
}
