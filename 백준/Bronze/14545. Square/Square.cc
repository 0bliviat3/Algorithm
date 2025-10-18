#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	int n;
	std::cin >> n;

	std::vector<long long> arr;
	long long sum = 0;
	for (long long i = 1; i < 1000000; ++i) {
		sum += (i * i);
		arr.push_back(sum);
	}
	while (n--) {
		int m;
		std::cin >> m;
		std::cout << arr[m - 1] << "\n";
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}