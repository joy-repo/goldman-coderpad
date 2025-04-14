package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Election {

	/**
	 * A group of students are sitting in a circle. The teacher is electing a new
	 * class president. The teacher does this by singing a song while walking around
	 * the circle. After the song is finished the student at which the teacher
	 * stopped is removed from the circle.
	 *
	 * Starting at the student next to the one that was just removed, the teacher
	 * resumes singing and walking around the circle. After the teacher is done
	 * singing, the next student is removed. The teacher repeats this until only one
	 * student is left.
	 *
	 * A song of length k will result in the teacher walking past k students on each
	 * round. The students are numbered 1 to n. The teacher starts at student 1.
	 *
	 * For example, suppose the song length is two (k=2). And there are four
	 * students to start with (1,2,3,4). The first student to go would be `2`, after
	 * that `4`, and after that `3`. Student `1` would be the next president in this
	 * example.
	 *
	 * @param n the number of students sitting in a circle.
	 * @param k the length (in students) of each song.
	 * @return the number of the student that is elected.
	 */
	

    static int whoIsElected1(int n, int k ){
      
      // your code
      
      List<Integer> list = new ArrayList<Integer>();
      for (int i = 1; i <= n; i++)
          list.add(i);
      int pos = k - 1;
      while (list.size() != 1) {
          list.remove(pos);
          pos=(pos+k-1)%list.size();
        
      }
     
      return list.get(0);
      
    }  


	
	
	public static int whoIsElected(int n, int k) {
		if (n == 1)
			return 1;
		return (whoIsElected(n - 1, k) + k - 1) % n + 1;
	}

	public static int whoIsElected2(int n, int k) {
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		int i = -1;
		while (list.size() > 1) {
			list.remove((i + k) % list.size());
			i = (i + k) % (list.size() + 1) - 1;
		}
		return list.getFirst();
	}

	public static int whoIsElected3(int n, int k) {

		boolean[] rejected = new boolean[n + 1];
		Arrays.fill(rejected, false);
		int num_rejected = 0;
		int i = 1;

		while (num_rejected != n - 1) {

			int kt = 0;
			while (kt != k) {
				if (!rejected[i])
					kt++;
				i++;
				if (i > n)
					i = 1;
			}
			if (i == 1)
				rejected[n] = true;
			else
				rejected[i - 1] = true;
			num_rejected++;
		}
		// rejected[0] = true;

		for (int c = 1; c <= n; c++)
			if (!rejected[c])
				return c;

		return -1;

	}

	/**
	 * bool doTestsPass() Runs various tests. Returns true if tests pass. Otherwise,
	 * returns false.
	 */
	public static boolean doTestsPass() {

		int n = whoIsElected3(5, 3);
		System.out.println("---" + n + "------");
		// todo: implement more tests, please
		// feel free to make testing more elegant
		// test cases are structered as {n, k, expected answer}
		int[][] testCases = { { 1, 1, 1 }, { 2, 2, 1 }, { 4, 2, 1 }, { 100, 2, 73 }, { 5, 3, 4 }, { 6, 4, 5 },
				{ 1000, 5, 763 } };

		for (int[] testCase : testCases) {
			int answer = whoIsElected1(testCase[0], testCase[1]);
			if (answer != testCase[2]) {
				System.out.println("test failed!");
				System.out.printf("n:%d, k%d, answer got: %d, should be: %d\n", testCase[0], testCase[1], answer,
						testCase[2]);
				return false;
			}
		}
		System.out.println("All tested passed");
		return true;
	}

	/**
	 * Execution entry point.
	 */
	public static void main(String args[]) {
		doTestsPass();
	}
}