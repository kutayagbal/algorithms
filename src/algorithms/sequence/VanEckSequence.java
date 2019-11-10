package algorithms.sequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VanEckSequence {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(0);

		int counter = 1;
		for (int i = 0; i < list.size(); i++) {
			int k = list.get(i);
			list.add(formerBefore(list, k));
			counter++;

			if (counter == 10000)
				break;
		}

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int l : list) {
			Integer count = map.get(l);
			if(count != null)
				map.put(l, count + 1);
			else
				map.put(l, 1);
		}

		Map<Integer, Integer> treeMap = new TreeMap<Integer, Integer>(map);

		for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
	}

	private static int formerBefore(List<Integer> list, Integer num) {
		for (int i = list.size() - 2; i >= 0; i--) {
			if (list.get(i) == num)
				return list.size() - i - 1;
		}

		return 0;
	}

}
