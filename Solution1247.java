import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution1247 {
	static ArrayList<Pair> list = new ArrayList<>();
	static boolean[] visited;
	static Pair start;
	static Pair home;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; ++t) {
			int n = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			start = new Pair(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
			home = new Pair(Integer.parseInt(s[2]), Integer.parseInt(s[3]));

			for (int i = 4; i < s.length; i = i + 2) {
				list.add(new Pair(Integer.parseInt(s[i]), Integer.parseInt(s[i + 1])));
			}

			visited = new boolean[n];
			dfs(0);

			System.out.println("#" + (t + 1) + " " + min);

			list.clear();
			min = Integer.MAX_VALUE;
			perm.clear();
		}
	}

	static ArrayList<Pair> perm = new ArrayList<>();
	static int min = Integer.MAX_VALUE;

	private static void dfs(int depth) {
		if (depth == list.size()) {
			int sum = 0;
			perm.add(0, start);
			perm.add(home);
			for (int i = 0; i < perm.size() - 1; i++) {
				sum += Math.abs(perm.get(i).x - perm.get(i + 1).x) + Math.abs(perm.get(i).y - perm.get(i + 1).y);

			}
			perm.remove(0);
			perm.remove(list.size() - 1);
			min = Math.min(min, sum);
		}

		for (int i = 0; i < list.size(); ++i) {
			if (visited[i])
				continue;
			visited[i] = true;
			perm.add(list.get(i));
			dfs(depth + 1);
			perm.remove(perm.size() - 1);
			visited[i] = false;

		}

	}

	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
