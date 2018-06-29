package com.briup.apps.poll.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.briup.apps.poll.bean.Qq;
import com.briup.apps.poll.bean.QqExample;
import com.briup.apps.poll.bean.extend.QqVM;
import com.briup.apps.poll.dao.QqMapper;
import com.briup.apps.poll.dao.extend.QqVMMapper;
import com.briup.apps.poll.service.IQqService;

import io.swagger.annotations.ApiOperation;


@Service
public class QqServiceImpl implements IQqService{
	@Autowired
	private QqMapper qqMapper;
	@Autowired
	private QqVMMapper qqVMMapper;

	@Override
	public List<Qq> findAll() throws Exception {
	
      QqExample example = new QqExample();		
		return qqMapper.selectByExample(example);

	}

	@Override
	public Qq findById(long id) throws Exception {
		
		return qqMapper.selectByPrimaryKey(id);
	}
	@Override
	public void saveOrUpdate(Qq qq) throws Exception {
		
		if(qq.getId()!=null){
			//更新
			qqMapper.updateByPrimaryKey(qq);
		}else{
			//插入
			qqMapper.insert(qq);
		}
	}

	@Override
	public void deleteById(long id) throws Exception {
	
		qqMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void batchDelete(Long[] ids) throws Exception {

		for(long id :ids){
			qqMapper.deleteByPrimaryKey(id);
		}
	}

@ApiOperation(value="查询班级信息", notes="班级信息携带年级信息以及班主任信息")
	@Override
	public List<QqVM> selectAllQqVM() throws Exception {
	    return qqVMMapper.selectAll();
	    }

}
