package com.edubridge.Cameraapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edubridge.Cameraapp.model.Camera;
import com.edubridge.Cameraapp.util.DBUtils;

public class CameraDao1 implements CameraDao{
	public static Connection con=null;
	static {
		con=DBUtils.getConnection();
	}

	@Override
	public int addcamera(Camera c) {
		String insert="insert into camera_details(camera_brand,camera_model,storage_capacity) values(?,?,?)";
		int status=0;
		try {
			PreparedStatement ps=con.prepareStatement(insert);
			ps.setString(1,c.getCamera_brand());
			ps.setString(2, c.getCamera_model());
			ps.setString(3, c.getStorage_capacity());
			status=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return status;
	}

	@Override
	public  List<Camera> getAllCamera() {
		List<Camera> Cameras=new ArrayList<>();
		String select="select * from camera_details";
		
		try {
			PreparedStatement pst=con.prepareStatement(select);
			ResultSet rst=pst.executeQuery(select);//
			while(rst.next()) {//
			Camera camera=new Camera();
			camera.setCamera_brand(rst.getString("camera_brand"));
			camera.setCamera_model(rst.getString("camera_model"));
			camera.setStorage_capacity(rst.getString("storage_capacity"));
			Cameras.add(camera);
		}} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return Cameras;
	}

	@Override
	public Camera getCameraByBrand(String camera_brand) {
		Camera cam=new Camera();
		 String sel = "SELECT * FROM camera_details WHERE brand = ?";
		 try {
			PreparedStatement psm=con.prepareStatement(sel);
			ResultSet rsm=psm.executeQuery();
			if(rsm.next()) {
				cam=new Camera();
				cam.setCamera_brand(rsm.getString("camera_brand"));
				cam.setCamera_model(rsm.getString("camera_model"));
				cam.setStorage_capacity(rsm.getString("storage_capacity"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return cam;
	}

	@Override
	public int updateCamera(Camera c) {
		int result=0;
		String update="update camera_details set camera_brand=?,camera_model=? where serial_number=?";
		try {
			PreparedStatement ps2=con.prepareStatement(update);
			ps2.setString(1,c.getCamera_brand());
			ps2.setString(2, c.getCamera_model());
			ps2.setString(3, c.getStorage_capacity());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public void deleteCamera(String camera_brand) {
		String delete="delete from camera_details where camera_brand=?";
		try {
			PreparedStatement ps3=con.prepareStatement(delete);
			ps3.setString(1, camera_brand);
			ps3.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(String camera_brand) {
		String deleteAll="delete from camera_Details";
		try {
			PreparedStatement ps4=con.prepareStatement(deleteAll);
			ps4.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}

}
