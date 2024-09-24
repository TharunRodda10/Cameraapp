package com.edubridge.Cameraapp;

import java.util.List;
import java.util.Scanner;

import com.edubridge.Cameraapp.model.Camera;
import com.edubridge.Cameraapp.service.CameraService1;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CameraService1 service=new CameraService1();
        try (Scanner in = new Scanner(System.in)) {
			while(true) {
				  System.out.println("MY CAMERA APPLICATION");
				   System.out.println("************************");
				   System.out.println("1.Add CAMERA");
				   System.out.println("2.DISPLAY ALL CAMERAS");
				   System.out.println("3.search CAMERA BY NAME");
				   System.out.println("4.update CAMERA ");
				   System.out.println("5.Delete CAMERA");
				   System.out.println("5.Delete ALL CAMERA");
				   System.out.println("0.exit");
				   System.out.println("Please Choose option");
				   int option=in.nextInt();
				   in.nextLine();//consume the newline character
				   switch(option) {
				   case 1:
					   System.out.println("ADD CAMERA");
					   System.out.println("Enter Camera Brand ");
					   String camera_brand=in.next();
					   System.out.println("Enter Camera Model");
					   String camera_model=in.next();
					   System.out.println("Enter Storage Capacity");
					   String storage_capacity=in.next();
					   Camera newcamera=new Camera();
					   newcamera.setCamera_brand(camera_brand);
					   newcamera.setCamera_model(camera_model);
					   newcamera.setStorage_capacity(storage_capacity);
					   int status=service.addcamera(newcamera);
					   if(status>=1) {
						   System.out.println("NEW CAMERA ADDED SUCCESSFULLY!!!");
						   
					   }else {
						   System.out.println("NOT ADDED OR UNSUCCESSFULL");
					   }
					   break;
				   case 2:
					   System.out.println("DISPLAY CAMERA");
					   List<Camera> cameras=service.getAllCamera();
					   for(Camera c:cameras) {
						   System.out.println(c.getCamera_brand()+"/t"+c.getCamera_model()+"/t"+c.getStorage_capacity());
					   }
					   break;
				   case 3:
					   System.out.println("SEARCH CAMERA BY NAME");
					   String result=in.nextLine();
					   Camera cam1=service.getCameraByBrand(result);
					   if(result!=null) {
						   System.out.println(cam1.toString()+"/t"+cam1.getCamera_brand()+"/t"+cam1.getCamera_model()+"/t"+cam1.getStorage_capacity());
					   }
					   break;
					   
				   case 4:
					   System.out.println("UPDATE CAMERA");
					   String updatecamera=in.nextLine();
					   Camera oldcameraname=service.getCameraByBrand(updatecamera);
					   if(oldcameraname== null) {
						   System.out.println("Camera not Found!");
						   System.out.println("Enter new camera brand");
						   String newbrand=in.nextLine();
						   System.out.println("enter new camera model");
						   String newmodel=in.nextLine();
						   oldcameraname.setCamera_brand(newbrand);
						   oldcameraname.setCamera_model(newmodel);
						   int updatestatus=service.updateCamera(oldcameraname);
						   
					   }
					  
					   break;
				   case 5:
					   System.out.println("DELETE CAMERA BY CAMERA BRAND");
					   String deletebrand=in.nextLine();
					   service.deleteCamera(deletebrand);					   
					   break;
				   case 6:
					   System.out.println("Delete ALL CAMERA");
					   String deleteall=in.nextLine();
					   service.deleteAll(deleteall);
					   break;
				   case 0:
					   System.out.println("EXIT");
					   System.exit(option);
					   break;
					default :
					   System.out.println("INVALID OR NO INPUT IS GIVEN"); 
				   
				   }
			}
		}
    }
}
