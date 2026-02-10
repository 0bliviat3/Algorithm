#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>

void solve() {

	int n, m;
	std::cin >> n >> m;
	std::vector<int> arr(n);

	for (int i = 0; i < n; ++i) {
		std::cin >> arr[i];
	}

	int cnt = 0;
	for (int i = n - 1; i > 0; i--) {
		int max = 0;
		int max_idx = -1;
		for (int j = 0; j <= i; j++) {
			if (max < arr[j]) {
				max = arr[j];
				max_idx = j;
			}
		}
		if (max != arr[i]) {
			int tmp = arr[i];
			arr[i] = max;
			arr[max_idx] = tmp;
			cnt++;
			if (cnt == m) {
				for (int k = 0; k < n; k++) {
					std::cout << arr[k] << " ";
				}
				return;
			}
		}
	}
	std::cout << -1 << "\n";


}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}