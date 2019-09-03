package com.thumati.corejava.clone;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class DistanceMap implements Comparable<DistanceMap> {
	private List<Integer> list;
	private double distance;

	public DistanceMap(List<Integer> list, double distance) {
		this.list = list;
		this.distance = distance;
	}

	public List<Integer> getList() {
		return list;
	}

	public double getDistance() {
		return distance;
	}

	@Override
	public int compareTo(DistanceMap dm) {
		return Double.compare(this.distance, dm.getDistance());
	}

	public static List<List<Integer>> shortestDistances(List<List<Integer>> allLocations, int totalLoc, int totalDis) {

		List<List<Integer>> lists = new ArrayList<>();
		TreeSet<DistanceMap> treeSet = new TreeSet<>();

		for (List<Integer> list : allLocations) {
			treeSet.add(new DistanceMap(list, Math.sqrt(Math.pow(list.get(0), 2) + Math.pow(list.get(1), 2))));
		}

		for (DistanceMap dm : treeSet) {
			lists.add(dm.getList());
		}

		return lists;
	}

	public static void main(String[] args) {

	}
}