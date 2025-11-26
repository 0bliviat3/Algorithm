#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	std::string n;
	std::getline(std::cin, n);
	int len = n.length();
	int half = len / 2;
	int left_sum = 0;
	int right_sum = 0;
	for (int i = 0; i < half; ++i) {
		left_sum += n[i] - '0';
	}
	for (int i = half; i < len; ++i) {
		right_sum += n[i] - '0';
	}
	if (left_sum == right_sum) {
		std::cout << "LUCKY\n";
	} else {
		std::cout << "READY\n";
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}