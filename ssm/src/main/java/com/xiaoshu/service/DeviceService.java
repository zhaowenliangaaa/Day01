package com.xiaoshu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.xiaoshu.dao.DeviceMapper;
import com.xiaoshu.dao.UserMapper;
import com.xiaoshu.entity.Device;
import com.xiaoshu.entity.User;
import com.xiaoshu.entity.UserExample;
import com.xiaoshu.entity.UserExample.Criteria;

@Service
public class DeviceService {

	@Autowired
	DeviceMapper deviceMapper;

	public PageInfo<Device> findUserPage(Device device, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		List<Device> deviceList = deviceMapper.queryDevice(device);
		PageInfo<Device> pageInfo = new PageInfo<Device>(deviceList);
		return pageInfo;
	}
	
	
	//添加
	public void addDevice(Device device){
		device.setCreatetime(new Date());
		deviceMapper.insert(device);
	}
	
	//修改
	public void updateDevice(Device device){
		device.setCreatetime(new Date());
		deviceMapper.updateByPrimaryKey(device);
	}
	
	
	//删除
	public void deleteDevice(Integer id){
		deviceMapper.deleteByPrimaryKey(id);
	}


}
