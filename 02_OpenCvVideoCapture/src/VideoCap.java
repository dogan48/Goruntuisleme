import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
//import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.*;
public class VideoCap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		VideoCapture videoCam = new VideoCapture();
		//videoCam.set(Videoio.CV_CAP_PROP_FRAME_WIDTH, 800);
		//videoCam.set(Videoio.CV_CAP_PROP_FRAME_HEIGHT, 450);
		
		videoCam.open(0);
		
		Mat videoFrame = new Mat();
		if(videoCam.isOpened())
		{
			videoCam.read(videoFrame);
			Imgcodecs.imwrite("D:/OpenCvImages/image03.jpg", videoFrame);
			videoCam.release();

			System.out.println("Resim baþarý ile kaydedildi...");
			
			
		}else
		{
			System.out.println("Baðlantý Hatasý...");
			
		}

	}

}
