package Day_0803;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BJ_1753_최단경로_강혜성 {
	
	private static ArrayList<Node>[] list;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int V = Integer.parseInt(line[0]), E = Integer.parseInt(line[1]);
		int startIndex = Integer.parseInt(br.readLine());
		
		int distance[] = new int[V + 1];
		for(int n = 1; n <= V; ++n) {
			list[n] = new ArrayList<>(); 	// w의 경우 10이하 자연수 // INF
		}
		
		// 간선 입력, 단방향
		for (int index = 0; index < V; ++index) {
			line = br.readLine().split(" ");
			int u = Integer.parseInt(line[0]), v =Integer.parseInt(line[1]), w = Integer.parseInt(line[2]);	// w의 경우 10이하 자연 수
			list[u].add(new Node(v, w));
		}
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		dijkstra(startIndex, distance);		// 다익스트라 알고리즘
		
		for (int index = 1; index <= V; ++index) {
			if (distance[index] == Integer.MAX_VALUE)
				System.out.println("INF");
			else System.out.println(distance[index]);
		}
		
	}
	
	private static void dijkstra(int startIndex, int[] distance) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(startIndex, 0));
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int vertex = node.vertex;
			int weight = node.weight;
			
			if (distance[vertex] < weight)
				continue;
			
			for(int index = 0; index < list[vertex].size(); ++index) {
				int vertex2 = list[vertex].get(index).vertex;
				int weight2 = list[vertex].get(index).weight + weight;
				
				if(distance[vertex2] > weight2) {
					distance[vertex2] = weight2;
					queue.add(new Node(vertex2, weight2));
				}
			}
		}
	}
	
	private static class Node implements Comparable<Node> {
		int vertex;
		int weight;
		
		public Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}
	}
}
