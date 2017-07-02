import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
public class OpenCvFilters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
			Mat orjImage = Imgcodecs.imread("D:/OpenCvImages/image01.jpg",Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);
			Mat newImage = new Mat();
			Mat kernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(2,2));
			
			//Imgproc.erode(orjImage, newImage, kernel);		// Aşındırma işlemi yapıyor...
			//Imgproc.dilate(orjImage, newImage, kernel);		// Pixelleri genişletme işlemi yapıyor...
			//Imgproc.Canny(orjImage, newImage, 700, 300);		// Resmi siyah beyaza cevirir kenarları beyaz diğer yerler siyah
			//Imgproc.blur(orjImage, newImage, new Size(2,2));	// Resme blur efekti uygular verdiğimiz Size değerine göre
			
			Imgproc.threshold(orjImage, newImage, 127, 255, Imgproc.THRESH_BINARY);	// Resmin koyu renkli olan yerlerini siyaha
												// açık renkli olan yerlerini beyaza çeker 
												// BINARY, BINARY_INV, TOZERO,TOZERO_INV gibi parametreleri var 
			Core.flip(orjImage, newImage,1);					// Resmi döndürür verilecek değer >0  <0  ve ==0 olabilir.
			
																					
			
			
			Imgcodecs.imwrite("D:/OpenCvImages/image02.jpg", newImage);
			System.out.println("İşlem tamamlandı...");
		}
		catch (Exception e) {
			
			System.out.println("Bir hata oluştu... \n Hata Kodu: "+ e.getMessage());
			
		}
		
	}

}
