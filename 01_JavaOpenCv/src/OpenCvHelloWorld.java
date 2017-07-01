import org.opencv.core.*;
//import org.opencv.core.Core;
//import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class OpenCvHelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		Mat image = new Mat(); 	// Resmin tutulacaðý mat nesnesi
		image=Imgcodecs.imread("D:/OpenCvImages/image01.jpg",Imgcodecs.CV_LOAD_IMAGE_ANYCOLOR);		// Resim renkli olarak okunup mat nesnesine atýldý		
		Imgproc.rectangle(image, new Point(0,0),  new Point(399,399),  new Scalar(0,0,255));	// Resmin etrafýna kýrmýzý çerçeve çizildi Opencv de Renk düzeni BlueGreenRed
		Imgproc.putText(image, "Hadi", new Point(0,45), 7, 2, new Scalar(0,0,255));		//Resmin üzerine kýrmýzý yazý yazma 7 opencv nin belirlediði font, 3 ise yazýnýn size deðeri
		Imgcodecs.imwrite("D:/OpenCvImages/image02.png", image);		//Üzeinde deðiþiklik yaptýðýmýz mat nesnesini belirtilen adrese jpg formatýnda kaydetme.
		
		System.out.println("Ýþlem tamamlandý...");
	}

}
