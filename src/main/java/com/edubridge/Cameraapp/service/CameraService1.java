package com.edubridge.Cameraapp.service;

import java.util.List;

import com.edubridge.Cameraapp.dao.CameraDao;
import com.edubridge.Cameraapp.dao.CameraDao1;
import com.edubridge.Cameraapp.model.Camera;

public class CameraService1 implements CameraService {
	private CameraDao dao;
	public CameraService1() {
		dao=new CameraDao1();
	}

	@Override
	public int addcamera(Camera c) {
		// TODO Auto-generated method stub
		return dao.addcamera(c);
	}

	@Override
	public List<Camera> getAllCamera() {
		// TODO Auto-generated method stub
		return dao.getAllCamera();
	}

	@Override
	public Camera getCameraByBrand(String camera_brand) {
		// TODO Auto-generated method stub
		return dao.getCameraByBrand(camera_brand);
	}

	@Override
	public int updateCamera(Camera c) {
		// TODO Auto-generated method stub
		return dao.updateCamera(c);
	}

	@Override
	public void deleteCamera(String camera_brand) {
		// TODO Auto-generated method stub
		return;
		
	}

	@Override
	public void deleteAll(String camera_brand) {
		// TODO Auto-generated method stub
		return;
		
	}

}
