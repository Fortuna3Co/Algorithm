import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

// 백준 2261 가장 가까운 두 점
public class BJ_2261_가장가까운두점 {
    private static Point[] points = null;

    public static int dist(Point args1, Point args2) {
        return (args1.x - args2.x) * (args1.x - args2.x) + (args1.y - args2.y) * (args1.y - args2.y);
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        points = new Point[N];

        for(int n = 0; n < N; ++n){
            String[] input = br.readLine().split(" ");
            points[n] = new Point(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        // x 좌표를 기반으로 정렬
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x - o2.x;
            }
        });

        System.out.println(divide(0, points.length - 1));
    }


    public static int divide(int start, int end) {

        // 기저조건 : 3개 이하일 경우 (2 - 0)
        if(end - start < 3) {
            int distance = Integer.MAX_VALUE;
            for(int cIndex = start; cIndex < end; ++cIndex) {
                for(int index = cIndex + 1; index < end + 1; ++index) {
                    distance = Math.min(distance, dist(points[cIndex], points[index]));
                }
            }
            return distance;
        }

        int mid = (int) (start + end) / 2;
        int minDistance = Integer.MAX_VALUE;
        int leftMinDistance = divide(start, mid);
        int rightMinDistance = divide(mid + 1, end);
        minDistance = Math.min(leftMinDistance, rightMinDistance);

        int middleMinDistance = middleBrute(start, end, mid, minDistance);


        return Math.min(minDistance, middleMinDistance);
    }

    public static int middleBrute(int start, int end, int mid, int minDistance) {

        ArrayList<Point> pointList = new ArrayList<>();
        for(int index = start; index < end + 1; ++index){
            if((points[index].x - points[mid].x) * (points[index].x - points[mid].x) < minDistance) {
                pointList.add(points[index]);
            }
        }

        pointList.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.y - o2.y;
            }
        });

        for(int cIndex = 0; cIndex < pointList.size() - 1; ++cIndex) {
            for(int index = cIndex + 1; index < pointList.size(); ++index) {
                if((pointList.get(cIndex).y - pointList.get(index).y) * (pointList.get(cIndex).y - pointList.get(index).y) < minDistance) {
                    minDistance = Math.min(minDistance, dist(pointList.get(cIndex), pointList.get(index)));
                } else break;
            }
        }

        return minDistance;
    }


}