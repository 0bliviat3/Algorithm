#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>

std::vector<int> splitNumber(int n) {
	std::vector<int> digits;
	while (n > 0) {
		digits.push_back(n % 10);
		n /= 10;
	}
	return digits;
}

int multiplyDigits(const std::vector<int>& digits) {
	int product = 1;
	for (int digit : digits) {
		product *= digit;
	}
	return product;
}

int countSteps(int n) {
	int steps = 0;
	while (n >= 10) {
		std::vector<int> digits = splitNumber(n);
		n = multiplyDigits(digits);
		steps++;
	}
	return steps;
}

void solve() {
	int n;
	std::cin >> n;
	std::cout << countSteps(n);
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}