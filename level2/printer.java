package level2;

import java.util.LinkedList;
import java.util.Queue;

public class printer {

	static int printCnt = 0;
	static Queue<Integer> queue = new LinkedList<Integer>();

	public static void main(String[] args) {

		int[] priorities = { 2, 1, 3, 2 };
		int location = 2;

		for (int prioritie : priorities)
			queue.add(prioritie);

		int targetNum = 0;

		if (priorities.length == 1) {
			System.err.println("printCnt: " + 1);
			return;
		}

		targetNum = queue.poll();

		while (true) {

			if (location == 0) {
				boolean flag = priority(queue, targetNum);
				if (flag) {
					System.err.println("printCnt: " + printCnt);
					return;
				} else {
					location = queue.size() - 1;
				}
			} else {
				priority(queue, targetNum);
				location -= 1;
			}
			targetNum = queue.poll();
		}
	}

	public static boolean priority(Queue<Integer> queue, int targetNum) {

		int quueuSize = queue.size();
		int queueTmepNum = 0;

		boolean flag = true;

		for (int i = 0; i < quueuSize; i++) {
			queueTmepNum = queue.poll();
			if (targetNum < queueTmepNum) {
				flag = false;
			}
			queue.add(queueTmepNum);
		}
		if (flag) {
			printCnt++;
		} else {
			queue.add(targetNum);
		}
		return flag;
	}
}

/*
 * 1. 큐로 구현하고 location를 들고 다니자 2. location이 0이 되고 큐에 우선순위가 더 높은 숫자가 없으면 그대로
 * 출력cnt 리턴 큐에 우선순위가 더 높은 숫자가 있다면 location은 큐의 size로 location -= 1;
 */
