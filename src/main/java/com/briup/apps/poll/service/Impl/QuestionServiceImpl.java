package com.briup.apps.poll.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.QuestionExample;
import com.briup.apps.poll.dao.QuestionMapper;
import com.briup.apps.poll.service.IQuestionService;

@Service
public class QuestionServiceImpl implements IQuestionService{
	@Autowired
	private QuestionMapper questionMapper;
	@Override
	public List<Question> findAll() throws Exception {
		// TODO Auto-generated method stub
		QuestionExample example = new QuestionExample();
		
		return questionMapper.selectByExample(example);
	}

	@Override
	public Question findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return questionMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Question> query(String keywords) throws Exception {
		// TODO Auto-generated method stub
		QuestionExample example = new QuestionExample();
		//添加了
		example.createCriteria().andNameLike(keywords);
		return questionMapper.selectByExample(example);
	}

	@Override
	public void saveOrUpdate(Question question) throws Exception {
		// TODO Auto-generated method stub
		if(question.getId()!=null){
			//更新
			questionMapper.updateByPrimaryKey(question);
		}else{
			//插入
			questionMapper.insert(question);
		}
	}

	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		questionMapper.deleteByPrimaryKey(id);
	}


	@Override
	public void batchDelete(Long[] ids) throws Exception {
		// TODO Auto-generated method stub
		
	}

	/*
	 * @Override(non-Javadoc)
	 * @see com.briup.apps.poll.service.IQuestionService#findById()
	 * public List<Question> findById() {
		// TODO Auto-generated method stub
		return null;
	}
	 */
	
}
