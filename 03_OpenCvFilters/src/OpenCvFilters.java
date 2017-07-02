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
			
			//Imgproc.erode(orjImage, newImage, kernel);		// Aþýndýrma iþlemi yapýyor...
			//Imgproc.dilate(orjImage, newImage, kernel);		// Pixelleri geniþletme iþlemi yapýyor...
			//Imgproc.Canny(orjImage, newImage, 700, 300);		// Resmi siyah beyaza cevirir kenarlarý beyaz diðer yerler siyah
			//Imgproc.blur(orjImage, newImage, new Size(2,2));	// Resme blur efekti uygular verdiðimiz Size deðerine göre
			
			Imgproc.threshold(orjImage, newImage, 127, 255, Imgproc.THRESH_BINARY);	// Resmin koyu olan yerlerini siyaha
																					// açýk olan yerlerini beyaza çeker 
																					//BINARY, BINARY_INV, TOZERO,TOZERO_INV gibi parametreleri var 
			Core.flip(orjImage, newImage,1);					// Resmi döndürür verilecek deðer >0  <0  ve ==0 olabilir.
			
																					
			
			
			Imgcodecs.imwrite("D:/OpenCvImages/image02.jpg", newImage);
			System.out.println("Ýþlem tamamlandý...");
		}
		catch (Exception e) {
			
			System.out.println("Bir hata oluþtu... \n Hata Kodu: "+ e.getMessage());
			
		}
		
	}

}
