package mergsort;

import java.util.ArrayList;

public class MergeSort<T extends Comparable<T>> {

	public ArrayList<T> mergeSort(ArrayList<T> unsortedList) {

		if (unsortedList.size() <= 1) {
			return unsortedList;
		}
		// trash list for splits
		ArrayList<T> left = new ArrayList<T>();
		ArrayList<T> right = new ArrayList<T>();
		int middel = unsortedList.size() / 2;
		// Splits the unsortedList into unsortedListS lest and right
		for (int i = 0; i < unsortedList.size(); i++) {
			if (i < middel) {
				left.add(unsortedList.get(i));
			} else {
				right.add(unsortedList.get(i));
			}
		}
		
		left = mergeSort(left);
		right = mergeSort(right);
		// merge this list @see copy constructor at Binary tree realization
	return merge(unsortedList,left, right);
	}

	private ArrayList<T> merge(ArrayList<T> buffList,ArrayList<T> left, ArrayList<T> right) {
		// prepare list
		buffList.clear();
		while (left.size() > 0 || right.size() > 0) {

			if (left.size() > 0 && right.size() > 0) {
// 				< or > direction of sort 
				if (left.get(0).compareTo(right.get(0)) < 0) {
					buffList.add(left.get(0));
					left.remove(0);
				} else {
					buffList.add(right.get(0));
					right.remove(0);
				}
			} else if (left.size() > 0) {
				buffList.add(left.get(0));
				left.remove(0);
			} else if (right.size() > 0) {
				buffList.add(right.get(0));
				right.remove(0);
			}

		}
		return buffList;
	}

}
