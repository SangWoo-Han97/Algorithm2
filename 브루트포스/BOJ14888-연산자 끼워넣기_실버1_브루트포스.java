import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_14888 {
	static int ADD = 0, SUB = 1, MUL = 2, DIV = 3;
	static int N, max, min;
	static int[] A, operators, output;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		init();
		per(0, N - 1, N - 1);
		System.out.println(max);
		System.out.println(min);
	}

	static void calculate() {
		int res = A[0];
		for (int i = 0; i < N - 1; i++) {
			if (output[i] == ADD) {
				res += A[i + 1];
			} else if (output[i] == SUB) {
				res -= A[i + 1];
			} else if (output[i] == MUL) {
				res *= A[i + 1];
			} else if (output[i] == DIV) {
				res /= A[i + 1];
			}
		}
		if(max < res) {
			max = res;
		}
		if(min > res) {
			min = res;
		}
	}

	static void per(int depth, int n, int r) {
		if (depth == r) {
			calculate();
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				output[depth] = operators[i];
				per(depth + 1, n, r);
				visited[i] = false;
			}
		}
	}

	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		operators = new int[N - 1];
		output = new int[N - 1];
		visited = new boolean[N - 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int idx = 0;
		for (int i = 0; i < 4; i++) {
			int operatorSum = Integer.parseInt(st.nextToken());
			for (int j = 0; j < operatorSum; j++) {
				operators[idx++] = i;
			}
		}
	}
}
