package algorithms.dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
	public static void main(String[] args) {
		DijkstraGraph g = initGraph();
		findShortestPath(g, g.nodes.get(0), g.nodes.get(4));

		DijkstraNode currentNode = g.nodes.get(4);
		while (currentNode != null) {
			System.out.print(currentNode.id + " <- ");
			currentNode = currentNode.shortestNeighbour;
		}
		
		System.out.println("\nShortest Path Distance: " + g.nodes.get(4).distance);
	}

	private static void findShortestPath(DijkstraGraph graph, DijkstraNode startNode, DijkstraNode endNode) {
		PriorityQueue<DijkstraNode> priorityQueue = new PriorityQueue<>();
		for (DijkstraNode node : graph.nodes) {
			if (node.id == startNode.id) {
				node.distance = 0;
				priorityQueue.add(node);
			} else {
				node.distance = Integer.MAX_VALUE;
			}
		}

		while (!priorityQueue.contains(endNode)) {
			DijkstraNode minDistanceNode = priorityQueue.remove();

			for (DijkstraNode node : minDistanceNode.adjacenciesWithEdgeWeight.keySet()) {
				int edgeToNode = minDistanceNode.adjacenciesWithEdgeWeight.get(node);
				if (minDistanceNode.distance + edgeToNode < node.distance) {
					node.distance = minDistanceNode.distance + edgeToNode;
					// node.path.add(node.id);
					node.shortestNeighbour = minDistanceNode;
					priorityQueue.add(node);
				}
			}
		}
	}

	public static DijkstraGraph initGraph() {
		DijkstraGraph graph = new DijkstraGraph();

		DijkstraNode n0 = new DijkstraNode(0);
		DijkstraNode n1 = new DijkstraNode(1);
		DijkstraNode n2 = new DijkstraNode(2);
		DijkstraNode n3 = new DijkstraNode(3);
		DijkstraNode n4 = new DijkstraNode(4);
		DijkstraNode n5 = new DijkstraNode(5);
		DijkstraNode n6 = new DijkstraNode(6);
		DijkstraNode n7 = new DijkstraNode(7);
		DijkstraNode n8 = new DijkstraNode(8);

		n0.adjacenciesWithEdgeWeight.put(n1, 4);
		n0.adjacenciesWithEdgeWeight.put(n7, 12);

		n1.adjacenciesWithEdgeWeight.put(n0, 4);
		n1.adjacenciesWithEdgeWeight.put(n2, 8);
		n1.adjacenciesWithEdgeWeight.put(n7, 11);

		n2.adjacenciesWithEdgeWeight.put(n1, 8);
		n2.adjacenciesWithEdgeWeight.put(n2, 7);
		n2.adjacenciesWithEdgeWeight.put(n5, 8);
		n2.adjacenciesWithEdgeWeight.put(n8, 2);

		n3.adjacenciesWithEdgeWeight.put(n2, 7);
		n3.adjacenciesWithEdgeWeight.put(n4, 9);
		n3.adjacenciesWithEdgeWeight.put(n5, 14);

		n4.adjacenciesWithEdgeWeight.put(n3, 9);
		n4.adjacenciesWithEdgeWeight.put(n5, 10);

		n5.adjacenciesWithEdgeWeight.put(n2, 8);
		n5.adjacenciesWithEdgeWeight.put(n3, 14);
		n5.adjacenciesWithEdgeWeight.put(n4, 10);
		n5.adjacenciesWithEdgeWeight.put(n6, 3);

		n6.adjacenciesWithEdgeWeight.put(n5, 3);
		n6.adjacenciesWithEdgeWeight.put(n7, 5);
		n6.adjacenciesWithEdgeWeight.put(n8, 2);

		n7.adjacenciesWithEdgeWeight.put(n0, 12);
		n7.adjacenciesWithEdgeWeight.put(n1, 11);
		n7.adjacenciesWithEdgeWeight.put(n6, 5);
		n7.adjacenciesWithEdgeWeight.put(n8, 7);

		n8.adjacenciesWithEdgeWeight.put(n2, 2);
		n8.adjacenciesWithEdgeWeight.put(n6, 2);
		n8.adjacenciesWithEdgeWeight.put(n7, 7);

		graph.nodes.add(n0);
		graph.nodes.add(n1);
		graph.nodes.add(n2);
		graph.nodes.add(n3);
		graph.nodes.add(n4);
		graph.nodes.add(n5);
		graph.nodes.add(n6);
		graph.nodes.add(n7);
		graph.nodes.add(n8);

		return graph;
	}

	private static class DijkstraNode implements Comparable<DijkstraNode> {
		public Map<DijkstraNode, Integer> adjacenciesWithEdgeWeight;
		public int distance;
		public int id;
		public DijkstraNode shortestNeighbour;

		public DijkstraNode(int id) {
			this.id = id;
			adjacenciesWithEdgeWeight = new HashMap<>();
		}

		@Override
		public int compareTo(DijkstraNode node) {
			if (this.distance > node.distance) {
				return 1;
			} else if (this.distance == node.distance) {
				return 0;
			}

			return -1;
		}

	}

	private static class DijkstraGraph {
		public ArrayList<DijkstraNode> nodes;

		public DijkstraGraph() {
			nodes = new ArrayList<>();
		}

	}
}
