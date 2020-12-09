package B4_Class_Object.Bai_Tap;

import java.util.Arrays;
import java.util.Date;

import static java.lang.Math.floor;
import static java.lang.Math.random;

public class StopWatch {
    private Date startTime;
    private Date endTime;


    public void start() {
        startTime = new Date();
    }


    public void stop() {
        endTime = new Date();
    }


    public float getElapsedTime() {
        return this.endTime.getTime() - this.startTime.getTime();
    }


    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        double[] arr1 = new double[500000];
        // create arr 100000 random
        for (int i = 0; i < 500000; i++) {
            arr1[i] = floor(random() * 100) + 1;
        }

        System.out.println("Array before sort");
        System.out.println(Arrays.toString(arr1));
        stopWatch.start();
        Arrays.sort(arr1);
        stopWatch.stop();
        System.out.println("Array after sort");
        System.out.println(Arrays.toString(arr1));
        System.out.printf("Elapsed Time: %.2f ms.", stopWatch.getElapsedTime());
    }
}