	class Solution {
		public int numberOfGoodPaths(int[] vals, int[][] es) {
			int n = vals.length;
			int[][] vi = new int[n][];
			for(int i = 0;i < n;i++){
				vi[i] = new int[]{vals[i], i};
			}
			Arrays.sort(vi, (x, y) -> {
				if (x[0] != y[0]) return x[0] - y[0];
				return (x[1] - y[1]);
			});

			int[][] g = packU(n, es);

			DJSet ds = new DJSet(n);
			int[] f = new int[n];
			int ans = 0;
			for(int i = 0;i < n;){
				int j = i;
				while(i < n && vi[i][0] == vi[j][0])i++;

				for(int k = j;k < i;k++){
					for(int e : g[vi[k][1]]){
						if(vals[e] <= vi[j][0]){
							ds.unite(vi[k][1], e);
						}
					}
				}
				for(int k = j;k < i;k++){
					ans += ++f[ds.root(vi[k][1])];
				}
				for(int k = j;k < i;k++){
					f[ds.root(vi[k][1])]--;
				}
			}
			return ans;
		}

		public int[][] packU(int n, int[][] ft)
		{
			int[][] g = new int[n][];
			int[] p = new int[n];
			for(int[] u : ft){
				p[u[0]]++; p[u[1]]++;
			}
			for(int i = 0;i < n;i++)g[i] = new int[p[i]];
			for(int[] u : ft){
				g[u[0]][--p[u[0]]] = u[1];
				g[u[1]][--p[u[1]]] = u[0];
			}
			return g;
		}


		public class DJSet {
			public int[] upper;

			public DJSet(int n) {
				upper = new int[n];
				Arrays.fill(upper, -1);
			}

			public int root(int x) {
				return upper[x] < 0 ? x : (upper[x] = root(upper[x]));
			}

			public boolean equiv(int x, int y) {
				return root(x) == root(y);
			}

			public boolean unite(int x, int y) {
				x = root(x);
				y = root(y);
				if (x != y) {
					if (upper[y] < upper[x]) {
						int d = x;
						x = y;
						y = d;
					}
					upper[x] += upper[y];
					upper[y] = x;
				}
				return x == y;
			}

			public int count() {
				int ct = 0;
				for (int u : upper) if (u < 0) ct++;
				return ct;
			}

			public int[][] toBucket() {
				int n = upper.length;
				int[][] ret = new int[n][];
				int[] rp = new int[n];
				for (int i = 0; i < n; i++) if (upper[i] < 0) ret[i] = new int[-upper[i]];
				for (int i = 0; i < n; i++) {
					int r = root(i);
					ret[r][rp[r]++] = i;
				}
				return ret;
			}
		}

	}