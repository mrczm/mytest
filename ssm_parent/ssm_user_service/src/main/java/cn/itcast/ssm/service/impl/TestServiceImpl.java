package cn.itcast.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.ssm.mapper.TestMapper;
import cn.itcast.ssm.service.TestService;

@Service
@Transactional
public class TestServiceImpl implements TestService {
	@Autowired
	private TestMapper testMapper;

	public String test() {
		return testMapper.test();
	}

}
