package com.jjb.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;

import org.springframework.util.FileCopyUtils;


public class UploadFileUtils {
	public static String profileFile(String uploadPath, String originalName, byte[] fileData) throws Exception{
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString()+"_"+originalName;
		String savedPath = File.separator+"profile";
		//uploadPath+savedPath 라는 이름을 가진 폴더안에 savedName 파일을 생성
		File target = new File(uploadPath+savedPath, savedName);
		//파일 입출력을 담당 : fileData 파일을 만드는데 필요한 정보, target 이러한 형식으로 밖으로 보내겠다 
		FileCopyUtils.copy(fileData,  target);
		
		String formatName = originalName.substring(originalName.lastIndexOf(".")+1);//끝에서부터 .을 찾아서 그 위치를 반환(+1을 함으로서 뒤에 jpg라는 것만 남음) -> 파일의 종류를 알기 위함
		
		String uploadedFileName= null;
		//System.out.println("썸네일 확인용"+MimeMediaUtil.getMediaType(formatName));
		
		uploadedFileName = makeIcon(uploadPath, savedPath, savedName);
		
		
		return uploadedFileName;
	}
	//uploadPath : servlet-context.xml에 설정한 업로드를 위한 경로
	public static String uploadFile(String uploadPath, String originalName, byte[] fileData) throws Exception{
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString()+"_"+originalName;
		String savedPath = calcPath(uploadPath);
		//uploadPath+savedPath 라는 이름을 가진 폴더안에 savedName 파일을 생성
		File target = new File(uploadPath+savedPath, savedName);
		//파일 입출력을 담당 : fileData 파일을 만드는데 필요한 정보, target 이러한 형식으로 밖으로 보내겠다 
		FileCopyUtils.copy(fileData,  target);
		
		String formatName = originalName.substring(originalName.lastIndexOf(".")+1);//끝에서부터 .을 찾아서 그 위치를 반환(+1을 함으로서 뒤에 jpg라는 것만 남음) -> 파일의 종류를 알기 위함
		
		String uploadedFileName= null;
		//System.out.println("썸네일 확인용"+MimeMediaUtil.getMediaType(formatName));
		
		uploadedFileName = makeIcon(uploadPath, savedPath, savedName);
		
		
		return uploadedFileName;
	}
	
	private static String calcPath(String uploadPath) {
		
		Calendar cal = Calendar.getInstance(); // Calendar클래스에서 날짜를 가져오는 메소드
		String yearPath = File.separator+cal.get(Calendar.YEAR);// -> /2020
		String monthPath = yearPath+
				File.separator+
				new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);// DecimalFormat은 2자리를 채우는 것(빈자리를 0으로 채워서 .format으로 적용 후 출력) , 1월은 0이기 때문에 +1 -> /2020/01
		String datePath = monthPath+
				File.separator+
				new DecimalFormat("00").format(cal.get(Calendar.DATE));// -> /2020/01/07
		
		makeDir(uploadPath,yearPath,monthPath,datePath);//폴더 만들기 위한 메소드
		System.out.println("datepath = "+datePath);
		
		return datePath;
	}
	
	private static void makeDir(String uploadPath, String... paths) {//String... 가변배열 -> 배열의 정확한 길이를 모를 때 사용
		
		if(new File(paths[paths.length-1]).exists()) {//똑같은 폴더가 있으면 리턴해서 넘김
			return;
		}
		
		for(String path : paths) {//paths의 개수만큼 만듦
			File dirPath = new File(uploadPath+path);
			
			if(! dirPath.exists()) {//exists 존재여부 확인용
				dirPath.mkdir();//똑같은 폴더가 없으면 폴더를 만들어라
			}
		}
	}
	
	private static String makeThumbnail(String uploadPath, String path, String fileName) throws Exception{
		
		//BufferedImage 썸네일 만들때 주로 사용(원본이미지 -> buffer(임시 지억장치:원본이미지를 임시로 만든 다음) -> 썸네일 이미지로 변환 )
		BufferedImage sourceImg = ImageIO.read(new File(uploadPath + path, fileName));//ImageIO에서 읽어 들인다음 buffer쪽에 임시 저장
		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT,100);//썸네일을 높이 100으로 바꿔서 저장
		
		String thumbnailName = uploadPath + path + File.separator + "s_"+ fileName;//썸네일 이름을 s_ 붙여서 저장
		
		File newFile = new File(thumbnailName);
		String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
		
		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
		
		return thumbnailName.substring(uploadPath.length()).replace(File.separator, "/");//replace 치환해주는 함수(File.separator \이고 replace로 \를 /로 바꿔줌 -> 웹에서 인식시키기 위함)
	}
	
	private static String makeIcon(String uploadPath, String path, String fileName) throws Exception{
		
		String iconName = uploadPath + path + File.separator + fileName;
		
		return iconName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}
}
