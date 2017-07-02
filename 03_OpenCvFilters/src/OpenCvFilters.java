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
			
			//Imgproc.erode(orjImage, newImage, kernel);		// A��nd�rma i�lemi yap�yor...
			//Imgproc.dilate(orjImage, newImage, kernel);		// Pixelleri geni�letme i�lemi yap�yor...
			//Imgproc.Canny(orjImage, newImage, 700, 300);		// Resmi siyah beyaza cevirir kenarlar� beyaz di�er yerler siyah
			//Imgproc.blur(orjImage, newImage, new Size(2,2));	// Resme blur efekti uygular verdi�imiz Size de�erine g�re
			
			Imgproc.threshold(orjImage, newImage, 127, 255, Imgproc.THRESH_BINARY);	// Resmin koyu olan yerlerini siyaha
																					// a��k olan yerlerini beyaza �eker 
																					//BINARY, BINARY_INV, TOZERO,TOZERO_INV gibi parametreleri var 
			Core.flip(orjImage, newImage,1);					// Resmi d�nd�r�r verilecek de�er >0  <0  ve ==0 olabilir.
			
																					
			
			
			Imgcodecs.imwrite("D:/OpenCvImages/image02.jpg", newImage);
			System.out.println("��lem tamamland�...");
		}
		catch (Exception e) {
			
			System.out.println("Bir hata olu�tu... \n Hata Kodu: "+ e.getMessage());
			
		}
		
	}

}
