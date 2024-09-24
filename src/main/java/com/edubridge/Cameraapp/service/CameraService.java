package com.edubridge.Cameraapp.service;

import java.util.List;

import com.edubridge.Cameraapp.model.Camera;

public interface CameraService {
	int addcamera(Camera c);
	List<Camera>getAllCamera();
	Camera getCameraByBrand(String camera_brand);
	int updateCamera(Camera c);
	void deleteCamera(String camera_brand);
	void deleteAll(String camera_brand);

}
