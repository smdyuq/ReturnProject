package kr.co.three.common;

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
	private static final String UPLOAD_PATH = "C:\\Users\\jaeyun\\git\\ReturnProject\\ReturnProject\\src\\main\\webapp\\resources\\uploads\\";

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

	public static void uploadMethod(MultipartFile upload, Object dto, HttpSession session) {
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
					sales.setImagePath(UPLOAD_PATH + "303x310\\");
					sales.setImageName(fileName);
					sales.setOriginImageName(originName);
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