import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class OpenCvPixels {
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		Mat array = Imgcodecs.imread("D:/OpenCvImages/image01.jpg",CvType.CV_32S);	//Resmi array dizisine att�k
		Mat newArray = new Mat();
	
		newArray =array.clone();									//Array dizisini new array dizisine clonelad�k boyutlar� ve kanallar� ayn� olmas� i�in	
		//newArray.create(array.rows(),array.cols(),CvType.CV_32S);	 bu �ekilde elle de girebilirdik.
		for(int i=0;i<array.rows();i++) {
			for(int j=0;j<array.cols();j++) {
				 double[] data = array.get(i, j);
				 if(data[0]<200 && data[1]<200 && data[2]<200) {	// her pixel 3 kanall� t�m kanal de�erleri 200den k���kse
					 for(int k=0;k<array.channels();k++) {			// t�m kanallar� 0 yap
						 data[k] = 0 ;								// pixel de�eri 200 den k���k olan renkleri beyaz yapt�k.
					 }	
					 }else {										// Pixel de�eri 200den b�y�k koyu renkli pixellerin
						 for(int k=0;k<array.channels();k++) {		// pixel de�erlerini 255 yap yani siyah
							 data[k] = 255 ;	
						 }
					 }
				newArray.put(i, j, data);							// yeni olu�an de�eri siyah yada beyaz yeni dizide ayn�
																	// ayn� noktaya koy.
			}
		}		
		Imgcodecs.imwrite("D:/OpenCvImages/image06.jpg", newArray);
		System.out.println("��lem Tamamland�...");
	}


}
