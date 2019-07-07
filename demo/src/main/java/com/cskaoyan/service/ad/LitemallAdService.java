package com.cskaoyan.service.ad;

import com.cskaoyan.bean.Ad;
import com.cskaoyan.bean.AdExample;
import com.cskaoyan.mapper.AdMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

/**
 * 
 * @version 1.0 2019/7/4
 * @author Wei
 */
@Service
public class LitemallAdService {
    @Resource
    private AdMapper adMapper;

    public List<Ad> querySelective(String name, String content, Integer page, Integer limit, String sort, String order) {
        AdExample example = new AdExample();
        AdExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        if (!StringUtils.isEmpty(content)) {
            criteria.andContentLike("%" + content + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return adMapper.selectByExample(example);
    }

    public void deleteById(Integer id) {
        adMapper.deleteByPrimaryKey(id);
    }

    public int updateById(Ad ad) {
        ad.setUpdateTime(new Date());
        return adMapper.updateByPrimaryKeySelective(ad);
    }

    public void add(Ad ad) {
        ad.setAddTime(new Date());
        ad.setUpdateTime(new Date());
        adMapper.insertSelective(ad);
    }
}
