package kr.co.three.common;
//

//import java.awt.Graphics2D;
//import java.awt.Image;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Random;
//import java.util.stream.Collectors;
//
//import javax.imageio.ImageIO;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.web.multipart.MultipartFile;
//
//import kr.co.three.member.dto.MemberDTO;
//import kr.co.three.sales.dto.SalesDTO;
//
//public class UploadFile {
//	private static final String UPLOAD_PATH = "C:\\Users\\tmddu\\git\\ReturnProject\\ReturnProject\\src\\main\\webapp\\resources\\uploads\\";
//
//	public static boolean deleteFile(String fileName) {
//		File file1 = new File(UPLOAD_PATH + "110x150\\" + fileName);
//		File file2 = new File(UPLOAD_PATH + "121x96\\" + fileName);
//		File file3 = new File(UPLOAD_PATH + "194x194\\" + fileName);
//		File file4 = new File(UPLOAD_PATH + "428x428\\" + fileName);
//		File file5 = new File(UPLOAD_PATH + "66x66\\" + fileName);
//		File file6 = new File(UPLOAD_PATH + "303x310\\" + fileName);
//		File file7 = new File(UPLOAD_PATH + fileName);
//
//		boolean deleted1 = file1.delete();
//		boolean deleted2 = file2.delete();
//		boolean deleted3 = file3.delete();
//		boolean deleted4 = file4.delete();
//		boolean deleted5 = file5.delete();
//		boolean deleted6 = file6.delete();
//		boolean deleted7 = file7.delete();
//
//		return deleted1 || deleted2 || deleted3 || deleted4 || deleted5 || deleted6 || deleted7;
//	}
//
////	판매 이미지
//	public static void uploadMethod(MultipartFile upload, SalesDTO sales, HttpSession session) {
//
//		if (!upload.isEmpty()) {
//			// 원본 파일명 구하기
//			String originName = upload.getOriginalFilename();
//
//			// 확장자 구하기
//			String extension = originName.substring(originName.lastIndexOf("."));
//
//			// 현재 년-월-일-시-분-초
//			LocalDateTime nowDate = LocalDateTime.now();
//
//			// 데이터포맷을 년월일시분초로 가공
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmmss");
//			String output = nowDate.format(formatter);
//
//			// 랜덤 문자열 생성
//			int length = 8;
//			String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
//
//			Random random = new Random();
//			String randomString = random.ints(length, 0, characters.length()) // 길이가 length인 난수 생성
//					.mapToObj(characters::charAt) // 각 난수들을 characters에서 해당하는 문자의 인덱스로 매핑
//					.map(Object::toString) // 위의 문자를 문자열로 변환
//					.collect(Collectors.joining()); // 문자열 스트림을 하나의 문자열로 변환
//
//			// 파일명 : 날짜_랜덤문자열.확장자
//			// 231229144025_aK834NNM.png
//			String fileName = (output + "_" + randomString + extension);
//
//			// 경로+파일명
//			// RESIZED_PATH : C:\\spring\\Project\\src\\main\\webapp\\resources\\uploads\\
//			// path : info\\
//			// fileName : 231229144025_aK834NNM.png
//			// C:\\spring\\Project\\src\\main\\webapp\\resources\\uploads\\info\\231229144025_aK834NNM.png
//			String filePathName = UPLOAD_PATH + fileName;
//
//			// 서버에 원본 파일 저장
//			Path filePath = Paths.get(filePathName);
//
//			try {
//				upload.transferTo(filePath);
//
//				// 리사이징된 이미지 저장
//				// 110x150
//				String resizedPathName1 = UPLOAD_PATH + "110x150\\" + fileName;
//				Path resizedFilePath = Paths.get(resizedPathName1);
//
//				BufferedImage originalImage = ImageIO.read(filePath.toFile());
//				int targetWidth = 110; // 리사이징할 가로 크기
//				int targetHeight = 150; // 리사이징할 세로 크기
//				BufferedImage resizedImage = resizeImage(originalImage, targetWidth, targetHeight);
//
//				ImageIO.write(resizedImage, extension.substring(1), resizedFilePath.toFile());
//
//				sales.setSalesImagePath(UPLOAD_PATH + "110x150\\"); // 리사이징된 이미지의 경로
//				sales.setSalesImageName(fileName); // 수정된 파일명
//				sales.setSalesOriginImageName(originName);
//
//				// 194x194
//				String resizedPathName2 = UPLOAD_PATH + "194x194\\" + fileName;
//				Path resizedFilePath2 = Paths.get(resizedPathName2);
//
//				BufferedImage originalImage2 = ImageIO.read(filePath.toFile());
//				int targetWidth2 = 194; // 리사이징할 가로 크기
//				int targetHeight2 = 194; // 리사이징할 세로 크기
//				BufferedImage resizedImage2 = resizeImage(originalImage2, targetWidth2, targetHeight2);
//
//				ImageIO.write(resizedImage2, extension.substring(1), resizedFilePath2.toFile());
//
//				sales.setSalesImagePath(UPLOAD_PATH + "194x194\\"); // 리사이징된 이미지의 경로
//				sales.setSalesImageName(fileName); // 수정된 파일명
//				sales.setSalesOriginImageName(originName);
//
//				// 428x428
//				String resizedPathName3 = UPLOAD_PATH + "428x428\\" + fileName;
//				Path resizedFilePath3 = Paths.get(resizedPathName3);
//
//				BufferedImage originalImage3 = ImageIO.read(filePath.toFile());
//				int targetWidth3 = 428; // 리사이징할 가로 크기
//				int targetHeight3 = 428; // 리사이징할 세로 크기
//				BufferedImage resizedImage3 = resizeImage(originalImage3, targetWidth3, targetHeight3);
//
//				ImageIO.write(resizedImage3, extension.substring(1), resizedFilePath3.toFile());
//
//				sales.setSalesImagePath(UPLOAD_PATH + "428x428\\"); // 리사이징된 이미지의 경로
//				sales.setSalesImageName(fileName); // 수정된 파일명
//				sales.setSalesOriginImageName(originName);
//
//				// 121x96
//				String resizedPathName4 = UPLOAD_PATH + "121x96\\" + fileName;
//				Path resizedFilePath4 = Paths.get(resizedPathName4);
//
//				BufferedImage originalImage4 = ImageIO.read(filePath.toFile());
//				int targetWidth4 = 121; // 리사이징할 가로 크기
//				int targetHeight4 = 96; // 리사이징할 세로 크기
//				BufferedImage resizedImage4 = resizeImage(originalImage4, targetWidth4, targetHeight4);
//
//				ImageIO.write(resizedImage4, extension.substring(1), resizedFilePath4.toFile());
//
//				sales.setSalesImagePath(UPLOAD_PATH + "121x96\\"); // 리사이징된 이미지의 경로
//				sales.setSalesImageName(fileName); // 수정된 파일명
//				sales.setSalesOriginImageName(originName);
//
//				// 66x66
//				String resizedPathName5 = UPLOAD_PATH + "66x66\\" + fileName;
//				Path resizedFilePath5 = Paths.get(resizedPathName5);
//
//				BufferedImage originalImage5 = ImageIO.read(filePath.toFile());
//				int targetWidth5 = 66; // 리사이징할 가로 크기
//				int targetHeight5 = 66; // 리사이징할 세로 크기
//				BufferedImage resizedImage5 = resizeImage(originalImage5, targetWidth5, targetHeight5);
//
//				ImageIO.write(resizedImage5, extension.substring(1), resizedFilePath5.toFile());
//
//				sales.setSalesImagePath(UPLOAD_PATH + "66x66\\"); // 리사이징된 이미지의 경로
//				sales.setSalesImageName(fileName); // 수정된 파일명
//				sales.setSalesOriginImageName(originName);
//
//				// 303x310
//				String resizedPathName6 = UPLOAD_PATH + "303x310\\" + fileName;
//				Path resizedFilePath6 = Paths.get(resizedPathName6);
//
//				BufferedImage originalImage6 = ImageIO.read(filePath.toFile());
//				int targetWidth6 = 303; // 리사이징할 가로 크기
//				int targetHeight6 = 310; // 리사이징할 세로 크기
//				BufferedImage resizedImage6 = resizeImage(originalImage6, targetWidth6, targetHeight6);
//
//				ImageIO.write(resizedImage6, extension.substring(1), resizedFilePath5.toFile());
//
//				sales.setSalesImagePath(UPLOAD_PATH + "303x310\\"); // 리사이징된 이미지의 경로
//				sales.setSalesImageName(fileName); // 수정된 파일명
//				sales.setSalesOriginImageName(originName);
//
//			} catch (IllegalStateException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
////	멤버 이미지
//	public static void uploadMethod(MultipartFile upload, MemberDTO member, HttpSession session) {
//
//		if (!upload.isEmpty()) {
//			// 원본 파일명 구하기
//			String originName = upload.getOriginalFilename();
//
//			// 확장자 구하기
//			String extension = originName.substring(originName.lastIndexOf("."));
//
//			// 현재 년-월-일-시-분-초
//			LocalDateTime nowDate = LocalDateTime.now();
//
//			// 데이터포맷을 년월일시분초로 가공
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmmss");
//			String output = nowDate.format(formatter);
//
//			// 랜덤 문자열 생성
//			int length = 8;
//			String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
//
//			Random random = new Random();
//			String randomString = random.ints(length, 0, characters.length()) // 길이가 length인 난수 생성
//					.mapToObj(characters::charAt) // 각 난수들을 characters에서 해당하는 문자의 인덱스로 매핑
//					.map(Object::toString) // 위의 문자를 문자열로 변환
//					.collect(Collectors.joining()); // 문자열 스트림을 하나의 문자열로 변환
//
//			// 파일명 : 날짜_랜덤문자열.확장자
//			// 231229144025_aK834NNM.png
//			String fileName = (output + "_" + randomString + extension);
//
//			// 경로+파일명
//			// RESIZED_PATH : C:\\spring\\Project\\src\\main\\webapp\\resources\\uploads\\
//			// path : info\\
//			// fileName : 231229144025_aK834NNM.png
//			// C:\\spring\\Project\\src\\main\\webapp\\resources\\uploads\\info\\231229144025_aK834NNM.png
//			String filePathName = UPLOAD_PATH + fileName;
//
//			// 서버에 원본 파일 저장
//			Path filePath = Paths.get(filePathName);
//
//			try {
//				upload.transferTo(filePath);
//
//				// 303x310
//				String resizedPathName6 = UPLOAD_PATH + "303x310\\" + fileName;
//				Path resizedFilePath6 = Paths.get(resizedPathName6);
//
//				BufferedImage originalImage6 = ImageIO.read(filePath.toFile());
//				int targetWidth6 = 303; // 리사이징할 가로 크기
//				int targetHeight6 = 310; // 리사이징할 세로 크기
//				BufferedImage resizedImage6 = resizeImage(originalImage6, targetWidth6, targetHeight6);
//
//				ImageIO.write(resizedImage6, extension.substring(1), resizedFilePath6.toFile());
//
//				member.setMemberImagePath(UPLOAD_PATH + "303x310\\"); // 리사이징된 이미지의 경로
//				member.setMemberImageName(fileName); // 수정된 파일명
//				member.setMemberOriginImageName(originName);
//
//			} catch (IllegalStateException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//	public static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
//		Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
//		BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
//		Graphics2D graphics2D = outputImage.createGraphics();
//		graphics2D.drawImage(resultingImage, 0, 0, null);
//		graphics2D.dispose();
//		return outputImage;
//	}
//}

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import kr.co.three.member.dto.MemberDTO;
import kr.co.three.sales.dto.SalesDTO;

public class UploadFile {
	private static final String UPLOAD_PATH = "C:\\Users\\tmddu\\git\\ReturnProject\\ReturnProject\\src\\main\\webapp\\resources\\uploads\\";

	public static boolean deleteFile(String fileName) {
		File file1 = new File(UPLOAD_PATH + "110x150\\" + fileName);
		File file2 = new File(UPLOAD_PATH + "121x96\\" + fileName);
		File file3 = new File(UPLOAD_PATH + "194x194\\" + fileName);
		File file4 = new File(UPLOAD_PATH + "428x428\\" + fileName);
		File file5 = new File(UPLOAD_PATH + "66x66\\" + fileName);
		File file6 = new File(UPLOAD_PATH + "303x310\\" + fileName);
		File file7 = new File(UPLOAD_PATH + fileName);

		boolean deleted1 = file1.delete();
		boolean deleted2 = file2.delete();
		boolean deleted3 = file3.delete();
		boolean deleted4 = file4.delete();
		boolean deleted5 = file5.delete();
		boolean deleted6 = file6.delete();
		boolean deleted7 = file7.delete();

		return deleted1 || deleted2 || deleted3 || deleted4 || deleted5 || deleted6 || deleted7;
	}

	public static void uploadMethod(List<MultipartFile> uploads, Object dto, HttpSession session) {
		for (MultipartFile upload : uploads) {
			if (!upload.isEmpty()) {
				String originName = upload.getOriginalFilename();
				String extension = originName.substring(originName.lastIndexOf("."));

				LocalDateTime nowDate = LocalDateTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmmss");
				String output = nowDate.format(formatter);

				int length = 8;
				String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

				Random random = new Random();
				String randomString = random.ints(length, 0, characters.length()).mapToObj(characters::charAt)
						.map(Object::toString).collect(Collectors.joining());

				String fileName = (output + "_" + randomString + extension);
				String filePathName = UPLOAD_PATH + fileName;
				Path filePath = Paths.get(filePathName);

				try {
					upload.transferTo(filePath);

					BufferedImage originalImage = ImageIO.read(filePath.toFile());
					BufferedImage resizedImage = resizeImage(originalImage, 303, 310);

					String resizedPathName = UPLOAD_PATH + "303x310\\" + fileName;
					Path resizedFilePath = Paths.get(resizedPathName);
					ImageIO.write(resizedImage, extension.substring(1), resizedFilePath.toFile());

					// Update DTO according to its type
					if (dto instanceof SalesDTO) {
						SalesDTO sales = (SalesDTO) dto;
						sales.setSalesImagePath(UPLOAD_PATH + "303x310\\");
						sales.setSalesImageName(fileName);
						sales.setSalesOriginImageName(originName);
					} else if (dto instanceof MemberDTO) {
						MemberDTO member = (MemberDTO) dto;
						member.setMemberImagePath(UPLOAD_PATH + "303x310\\");
						member.setMemberImageName(fileName);
						member.setMemberOriginImageName(originName);
					}

					// Resize and save images in other directories
					resizeAndSaveImage(originalImage, 110, 150, UPLOAD_PATH + "110x150\\" + fileName);
					resizeAndSaveImage(originalImage, 121, 96, UPLOAD_PATH + "121x96\\" + fileName);
					resizeAndSaveImage(originalImage, 194, 194, UPLOAD_PATH + "194x194\\" + fileName);
					resizeAndSaveImage(originalImage, 428, 428, UPLOAD_PATH + "428x428\\" + fileName);
					resizeAndSaveImage(originalImage, 66, 66, UPLOAD_PATH + "66x66\\" + fileName);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
		Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
		BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2D = outputImage.createGraphics();
		graphics2D.drawImage(resultingImage, 0, 0, null);
		graphics2D.dispose();
		return outputImage;
	}

	public static void resizeAndSaveImage(BufferedImage originalImage, int targetWidth, int targetHeight,
			String filePathName) throws IOException {
		BufferedImage resizedImage = resizeImage(originalImage, targetWidth, targetHeight);
		Path resizedFilePath = Paths.get(filePathName);
		String extension = filePathName.substring(filePathName.lastIndexOf("."));
		ImageIO.write(resizedImage, extension.substring(1), resizedFilePath.toFile());
	}
}
