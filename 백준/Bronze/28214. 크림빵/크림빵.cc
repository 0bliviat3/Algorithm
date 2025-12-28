#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	int n, k, p;

	std::cin >> n >> k >> p;

	int m = n * k;
	int count = 0;
	int cnt = 0;
	for (int i = 0; i < m; ++i) {
		int x;
		std::cin >> x;
		if (i % k == 0) {
			cnt = 0;
		}
		if (!x) {
			cnt++;
		}
		if ((i % k == k - 1) && cnt < p) {
			count++;
		}
	}

	std::cout << count;

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}