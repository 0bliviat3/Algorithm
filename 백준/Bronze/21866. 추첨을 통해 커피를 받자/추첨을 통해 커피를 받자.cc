#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	int arr[] = { 100, 100, 200, 200, 300, 300, 400, 400, 500};
	int n = 9;
	int sum = 0;
	for (int i = 0; i < n; i++) {
		int x;
		std::cin >> x;
		if (x > arr[i]) {
			std::cout << "hacker";
			return;
		}
		sum += x;
	}
	if (sum >= 100) {
		std::cout << "draw";
	} else {
		std::cout << "none";
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}