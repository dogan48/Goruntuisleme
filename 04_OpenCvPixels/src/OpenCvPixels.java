import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class OpenCvPixels {
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		Mat array = Imgcodecs.imread("D:/OpenCvImages/image01.jpg",CvType.CV_32S);	//Resmi array dizisine attýk
		Mat newArray = new Mat();
	
		newArray =array.clone();									//Array dizisini new array dizisine cloneladýk boyutlarý ve kanallarý ayný olmasý için	
		//newArray.create(array.rows(),array.cols(),CvType.CV_32S);	 bu þekilde elle de girebilirdik.
		for(int i=0;i<array.rows();i++) {
			for(int j=0;j<array.cols();j++) {
				 double[] data = array.get(i, j);
				 if(data[0]<200 && data[1]<200 && data[2]<200) {	// her pixel 3 kanallý tüm kanal deðerleri 200den küçükse
					 for(int k=0;k<array.channels();k++) {			// tüm kanallarý 0 yap
						 data[k] = 0 ;								// pixel deðeri 200 den küçük olan renkleri beyaz yaptýk.
					 }	
					 }else {										// Pixel deðeri 200den büyük koyu renkli pixellerin
						 for(int k=0;k<array.channels();k++) {		// pixel deðerlerini 255 yap yani siyah
							 data[k] = 255 ;	
						 }
					 }
				newArray.put(i, j, data);							// yeni oluþan deðeri siyah yada beyaz yeni dizide ayný
																	// ayný noktaya koy.
			}
		}		
		Imgcodecs.imwrite("D:/OpenCvImages/image06.jpg", newArray);
		System.out.println("Ýþlem Tamamlandý...");
	}


}
