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

	int n;
	std::cin >> n;

	std::vector<bool> arr;

	while (n > 0) {
		arr.push_back(n % 2);
		n /= 2;
	}

	int sum = 0;
	int m = 1;
	while (arr.size() > 0) {
		int now = arr.back();
		sum += now * m;
		arr.pop_back();
		m *= 2;
	}

	std::cout << sum << "\n";
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}