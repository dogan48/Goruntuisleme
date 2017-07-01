import org.opencv.core.*;
//import org.opencv.core.Core;
//import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class OpenCvHelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		Mat image = new Mat(); 	// Resmin tutulaca�� mat nesnesi
		image=Imgcodecs.imread("D:/OpenCvImages/image01.jpg",Imgcodecs.CV_LOAD_IMAGE_ANYCOLOR);		// Resim renkli olarak okunup mat nesnesine at�ld�		
		Imgproc.rectangle(image, new Point(0,0),  new Point(399,399),  new Scalar(0,0,255));	// Resmin etraf�na k�rm�z� �er�eve �izildi Opencv de Renk d�zeni BlueGreenRed
		Imgproc.putText(image, "Hadi", new Point(0,45), 7, 2, new Scalar(0,0,255));		//Resmin �zerine k�rm�z� yaz� yazma 7 opencv nin belirledi�i font, 3 ise yaz�n�n size de�eri
		Imgcodecs.imwrite("D:/OpenCvImages/image02.png", image);		//�zeinde de�i�iklik yapt���m�z mat nesnesini belirtilen adrese jpg format�nda kaydetme.
		
		System.out.println("��lem tamamland�...");
	}

}
