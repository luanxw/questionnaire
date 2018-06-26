/*
 * Date:2018/6/26
 * Create By:Wsiri
 */

package com.briup.apps.poll.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.bean.OptionsExample;
import com.briup.apps.poll.dao.OptionsMapper;
import com.briup.apps.poll.service.IOptionsService;


@Service
public class OptionsServiceImpl implements IOptionsService {
	
	
	@Autowired
	private OptionsMapper optionsMapper;
	/*
	 * 查询所有选项
	 */
	@Override
	public List<Options> findAllOptions() throws Exception {
		// TODO Auto-generated method stub
		OptionsExample example=new OptionsExample();
		return optionsMapper.selectByExampleWithBLOBs(example);
	}
	/*
	 * 根据ID查询
	 */
	@Override
	public Options findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return optionsMapper.selectByPrimaryKey(id);
	}
	/*
	 * 根据关键字查询
	 */
	@Override
	public List<Options> query(String keywords) throws Exception {
		// TODO Auto-generated method stub
		OptionsExample example=new OptionsExample();
		example.createCriteria().andLabelLike("%"+keywords+"%");
		return optionsMapper.selectByExample(example);
	}
	/*
	 * 保存或更新
	 */
	@Override
	public void saveOrUpdate(Options options) throws Exception {
		
		// TODO Auto-generated method stub
		Options count=optionsMapper.selectByPrimaryKey(options.getId());
		if(count!=null){
			optionsMapper.updateByPrimaryKey(options);
		}else{
			optionsMapper.insert(options);
		}
		
	}
	/*
	 * 根据ID删除
	 */
	@Override
	public int deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		return optionsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void batchDelete(Long[] ids) throws Exception {
		// TODO Auto-generated method stub
		for(long id:ids){
			optionsMapper.deleteByPrimaryKey(id);
		}
	}

}
