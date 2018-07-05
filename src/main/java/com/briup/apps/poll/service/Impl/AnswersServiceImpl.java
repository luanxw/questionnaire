package com.briup.apps.poll.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.answers;
import com.briup.apps.poll.bean.answersExample;
import com.briup.apps.poll.dao.answersMapper;
import com.briup.apps.poll.service.IAnswersService;

/**
*          @author
*          @version
*          @describe
*/
@Service
public class AnswersServiceImpl implements IAnswersService{
	@Autowired
	private  answersMapper answersMapper;
	
	
	@Override
	public List<answers> findAll() throws Exception {
		answersExample example=new answersExample();
		
		return answersMapper.selectByExample(example);
	}

	@Override
	public answers findById(Long id) throws Exception {
		return answersMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<answers> query(String keywords) throws Exception {
		answersExample example=new answersExample();
		example.createCriteria().andContentLike("%"+keywords+"%");
		return answersMapper.selectByExample(example);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		answersMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void saveOrUpdate(answers answers) throws Exception {
		answers answers2=answersMapper.selectByPrimaryKey(answers.getId());
		if(answers2!=null){
			answersMapper.updateByPrimaryKey(answers);
		}else{
			answersMapper.insert(answers);
		}
	}

	@Override
	public void batchDelete(Long[] ids) throws Exception {
		for(long id:ids){
			answersMapper.deleteByPrimaryKey(id);
		}
	}
	@Override
	public List<answers> findAnswersBySurveyId(long id) throws Exception {
		answersExample example = new answersExample();
		example.createCriteria().andSurveyIdEqualTo(id);
		return answersMapper.selectByExample(example);
	}

}
