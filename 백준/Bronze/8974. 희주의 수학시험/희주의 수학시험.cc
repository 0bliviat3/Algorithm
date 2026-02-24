#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>
#include <unordered_set>

void solve() {

	int arr[1001] = { 0, };
	int end = 1;
	int cnt = 1;
	for (int i = 1; i<= 1000; i++) {
		arr[i] = end + arr[i - 1];
		if (cnt == end) {
			end++;
			cnt = 1;
			continue;
		}
		cnt++;
	}

	int a, b;
	std::cin >> a >> b;
	std::cout << arr[b] - arr[a - 1] << "\n";
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}