import org.opencv.core.*;
import org.opencv.core.Core.MinMaxLocResult;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class OpenCvTemplateMatching {
	
	public static void main(String args[]) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat source = null;
		Mat template = null;
		String filePath = "D:/OpenCvImages/";				//Resimlerin bulundu�u dosya yolu
		source=Imgcodecs.imread(filePath+"image02.jpg");		// Kaynak Resim
		template=Imgcodecs.imread(filePath+"image03.jpg");			//Aranacak template
		
		Mat outputImage = new Mat();									//Sonuclar�n tutlaca�� mat nesnesi
		int matchMethod=Imgproc.TM_CCOEFF;									// Template Matchin y�ntemi
		
		Imgproc.matchTemplate(source, template, outputImage, matchMethod);		//Template Matching ��lemi
		MinMaxLocResult mmr = Core.minMaxLoc(outputImage);							//Bulunan sonuclar�n konumlar�.
		
		Point matchLoc = mmr.maxLoc;
		
		// Bulunan sonucun etraf�na k�rm�z� dikd�rtgen �izme i�lemi
		Imgproc.rectangle(source, matchLoc, new Point( matchLoc.x + template.cols(), matchLoc.y+template.rows() ), new Scalar(0,0,255));
		
		Imgcodecs.imwrite(filePath+"sonuc.jpg", source);		//Sonucu kaydetme i�lemi.
		
		System.out.println("��lem Tamamland�...");
		
	}

}
